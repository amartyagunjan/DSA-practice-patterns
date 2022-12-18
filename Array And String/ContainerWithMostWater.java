import java.util.*;

public class ContainerWithMostWater{
    public static void main(String args[]){
        try (// write your code here
        Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scn.nextInt();
            }
            int i = 0;
            int j = arr.length - 1;
            int area = 0;

            while(i < j){
                int temp = Math.min(arr[i], arr[j])* (j-i);
                area = Math.max(area,temp);
                if(arr[i] < arr[j]){
                    i++;
                }
                else{
                    j--;
                }
            }
            
            System.out.println(area);
        }

    }
}