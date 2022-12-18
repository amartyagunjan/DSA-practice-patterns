import java.util.*;

public class SquaresOfASortedArray {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[nums.length];
        int indx = nums.length -1 ;

        while(i <= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                res[indx] = (int)Math.pow(nums[i], 2);
                i++;
            }
            else{
                res[indx] = (int)Math.pow(nums[j], 2);
                j--;
            }
            indx--;
        }
        return res;
    }
    
    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] nums = new int[n];
            
            for(int i = 0; i < n; i++) 
                nums[i] = scn.nextInt();
            
            int[] res = sortedSquares(nums);

            for(int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
}