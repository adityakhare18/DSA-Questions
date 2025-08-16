class Solution {
    public boolean exist(char[][] arr, String word) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == arr[i][j] && search(arr,word,i,j,n,m,0))
                return true;
            }
        }
        return false;
    }

    public boolean search(char[][] arr,String s,int i,int j,int n,int m,int idx){
        if(idx == s.length())
        return true;

        if(i < 0 || j < 0 || i >= n || j >= m || arr[i][j] == '.')
        return false;

        if(arr[i][j] != s.charAt(idx))
        return false;

        char temp = arr[i][j];
        arr[i][j] = '.';

        if(search(arr,s,i+1,j,n,m,idx+1)
        || search(arr,s,i-1,j,n,m,idx+1)
        || search(arr,s,i,j+1,n,m,idx+1)
        || search(arr,s,i,j-1,n,m,idx+1)
        ){
            return true;
        }

        arr[i][j] = temp;
        return false;

    }
}