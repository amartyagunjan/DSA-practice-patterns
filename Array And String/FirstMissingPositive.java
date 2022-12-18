import java.util.*;

public class FirstMissingPositive {

    // ~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
    public static int firstMissingPositive(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        boolean[] visited = new boolean[max];

        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - 1;
            if (idx >= 0) {
                visited[idx] = true;
            }

        }

        int idx = -1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            return max + 1;
        }
        return idx + 1;

    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = firstMissingPositive(arr);
        System.out.println(res);
    }
}