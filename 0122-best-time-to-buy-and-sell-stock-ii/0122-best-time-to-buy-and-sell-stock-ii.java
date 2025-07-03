import java.util.Arrays;

class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        // dp[i][0] => max profit on day i if not holding stock
        // dp[i][1] => max profit on day i if holding stock
        int[][] dp = new int[n][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(arr, 0, false, dp);
    }

    public int solve(int[] arr, int i, boolean bought, int[][] dp) {
        if (i == arr.length)
            return 0;

        int b = bought ? 1 : 0;

        if (dp[i][b] != -1)
            return dp[i][b];

        int profit;
        if (!bought) {
            // Buy or skip
            int buy = -arr[i] + solve(arr, i + 1, true, dp);
            int skip = solve(arr, i + 1, false, dp);
            profit = Math.max(buy, skip);
        } else {
            // Sell or hold
            int sell = arr[i] + solve(arr, i + 1, false, dp);
            int hold = solve(arr, i + 1, true, dp);
            profit = Math.max(sell, hold);
        }

        dp[i][b] = profit;
        return profit;
    }
}
