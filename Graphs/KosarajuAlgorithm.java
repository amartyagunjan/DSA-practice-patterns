
import java.util.*;

public class KosarajuAlgorithm {
	public static void main(String args[]) throws Exception {
    
        try (// code for Input
        Scanner scn = new Scanner(System.in)) {
            int v = scn.nextInt();
            int e = scn.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
            for(int i = 0; i <= v; i++){
                graph.add(new ArrayList<Integer>());
                ngraph.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < e; i++){
                int u = scn.nextInt() -1 ;
                int vl = scn.nextInt() - 1;
                graph.get(u).add(vl);
                ngraph.get(vl).add(u);
            }
            
            //step 1
            LinkedList<Integer> stack = new LinkedList<>();
            boolean[] vis = new boolean[v];
            
            for(int i = 0; i < v; i++){
                if(vis[i] == false){
                    dfs1(i, graph, vis, stack);
                }
            }
            
            //step 2 
            
            vis = new boolean[v];
            int ans = 0;
            while(stack.size() > 0){
                int rem = stack.removeFirst();
                if(!vis[rem]){
                    dfs2(rem, ngraph, vis);
                    ans++;
                }
            }
            
            System.out.println(ans);
        }
    }
    
    public static void dfs1(int src, ArrayList<ArrayList<Integer>> graph , boolean[] vis, LinkedList<Integer> stack){
        vis[src] = true;
        
        ArrayList<Integer> nbrs = graph.get(src);
        
        for(int nbr : nbrs){
            if(!vis[nbr]){
                dfs1(nbr, graph, vis, stack);
            }
        }
        
        stack.addFirst(src);
    }
    
    public static void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
        vis[src] = true;
        
        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs){
            if(!vis[nbr]){
                dfs2(nbr, graph, vis);
            }
        }
    }

}
