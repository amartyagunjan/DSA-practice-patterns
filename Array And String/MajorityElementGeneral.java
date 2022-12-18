
import java.util.*;

public class MajorityElementGeneral {
    
    //~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        ArrayList<Integer> arrl = new ArrayList<>();
        
        for(int key : map.keySet()){
            if(map.get(key) > arr.length/k){
                arrl.add(key);
            }
        }
        
        Collections.sort(arrl);
        return arrl;
    }
    
    //~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            int k = scn.nextInt();
            ArrayList<Integer> res = majorityElement(arr, k);
            System.out.println(res);
        }
    }
}