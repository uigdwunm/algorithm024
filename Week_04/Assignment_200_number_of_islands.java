package Week_04;

public class Assignment_200_number_of_islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int xl = grid.length;
        int yl = grid[0].length;
        for (int x = 0; x < xl; x++) {
            for (int y = 0; y < yl; y++) {
                if (grid[x][y] == '1') {
                    this.dfs(grid, x, y);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        int xl = grid.length;
        int yl = grid[0].length;
        if (x < 0 || x == xl || y < 0 || y == yl || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';

        this.dfs(grid, x - 1, y);
        this.dfs(grid, x + 1, y);
        this.dfs(grid, x, y - 1);
        this.dfs(grid, x, y + 1);
    }
}
