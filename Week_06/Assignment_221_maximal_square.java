package Week_06;

public class Assignment_221_maximal_square {

    public int maximalSquare(char[][] matrix) {
        int xl = matrix.length;
        int yl = matrix[0].length;

        // 因为是正方形，所以只记录一条边长
        int[][] dp = new int[xl + 1][yl + 1];

        int max = 0;
        for (int x = 0; x < xl; x++) {
            for (int y = 0; y < yl; y++) {
                if (matrix[x][y] == '1') {
                    dp[x + 1][y + 1] = Math.min(Math.min(dp[x][y + 1], dp[x + 1][y]), dp[x][y]) + 1;
                    max = Math.max(max, dp[x + 1][y + 1]);
                }
            }
        }

        return max * max;
    }
}
