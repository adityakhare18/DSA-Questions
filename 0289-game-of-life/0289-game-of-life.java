class Solution {
    public void gameOfLife(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int right = 0, left = 0, top = 0, bottom = 0;
                int topLeft = 0, topRight = 0, bottomLeft = 0, bottomRight = 0;

                if (j + 1 < m) right = arr[i][j + 1];
                if (j - 1 >= 0) left = arr[i][j - 1];
                if (i + 1 < n) bottom = arr[i + 1][j];
                if (i - 1 >= 0) top = arr[i - 1][j];
                if (i - 1 >= 0 && j - 1 >= 0) topLeft = arr[i - 1][j - 1];
                if (i - 1 >= 0 && j + 1 < m) topRight = arr[i - 1][j + 1];
                if (i + 1 < n && j - 1 >= 0) bottomLeft = arr[i + 1][j - 1];
                if (i + 1 < n && j + 1 < m) bottomRight = arr[i + 1][j + 1];

                int sum = right + left + top + bottom + topLeft + topRight + bottomLeft + bottomRight;

                if (arr[i][j] == 1) {
                    if (sum < 2) ans[i][j] = 0;           
                    else if (sum == 2 || sum == 3) ans[i][j] = 1; 
                    else ans[i][j] = 0;                    
                } else {
                    if (sum == 3) ans[i][j] = 1;           
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = ans[i][j];
            }
        }
    }
}
