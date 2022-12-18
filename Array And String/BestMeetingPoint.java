import java.util.*;

public class BestMeetingPoint {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {

        // 1. get x points -> using row wise travel -> arraylist of x points

        ArrayList<Integer> xcord = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xcord.add(i);
                }
            }
        }

        // 2. get y points -> using col wise travel -> arrayList of y points

        ArrayList<Integer> ycord = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    ycord.add(j);
                }
            }
        }

        // 3. mid points -> using median methods -> Integer xmedian and ymedian both

        int xmid = xcord.get(xcord.size() / 2);
        int ymid = ycord.get(ycord.size() / 2);

        // 4. get distance -> using Manhattan Distance formula -> Integer distance

        int dist = 0;
        for (int x : xcord) {
            dist += Math.abs(xmid - x);
        }
        for (int y : ycord) {
            dist += Math.abs(ymid - y);
        }

        // 5. return least distance

        return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}