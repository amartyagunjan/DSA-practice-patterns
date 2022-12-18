import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestBridge {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }

  public static int shortestBridge(int[][] A) {
      int n = A.length;
    LinkedList<Pair> queue = new LinkedList<>();
    boolean[][] vis = new boolean[n][n];
    boolean flag = false;
    
    for(int i = 0; i < n && flag == false ; i++){
        for(int j = 0; j < n && flag == false; j++){
            if(A[i][j] == 1){
                dfs(i, j, A, vis, queue);
                flag = true;
            }
        }
    }
    
    int level = 0;
    while(queue.size() > 0){
        int size = queue.size();
        while(size-- > 0){
            Pair rem = queue.removeFirst();
            
            for(int i = 0; i < dirs.length; i++){
                int rowdash = rem.x + dirs[i][0];
                int coldash = rem.y + dirs[i][1];
                
                if(rowdash >= 0 && coldash >= 0 && rowdash < n && coldash < n && vis[rowdash][coldash] == false){
                    if(A[rowdash][coldash] == 1){
                        return level;
                    }
                    else{
                        vis[rowdash][coldash] = true;
                        queue.addLast(new Pair(rowdash, coldash));
                    }
                }
            }
            
        }
        level++;
    }
    return -1;
  }
  
  public static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  
  public static void dfs(int i, int j, int[][] A, boolean[][] vis, LinkedList<Pair> queue){
      if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0 || vis[i][j] == true){
          return;
      }
      vis[i][j] = true;
      queue.addLast(new Pair(i, j));
      
      dfs(i-1, j, A, vis, queue);
      dfs(i, j +1, A, vis, queue);
      dfs(i+1, j, A, vis, queue);
      dfs(i , j-1, A, vis, queue);
  }
  
  public static class Pair{
      int x;
      int y;
      
      Pair(int x, int y){
          this.x = x;
          this.y = y;
      }
  }
}
