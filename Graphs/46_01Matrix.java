// Leetcode q_no : 542

class Solution {
    public static class Pair{
    int r;
    int c;
    Pair(int r, int c){
      this.r = r;
      this.c = c;
    }
  }
    public int[][] updateMatrix(int[][] matrix) {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    LinkedList<Pair> queue = new LinkedList<>();
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j]==0){    
          queue.addLast(new Pair(i, j));
        }else{
          matrix[i][j] = -1;
        }
      }
    } 
    while(queue.size() != 0){
      Pair rem = queue.removeFirst();
      for(int i = 0; i < dir.length; i++){
        int nrow = rem.r + dir[i][0];
        int ncol = rem.c + dir[i][1];

        if(nrow >= 0 && ncol >= 0 && nrow < matrix.length && ncol < matrix[0].length && matrix[nrow][ncol]== -1){
          matrix[nrow][ncol] = matrix[rem.r][rem.c] + 1;
          queue.addLast(new Pair(nrow, ncol));
        }
      }

    }

    return matrix;
    }
}