class Solution {
    public int longestCommonSubsequence(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int[] r:dp)
        Arrays.fill(r,-1);        
        return solve(s1,s2,0,0,dp);
    }
    public int solve(String s1,String s2,int i,int j,int[][] dp){
        if(i >= s1.length() || j >= s2.length())
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int notMatch = Math.max(solve(s1,s2,i+1,j,dp),solve(s1,s2,i,j+1,dp));
        int match = 0;
        if(s1.charAt(i) == s2.charAt(j))
        match = 1 + solve(s1,s2,i+1,j+1,dp);

        return dp[i][j] = Math.max(match,notMatch);
    }
}