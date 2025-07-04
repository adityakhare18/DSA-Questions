class Solution {
    public int maxProfit(int[] arr) {
        Integer[][][] dp = new Integer[arr.length][2][3];
        return solve(arr,0,1,dp,0);
    }
    public int solve(int[] arr,int i,int canBuy, Integer[][][] dp,int count){
        if(i == arr.length || count == 2)
        return 0;

        if(dp[i][canBuy][count] != null)
        return dp[i][canBuy][count];

        int profit = 0;
        if(canBuy == 1){
            int buy = -arr[i] + solve(arr,i+1,0,dp,count);
            int skip = 0 + solve(arr,i+1,1,dp,count);
            profit = Math.max(buy,skip);
        }
        else{
            int sell = arr[i] + solve(arr,i+1,1,dp,count+1);
            int skip = 0 + solve(arr,i+1,0,dp,count);

            profit = Math.max(sell,skip);
        }
        return dp[i][canBuy][count] = profit;
    }
}