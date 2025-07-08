class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Integer[][] dp = new Integer[n+1][m+1];
        lcs(s1,s2,n-1,m-1,dp);
        return buildString(dp,s1,s2,n-1,m-1);
    }
    public int lcs(String s1,String s2,int i,int j,Integer[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != null)
        return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
        dp[i][j] = 1 + lcs(s1,s2,i-1,j-1,dp);
        else{
            dp[i][j] = Math.max(lcs(s1,s2,i-1,j,dp),lcs(s1,s2,i,j-1,dp));
        }
        return dp[i][j];
    }

    public String buildString(Integer[][] dp,String s1,String s2,int i,int j){
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0){
            if(s1.charAt(i) == s2.charAt(j)){
                sb.append(s1.charAt(i));
                i--;
                j--;
            }
            // Check i > 0 and j > 0 to avoid -1 indexing
            else if(i > 0 && (j == 0 || dp[i-1][j] > dp[i][j-1])){  
                sb.append(s1.charAt(i));
                i--;
            }
            else{
                sb.append(s2.charAt(j));
                j--;
            }
        }

        // Add remaining characters
        while (i >= 0) sb.append(s1.charAt(i--));
        while (j >= 0) sb.append(s2.charAt(j--));

        return sb.reverse().toString();
    }

    
}