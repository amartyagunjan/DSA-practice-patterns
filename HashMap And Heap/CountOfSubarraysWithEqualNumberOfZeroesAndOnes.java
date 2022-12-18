import java.util.*;

public class CountOfSubarraysWithEqualNumberOfZeroesAndOnes {

    public static int solution(int[] arr) {
        int count = 0;

        // HashMap of < sum, index >
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);

        // loop
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1) 
                sum += 1;
            else
                sum += -1;

            if(map.containsKey(sum) == false)
                map.put(sum, 1);
            else
            {
                int pf = map.get(sum);
                count += pf;
                map.put(sum, pf+1);
            };
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
        System.out.println(solution(arr));
    }

}
