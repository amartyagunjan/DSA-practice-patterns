import java.util.*;

public class ProductOfArrayExceptItselfWithoutUsingDivisionOperator {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        // write your code here
        int n = arr.length;
        int[] prev = new int[n];
        prev[0] = 1;
        for (int i = 1; i < n; i++) {
            prev[i] = prev[i - 1] * arr[i - 1];
        }

        int[] next = new int[n];
        next[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            next[i] = next[i + 1] * arr[i + 1];
        }

        int[] ans = new int[n];
        // ans[0] = next[0];
        // ans[n-1] = prev[n-1];
        for (int i = 0; i < n; i++) {
            ans[i] = prev[i] * next[i];
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}