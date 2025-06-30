class Solution {
    public int coinChange(int[] arr, int amt) {
        int idx = arr.length;
        int[][] dp = new int[idx][amt+1];
        for(int[] a:dp)
        Arrays.fill(a,-1);
        int ans = solve(arr,amt,idx-1,dp);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
    public int solve(int[] arr,int amt,int idx,int[][] dp){
        if(idx == 0){
            if(amt % arr[idx] == 0)
            return amt / arr[idx];
            else
            return Integer.MAX_VALUE;
        }

        if(dp[idx][amt] != -1)
        return dp[idx][amt];

        int notPick = 0 + solve(arr,amt,idx-1,dp);
        int pick = Integer.MAX_VALUE;
        if(arr[idx] <= amt){
            int res = solve(arr, amt - arr[idx], idx,dp);
            if (res != Integer.MAX_VALUE) {
                pick = 1 + res;
            }
        }
        return dp[idx][amt] = Math.min(notPick,pick);
    }
}