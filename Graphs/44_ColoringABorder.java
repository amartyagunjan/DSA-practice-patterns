// Leetcode q_no : 1034

class Solution {
    public int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]<0)
                grid[i][j]=color;
          }
      }
      return grid;
    }
      public void dfs(int[][]arr, int row, int col , int clr){
      int count=0;
      arr[row][col]=-clr;
      for(int i=0;i<4;i++){
          int r=row+dir[i][0];
          int c=col+dir[i][1];
          if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || Math.abs(arr[r][c])!=clr)
            continue;
          count++;
          if(arr[r][c]>0)
              dfs(arr,r,c,clr);
      }
      if(count==4){
          arr[row][col]=clr;
      }
      return;
  }
}