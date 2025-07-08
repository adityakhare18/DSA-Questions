class Solution {
    public int coinChange(int[] arr, int amt) {
        int n = arr.length;
        Integer[][] dp = new Integer[n+1][amt+1];
        int ans = solve(arr,amt,n-1,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int[] arr,int amt,int n,Integer[][] dp){
        if(n == 0){
            if(amt % arr[n] == 0){ // pehla yani 0th idx agr remaining amt se
                    //  divisble hai to utne coin lagenge warna max value return kr do
                return amt / arr[n];
            }
            else
            return Integer.MAX_VALUE;
        }

        if(dp[n][amt] != null)
        return dp[n][amt];


        //exclude
        int Notake = 0 + solve(arr,amt,n-1,dp);

        //include
        int take = Integer.MAX_VALUE;
        if(amt >= arr[n]){
            int res = solve(arr,amt-arr[n],n,dp); //stay at same idx means u can have more than 1 sam coin
            if(res != Integer.MAX_VALUE)
            take = 1 + res;
        }

        return dp[n][amt] = Math.min(take,Notake);
    }
}