import java.util.*;

public class SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement {

    public static void solution(int[] arr) {
        // write your code here
		HashMap<Integer, Integer> freq = new HashMap<>();
		HashMap<Integer, Integer> fo = new HashMap<>();
		
		int hf = 1;
		int si = 0 ; // smallest index
		int hi = 0; // highest index
		int length = Integer.MAX_VALUE;

		for(int i = 0; i < arr.length; i++){
			int val = arr[i];
			freq.put(val, freq.getOrDefault(val, 0) + 1);
			if(!fo.containsKey(val)){
				fo.put(val, i);
			}
			if(freq.get(val) == hf){
				int l  = i - fo.get(val) + 1;
				if(l < length ){
					si = fo.get(val);
					hi = i;
					length = l;
				}
				//hf = freq.get(val);
			}
			else if(freq.get(val) > hf){
				si = fo.get(val);
				hi = i;
				length = i - fo.get(val) + 1;
				hf = freq.get(val);
			}
		}
        // int val = 0;
		// for(int num : freq.KeySet()){
		// 	if(freq.get(num) == length){

		// 	}
		// }
		System.out.println(arr[si]);
        System.out.println(si);
		System.out.println(hi);
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
                solution(arr);
	}

}
