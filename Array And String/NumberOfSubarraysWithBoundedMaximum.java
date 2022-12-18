import java.util.*;

public class NumberOfSubarraysWithBoundedMaximum {

    public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
        // write your code here
        int ans = 0;
        int count = 0;
        // int max = Integer.MIN_VALUE;
        int si = 0;
        for (int i = 0; i < arr.length; i++) {
            // max = Math.max(max, arr[i]);
            if (arr[i] >= left && arr[i] <= right) {

                count = i - si + 1;
                // System.out.println("count : " + count);
                ans += count;
            } else if (arr[i] < left) {
                // System.out.println("count : " + count);
                ans += count;
            } else if (arr[i] > right) {
                si = i + 1;
                count = 0;
                // max = Integer.MIN_VALUE;
                // System.out.println("count : " + count);
            }

            // System.out.println("ans : " + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int left = scn.nextInt();
        int right = scn.nextInt();

        int count = numSubarrayBoundedMax(arr, left, right);
        System.out.println(count);
    }
}