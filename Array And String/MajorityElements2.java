
import java.util.*;

public class MajorityElements2 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int val1 = arr[0];
        int count1 = 1;
        
        int val2 = arr[0];
        int count2 = 0;
        
        int i = 1;
        while(i < arr.length){
            if(arr[i] == val1){
                count1++;
            }
            else if(arr[i] == val2){
                count2++;
            }
            else{
                if(count1 == 0){
                    val1 = arr[i];
                    count1 = 1;
                }
                else if(count2 == 0){
                    val2 = arr[i];
                    count2 = 1;
                }
                else{
                    count1--;
                    count2--;
                }
            }
            
            i++;
        }
        
        count1 = 0;
        count2 = 0;
        for(i = 0; i < arr.length; i++){
            if(arr[i] == val1){
                count1++;
            }
            if(arr[i] == val2){
                count2++;
            }
        }
        //System.out.println(count1  + " " + count2);
        
        ArrayList<Integer> arrl = new ArrayList<>();
        if(count1 > arr.length/3){
            arrl.add(val1);
        }
        if(count2 > arr.length/3){
            arrl.add(val2);
        }
        return arrl;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}