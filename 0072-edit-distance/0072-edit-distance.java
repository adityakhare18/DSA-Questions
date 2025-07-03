class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Integer[][] dp = new Integer[n][m];
        return solve(s1,s2,n-1,m-1,dp);
    }
    public int solve(String s1,String s2,int i,int j,Integer[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != null)
        return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
        return 0 + solve(s1,s2,i-1,j-1,dp);

        else{
            //insert 
            int insert = 1 + solve(s1,s2,i,j-1,dp);


            //delete
            int delete = 1 + solve(s1,s2,i-1,j,dp);

            //replace
            int replace = 1 + solve(s1,s2,i-1,j-1,dp);

            return dp[i][j] = Math.min(insert,Math.min(delete,replace));
        }
    }
}