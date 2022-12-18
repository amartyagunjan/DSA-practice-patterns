import java.util.*;

public class SortArrayByParity {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~

    // public static boolean is ec

    public static void sortArrayByParity(int[] nums) {

        // 1. travel with odd index and even index
        int ei = 0;
        int oi = 0;
        while (ei < nums.length) {
            if (nums[ei] % 2 == 0) {
                // swap
                int temp = nums[ei];
                nums[ei] = nums[oi];
                nums[oi] = temp;
                ei++;
                oi++;
            } else {
                // ei element is odd -> ++
                ei++;
            }
        }

    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}