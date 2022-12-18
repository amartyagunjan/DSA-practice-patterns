class Solution {
    public static int slidingPuzzle(int[][] board) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<board.length;++i)
          for(int j=0;j<board[0].length;++j) 
              sb.append(board[i][j]);
          
          String initial=sb.toString();
          String tar="123450";
          Queue<String> q=new LinkedList<>();
          q.add(initial);
          int level=0;
          HashSet<String> hs=new HashSet<>();
          hs.add(initial);
          int [][]dirs={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{4,2}};
          while(q.size()>0)
          {
              int size=q.size();
              while(size-->0){
                  String rem=q.remove();
                  if(rem.equals(tar)) return level;
                  int idx=-1;
                  for(int i=0;i<rem.length();++i)
                      if(rem.charAt(i)=='0')
                      {
                          idx=i;
                          break;
                      }
                  int []arr=dirs[idx];
                  for(int i=0;i<arr.length;++i)
                  {
                      String ns=swap(rem,idx,arr[i]);
                      if(hs.contains(ns)) continue;
                      hs.add(ns);
                      q.add(ns);
                  }
              }
              ++level;
              
          }
          return -1;
              
  
    }
    
    public static String swap(String s1,int i,int j){
        StringBuilder sb=new StringBuilder(s1);
        sb.setCharAt(i,s1.charAt(j));
        sb.setCharAt(j,s1.charAt(i));
        return sb.toString();
    }
  }