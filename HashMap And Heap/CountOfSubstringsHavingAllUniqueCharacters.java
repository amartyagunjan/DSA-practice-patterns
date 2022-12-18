import java.util.*;

public class CountOfSubstringsHavingAllUniqueCharacters {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

	public static int solution(String str) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0;
        int j = 0;
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            while(map.containsKey(ch)){
                char chj = str.charAt(j);
                map.put(chj,map.get(chj) - 1);
                if(map.get(chj) <= 0){
                    map.remove(chj);
                }
                j++;
            }
            res += (i - j + 1);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        
        return res;
    }

}       