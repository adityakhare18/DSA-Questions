class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        Integer[][] dp = new Integer[i+2][j+2];
        return solve(s,t,i,j,dp);
    }
    public int solve(String s,String t,int i,int j,Integer[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != null)
        return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            //2 option either to count that orr find in other half
            dp[i][j] = (solve(s,t,i-1,j-1,dp) + solve(s,t,i-1,j,dp));
        }
        else
        dp[i][j] = solve(s,t,i-1,j,dp);

        return dp[i][j];
    }
}