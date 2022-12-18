import java.util.*;

public class MaxProductOfThreeNumbers {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
        // write your code here
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        

        // yahan maza aaya, sikha kaise consequtive max ya min nikalte hai...
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num > min1 && num < min2){
                min2 = num;
            }
            
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num > max2){
                max3 = max2;
                max2 = num;
            }
            else if(num > max3){
                max3 = num;
            }
            
        }
        // System.out.println( min1 + " " + min2 + " " + max1);
        // System.out.println(max1 + " " + max2 + " " + max3);
        int res = Math.max(min1 * min2 * max1, max1 * max2 * max3);
        return res;
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}