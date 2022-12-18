import java.util.*;

public class MaxChunksToMakeArraySorted2 {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        int res = 0;
        int[] rmin = new int[arr.length + 1];
        int min = Integer.MAX_VALUE;
        rmin[arr.length] = min;
        for (int i = arr.length - 1; i >= 0; i--) {
            min = Math.min(arr[i], min);
            rmin[i] = min;
        }

        // int[] lmax = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (rmin[i + 1] >= max)
                res++;
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
