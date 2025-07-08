class Solution {
    public int minDistance(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
        int LCS = solve(s1,s2,s1.length()-1,s2.length()-1,dp);
        return (s1.length() - LCS) + (s2.length() - LCS);
    }
    public int solve(String s1,String s2,int i,int j,Integer[][] dp){
        if(i < 0 || j < 0)
        return 0;

        if(dp[i][j] != null)
        return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
        dp[i][j] = 1 + solve(s1,s2,i-1,j-1,dp);
        else{
            dp[i][j] = Math.max(solve(s1,s2,i-1,j,dp),solve(s1,s2,i,j-1,dp));
        }
        return dp[i][j];
    }
}