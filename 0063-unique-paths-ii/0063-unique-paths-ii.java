class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        if (arr[0][0] == 1 || arr[rows - 1][cols - 1] == 1) {
            return 0;
        }

        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(arr, 0, 0, rows, cols);
    }
    public int solve(int[][] arr, int i, int j, int row, int col) {
        if (i >= row || j >= col || arr[i][j] == 1) {
            return 0;
        }
        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(arr, i, j + 1, row, col);
        int down = solve(arr, i + 1, j, row, col);

        dp[i][j] = right + down;
        return dp[i][j];
    }
}