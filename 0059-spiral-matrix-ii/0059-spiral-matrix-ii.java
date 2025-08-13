class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int strRow = 0,strCol = 0,endRow = n-1,endCol = n-1;
        int m = 1;
        while(strRow <= endRow && strCol <= endCol){

            //right
            for(int i=strCol;i<=endCol;i++){
                arr[strRow][i] = m;
                m+=1;
            }
            strRow++;

            //bottom
            for(int i=strRow;i<=endRow;i++){
                arr[i][endCol] = m;
                m+=1;
            }
            endCol--;

            if(strRow <= endRow){
                for(int i=endCol;i>=strCol;i--){
                    arr[endRow][i] = m;
                    m+=1;
                }
                endRow--;
            }

            if(strCol <= endCol){
                for(int i=endRow;i>=strRow;i--){
                    arr[i][strCol] = m;
                    m+=1;
                }
                strCol++;
            }
        }
        return arr;

    }
}