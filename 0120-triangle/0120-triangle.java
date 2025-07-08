class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        Integer[][] dp = new Integer[arr.size()+1][arr.size()+1];
        return solve(arr,0,0,dp);
    }
    public int solve(List<List<Integer>> arr,int i,int j,Integer[][] dp){
        if(i == arr.size() - 1){
            return arr.get(arr.size() -1).get(j);
        }

        if(dp[i][j] != null)
        return dp[i][j];

        int down = arr.get(i).get(j) + solve(arr,i+1,j,dp);
        int diagonal = arr.get(i).get(j) + solve(arr,i+1,j+1,dp);
        return dp[i][j] = Math.min(down,diagonal);
    }
}