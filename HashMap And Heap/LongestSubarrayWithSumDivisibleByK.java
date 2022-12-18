import java.util.*;

public class LongestSubarrayWithSumDivisibleByK {

    public static int solution(int[] arr, int k) {
        int ls = 0;

        // create a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum , -1); // map < sum, index >

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int rem = sum % k;

            if(rem < 0){
                rem += k;
            }

            if(map.containsKey(rem) == false){
                map.put(rem, i);
            }
            else{
                int pIndx = map.get(rem);
                ls = Math.max((i-pIndx) , ls);
            }

        }
        return ls;

    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
