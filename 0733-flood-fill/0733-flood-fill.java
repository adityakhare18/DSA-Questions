class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int col) {
        int initialCol = arr[sr][sc];
        if (initialCol == col) return arr;
        dfs(arr,sr,sc,initialCol,col);
        return arr;
    }
    public void dfs(int[][] arr,int sr,int sc,int initialCol,int col){
        if(sr >= arr.length || sr < 0 || sc >= arr[0].length || sc < 0 || arr[sr][sc] != initialCol)
        return;

        arr[sr][sc] = col;
        dfs(arr,sr+1,sc,initialCol,col);
        dfs(arr,sr-1,sc,initialCol,col);
        dfs(arr,sr,sc+1,initialCol,col);
        dfs(arr,sr,sc-1,initialCol,col);
    }
}