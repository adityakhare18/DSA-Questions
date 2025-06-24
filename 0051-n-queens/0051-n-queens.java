class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(arr,ans,n,0);
        return ans;
    }
    public void solve(char[][] arr,List<List<String>> ans,int n,int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                String s = "";
                for(int j = 0;j<n;j++){
                    s+=arr[i][j];
                }
                list.add(s);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(arr,row,i)){
                arr[row][i] = 'Q';
                solve(arr,ans,n,row+1);
                arr[row][i] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board,int row,int col){
        int n = board.length;
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q')
            return false;
        }

        for(int i=0;i<n;i++){
            if(board[i][col]=='Q')
            return false;
        }

        int i = row;
        int j = col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q')
            return false;

            i--;
            j++;
        }

        i = row;
        j = col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q')
            return false;

            i--;
            j--;
        }

        i = row;
        j = col;
        while(i<n && j<n){
            if(board[i][j]=='Q')
            return false;

            i++;
            j++;
        }

        i = row;
        j = col;
        while(i<n && j>=0){
            if(board[i][j]=='Q')
            return false;

            i++;
            j--;
        }

        return true;
    }
}