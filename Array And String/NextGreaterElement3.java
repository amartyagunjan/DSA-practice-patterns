
import java.util.*;

public class NextGreaterElement3 {
    
    //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        // write your code here
        int n = str.length();
        int i = n-1;
        for( i = n-1; i > 0; i--){
            if(str.charAt(i) - '0' > str.charAt(i-1) - '0'){
                //i++;
                break;
            }
            if(i == 1){
                return "-1";
            }
        }
        
        int j = n-1;
        for(j = n-1; j >= i; j--){
            if(str.charAt(j) > str.charAt(i-1)){
                break;
            }
        }
        
        // making of arraylist and sorting it
        ArrayList<Integer> arrl = new ArrayList<>();        
        str =  str.substring(0, i-1) + str.charAt(j) + str.substring(i, j) + str.charAt(i-1) + str.substring(j+1, n); 
        
        for(j = n-1; j >=i; j--){
            arrl.add(str.charAt(j) - '0');
        }
        
        Collections.sort(arrl);        

        // forming string again after sorting 
        str = str.substring(0, i);        
        for(int ch : arrl){
            str += ch;
        }        
        return str;
        
        
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}