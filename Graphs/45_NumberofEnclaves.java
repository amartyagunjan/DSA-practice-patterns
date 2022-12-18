// Leetcode q_no : 1020

class Solution {
    public int numEnclaves(int[][] grid) {
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)
                dfs(grid,i,j);
          }
      }
      int ans=0;
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]==1)
                ans++;
          }
      }
      return ans;
    }
  public void dfs(int[][]arr, int i, int j){
      if(i>=0 && j>=0 && i<arr.length && j<arr[0].length && arr[i][j]==1){
          arr[i][j]=0;
          dfs(arr,i+1,j);
          dfs(arr,i-1,j);
          dfs(arr,i,j+1);
          dfs(arr,i,j-1);
      }
  }
}