import java.util.*;

public class ReverseVowelsOfAString {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static String swap(String s, int i, int j) {
        // char ci = s.charAt(i);
        // char cj = s.charAt(j);
        s = s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j) + s.charAt(i) + s.substring(j + 1, s.length());
        return s;
    }

    public static String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        // write your code here
        int si = 0;
        int ei = s.length() - 1;
        while (si < ei) {
            char sc = s.charAt(si);
            char ec = s.charAt(ei);
            if (!vowels.contains(sc)) {
                si++;
            }
            if (!vowels.contains(ec)) {
                ei--;
            }
            if (vowels.contains(sc) && vowels.contains(ec)) {
                s = swap(s, si, ei);
                si++;
                ei--;
            }

        }
        return s;

    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String res = reverseVowels(str);
        System.out.println(res);
    }
}
