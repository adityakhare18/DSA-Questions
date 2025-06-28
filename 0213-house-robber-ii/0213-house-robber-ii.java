class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return arr[0];

        // Create two subarrays
        int[] noFirst = Arrays.copyOfRange(arr, 1, n);  // excludes 0th
        int[] noLast = Arrays.copyOfRange(arr, 0, n - 1); // excludes last

        return Math.max(
            solve(noFirst, noFirst.length - 1, new int[noFirst.length]),
            solve(noLast, noLast.length - 1, new int[noLast.length])
        );
    }
    public int solve(int[] arr, int idx, int[] dp) {
        Arrays.fill(dp, -1);
        return helper(arr, idx, dp);
    }
    public int helper(int[] arr,int idx,int[] dp){
        if (idx == 0)
            return arr[0];
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int pick = arr[idx] + helper(arr, idx - 2, dp);
        int notPick = helper(arr, idx - 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }
}