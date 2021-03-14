package Week_06;

public class Assignment_64_minimum_path_sum {
    public int minPathSum(int[][] grid) {
        int xl = grid.length;
        int yl = grid[0].length;
        int[][] dp = new int[xl + 1][yl + 1];

        for (int xi = 0; xi < xl; xi++) {
            for (int yi = 0; yi < yl; yi++) {
                if (xi != 0 && yi != 0) {
                    dp[xi + 1][yi + 1] = Math.min(dp[xi][yi + 1], dp[xi + 1][yi]) + grid[xi][yi];
                } else if (xi != 0) {
                    dp[xi + 1][1] = dp[xi][1] + grid[xi][0];
                } else if (yi != 0) {
                    dp[1][yi + 1] = dp[1][yi] + grid[0][yi];
                } else {
                    dp[1][1] = grid[0][0];
                }
            }
        }
        return dp[xl][yl];
    }
}
