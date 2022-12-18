import java.util.*;

// copy and paste the code in leetcode console 
// q no : 781

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ;i < answers.length ;i++) {
			map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
		}
		
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		ArrayList<Integer> values = new ArrayList<Integer>(map.values());
		int ans = 0;
		for(int i = 0 ;i < keys.size() ; i++) {
			int key = keys.get(i);
			int val = values.get(i);
			if(key >= val) {
				ans += (key + 1);
			}else {
				if(val % (key + 1) == 0) {
					ans += ((val / (key + 1)) * (key + 1));
				}else {
					ans += (((val / (key + 1)) + 1) * (key + 1));
				}
			}
		}
		
		return ans;
    }
}