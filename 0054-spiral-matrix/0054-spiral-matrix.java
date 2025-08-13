class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int strRow = 0,strCol = 0,endRow = n-1,endCol = m-1;
        List<Integer> ls = new ArrayList<>();
        while(strRow <= endRow && strCol <= endCol){

            for(int i=strCol;i<=endCol;i++){
                ls.add(arr[strRow][i]);
            }
            strRow++;

            for(int i=strRow;i<=endRow;i++){
                ls.add(arr[i][endCol]);
            }
            endCol--;


            if (strRow <= endRow) {
                for (int i = endCol; i >= strCol; i--) {
                    ls.add(arr[endRow][i]);
                }
                endRow--;
            }

            if (strCol <= endCol) {
                for (int i = endRow; i >= strRow; i--) {
                    ls.add(arr[i][strCol]);
                }
                strCol++;
            }
        }
        return ls;
    }
}