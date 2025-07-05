class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(arr,k,0,dp);
    }
    public int solve(int[] arr,int k,int idx,int[] dp){
        if(idx >= arr.length)
        return 0;

        if(dp[idx] != -1)
        return dp[idx];

        int len = 0,maxAns = 0,maxEle = Integer.MIN_VALUE;
        for(int i=idx;i<Math.min(arr.length,idx+k);i++){
            len++;
            maxEle = Math.max(maxEle,arr[i]);
            int sum = (maxEle * len) + solve(arr,k,i+1,dp);
            maxAns = Math.max(maxAns,sum);
        }
        return dp[idx] = maxAns;
    }
}