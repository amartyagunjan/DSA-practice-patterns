import java.util.*;

public class MaxChunksToMakeArraySorted {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted(int[] arr) {
        // write your code here   
        
        int max = 0; 
        int cc = 0; // chuncks count

        // chaining technique
        
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max , arr[i]);
            
            if(max == i){
                cc++;
            }
        }
        
        return cc;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }

            int res = maxChunksToSorted(arr);
            System.out.println(res);
        }
    }
}