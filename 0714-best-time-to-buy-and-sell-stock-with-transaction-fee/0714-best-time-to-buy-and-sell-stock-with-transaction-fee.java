class Solution {
    public int maxProfit(int[] arr, int fee) {
        Integer[][] dp = new Integer[arr.length][2];
        return solve(arr,dp,0,1,fee);
    }
    public int solve(int[] arr,Integer[][] dp,int i,int canBuy,int fee){
        if(i >= arr.length)
        return 0;

        if(dp[i][canBuy]!=null)
        return dp[i][canBuy];

        int profit = 0;
        if(canBuy == 1){
            int buy = -arr[i] + solve(arr,dp,i+1,0,fee);
            int skip = 0 + solve(arr,dp,i+1,1,fee);
            profit = Math.max(buy,skip);
        }
        else{
            int sell = arr[i] - fee + solve(arr,dp,i+1,1,fee);
            int skip = 0 + solve(arr,dp,i+1,0,fee);
            profit = Math.max(sell,skip);
        }

        return dp[i][canBuy] = profit;
    }
}