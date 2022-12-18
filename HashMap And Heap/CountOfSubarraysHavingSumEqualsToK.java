import java.util.*;

public class CountOfSubarraysHavingSumEqualsToK {

	public static int solution(int[] arr, int target){
		int count = 0;

        // HashMap of  < sum , frequency >
        HashMap< Integer , Integer > map = new HashMap<>();
        int sum = 0;
        map.put(sum , 1);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            if(map.containsKey(sum) == false){
                map.put(sum, 1);
            }
            else{
                int freq = map.get(sum);
                map.put(sum, freq + 1);
            }
            if(map.containsKey(sum - target) == true){
                int freq = map.get(sum - target);
                count += freq;
            }
        }
        return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
