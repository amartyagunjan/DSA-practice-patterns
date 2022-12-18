import java.io.*;
import java.util.*;

public class MinimumCostToConnectAllCities {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[vtces];
    
    pq.add(new Pair(0, 0));
    int res = 0;
    
    while(pq.size() > 0){
        Pair rem = pq.remove();
        
        if(!visited[rem.val]){
            visited[rem.val] = true;
            res += rem.wt;
            for(Edge e : graph.get(rem.val)){
                if(!visited[e.v]){
                    pq.add(new Pair(e.v, e.wt));
                }
            }
        }
    }
    
    System.out.println(res);
    
  }
  
  public static class Pair implements Comparable<Pair>{
      int val;
      int wt;
      
      Pair(int val , int wt){
          this.val = val;
          this.wt = wt;
      }
      
      public int compareTo(Pair o){
          return this.wt - o.wt;
      }
  }

}
