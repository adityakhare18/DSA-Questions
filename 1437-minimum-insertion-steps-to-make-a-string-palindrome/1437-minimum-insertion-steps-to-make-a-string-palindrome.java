class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        int lc = lcs(s,sb.reverse().toString());
        return s.length() - lc;
    }

    public int lcs(String s1,String s2){
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return solve(s1,s2,s1.length()-1,s2.length()-1,dp);
    }
    public int solve(String s1,String s2,int i,int j,Integer[][] dp){

        if(i < 0 || j < 0)
        return 0;

        if(dp[i][j] != null)
        return dp[i][j];


        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + solve(s1,s2,i-1,j-1,dp);
        }
        else{
            dp[i][j] = Math.max(solve(s1,s2,i,j-1,dp),solve(s1,s2,i-1,j,dp));
        }

        return dp[i][j];
    }
}