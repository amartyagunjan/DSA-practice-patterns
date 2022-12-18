import java.util.*;

public class KAnagrams {
	public static boolean areKAnagrams(String str1, String str2, int k) {
		
		if(str1.length() != str2.length())
		    return false;

		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<str1.length(); i++){
		    map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
		}

		for(int i=0; i<str2.length(); i++){
		    if(map.getOrDefault(str2.charAt(i), 0) > 0)
		        map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
		}

		int count = 0;

		for(char ch : map.keySet() ){
		    count += map.get(ch);
		}

        if(count <= k)
            return true;
			
		return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}