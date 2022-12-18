import java.util.*;

public class CountOfSubarraysWithSumDivisibleByK {

    public static int solution(int[] arr, int k) {
        // write your code here
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int rem = 0;
        map.put(sum , 1);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;
            
            if(rem  < 0){
                rem += k;
            }

            if(map.containsKey(rem) == false){
                map.put(rem, 1);
            }
            else{
                int freq = map.get(rem);
                count += freq;
                map.put(rem, freq + 1);
            }
        }

        return count;
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
