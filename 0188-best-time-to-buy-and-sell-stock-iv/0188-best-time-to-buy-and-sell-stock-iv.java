class Solution {
    public int maxProfit(int k, int[] arr) {
        Integer[][][] dp = new Integer[arr.length][2][k];
        return solve(arr,dp,0,1,k,0);
    }
    public int solve(int[] arr,Integer[][][] dp,int i,int canBuy,int k,int count){
        if(i == arr.length || count == k)
        return 0;

        if(dp[i][canBuy][count] != null)
        return dp[i][canBuy][count];

        int profit = 0;
        if(canBuy == 1){
            int buy = -arr[i] + solve(arr,dp,i+1,0,k,count);
            int skip = 0 + solve(arr,dp,i+1,1,k,count);
            profit = Math.max(buy,skip);
        }
        else{
            int sell = arr[i] + solve(arr,dp,i+1,1,k,count+1);
            int skip = 0 + solve(arr,dp,i+1,0,k,count);
            profit = Math.max(sell,skip);
        }
        return dp[i][canBuy][count] = profit;
    }
}