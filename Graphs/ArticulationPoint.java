import java.util.*;

class ArticulationPoint {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static int time;
    static boolean[] vis;
    static boolean[] ap;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int e = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < e; i++) {
            int s = scn.nextInt() - 1; // self
            int n = scn.nextInt() - 1; // neighbour
            graph.get(s).add(n);
            graph.get(n).add(s);
        }

        parent = new int[v];
        disc = new int[v];
        low = new int[v];
        time = 0;
        vis = new boolean[v];
        ap = new boolean[v];
        parent[0] = -1;// important
        dfs(0, graph);

        int count = 0;
        for (int i = 0; i < v; i++) {
            if (ap[i] == true) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        disc[u] = low[u] = time;
        time++;
        int count = 0;
        vis[u] = true;

        ArrayList<Integer> nbrs = graph.get(u);

        for (int i = 0; i < nbrs.size(); i++) {
            int v = nbrs.get(i);

            if (parent[u] == v) { // parent array should have initial value as -1;
                continue;
            } else if (vis[v] == true) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;
                count++;
                dfs(v, graph);
                low[u] = Math.min(low[u], low[v]);

                // the following is the diffrence between the articulation and critical connection problem.
                if (parent[u] == -1) {
                    // it is the start point of the segment tree.
                    if (count >= 2) {
                        ap[u] = true;
                    }
                } else {
                    if (low[v] >= disc[u]) {
                        ap[u] = true;
                    }
                }
            }

        }
    }
}