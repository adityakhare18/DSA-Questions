class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1,0,0,dp);
    }
    public int solve(int m,int n,int i,int j,int[][] dp){
        if(i > m || j > n)
        return 0;
        if(i == m && j == n)
        return 1;

        if(dp[i][j] != -1)
        return dp[i][j];

        int down = solve(m,n,i+1,j,dp);
        int right =solve(m,n,i,j+1,dp);

        return dp[i][j] = down+right;
        
    }
}