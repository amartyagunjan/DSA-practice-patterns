
import java.util.*;
import java.io.*;

class CriticalConnection {

  static int[] parent;
  static int[] disc;
  static int[] low;
  static int time;
  static boolean[] vis;
  static boolean[] ac;

  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
    // number of vertices and ArrayList of Edges are given...
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList<Integer>());
    }

    for(int i = 0; i < Edges.size(); i++){
      int u = Edges.get(i).get(0);
      int v = Edges.get(i).get(1);
      graph.get(u).add(v);
      graph.get(v).add(u);      
    } // graph is ready.


    // step 2 : intialize variables
    parent = new int[n];
    disc = new int[n];
    low = new int[n];
    vis = new boolean[n];
    ac = new boolean[n];
    time = 0;

    parent[0] = -1;
    List<List<Integer>> ans = new ArrayList<>();
    dfs(0, graph, ans); 
    return ans;   

  }

  public static void dfs(int u, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans){
    disc[u] = low[u] = time;
    time++;
    vis[u] = true;

    ArrayList<Integer> nbrs = graph.get(u);
    for(int i = 0; i < nbrs.size(); i++){
      int v = nbrs.get(i);
      
      if(parent[u] == v){
        continue;
      }
      else if(vis[v]){
        low[u] = Math.min(low[u], disc[v]);
      }
      else{
        parent[v] = u;
        dfs(v, graph, ans);
        low[u] = Math.min(low[u], low[v]);
        if(low[v] > disc[u]){
          List<Integer> temp = new ArrayList<>();
          temp.add(u);
          temp.add(v);
          ans.add(temp);
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }

}