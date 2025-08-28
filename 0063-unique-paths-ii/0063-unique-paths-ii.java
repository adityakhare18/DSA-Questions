class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        if(arr[n-1][m-1] == 1)
        return 0;
        return solve(arr,n-1,m-1,0,0,dp);
    }
    public int solve(int[][] arr,int n,int m,int i,int j,int[][] dp){
        if(i == n && j == m)
        return 1;
        if(i > n || j > m || arr[i][j] == 1)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int down = solve(arr,n,m,i+1,j,dp);
        int right = solve(arr,n,m,i,j+1,dp);
        return dp[i][j] = down + right;
    }
}