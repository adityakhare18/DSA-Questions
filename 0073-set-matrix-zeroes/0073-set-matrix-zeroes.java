class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i] == 1 || col[j] == 1)
                arr[i][j] = 0;
            }
        }
    }
}