import java.util.*;

public class LongestSubarrayWithEqualNumberOfZeroesAndOnes {

    public static int solution(int[] arr) {
        int ls = 0;

        // HashMap of < sum, index >
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, -1);

        // loop
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1) 
                sum += 1;
            else
                sum += -1;

            if(map.containsKey(sum) == false)
                map.put(sum, i);
            else
            {
                int pIndx = map.get(sum);
                ls = Math.max((i-pIndx), ls);
            };
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
        System.out.println(solution(arr));
    }

}
