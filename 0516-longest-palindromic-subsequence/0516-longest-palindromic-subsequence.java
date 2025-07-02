class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        return longestCommonSubsequence(s,sb.reverse().toString());
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(s1,s2,n,m,dp);
    }
    public int solve(String s1,String s2,int idx1,int idx2,int[][] dp){
        if(idx1 ==  0 || idx2 == 0)
        return 0;

        if(dp[idx1][idx2] != -1)
        return dp[idx1][idx2];

        if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
            return dp[idx1][idx2] = 1 + solve(s1,s2,idx1-1,idx2-1,dp);
        }
        else{
            return dp[idx1][idx2] = 0 + Math.max(solve(s1,s2,idx1-1,idx2,dp),solve(s1,s2,idx1,idx2-1,dp));
        }
        
    }
}