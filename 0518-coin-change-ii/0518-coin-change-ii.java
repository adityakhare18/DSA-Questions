class Solution {
    public int change(int amt, int[] arr) {
        int idx = arr.length;
        int[][] dp = new int[idx][amt+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(arr,amt,idx-1,dp);
    }
    public int solve(int[] arr,int amt,int idx,int[][] dp){
        if (idx == 0) {
            return (amt % arr[0] == 0) ? 1 : 0; 
        }

        if(dp[idx][amt] != -1)
        return dp[idx][amt];

        int notPick = solve(arr, amt, idx - 1,dp);
        int pick = 0;
        if (arr[idx] <= amt) {
            pick = solve(arr, amt - arr[idx], idx,dp); 
        }

        return dp[idx][amt] = pick + notPick;
    }
}