class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];

        for (int[] a : arr) {
            Arrays.fill(a, -1);
        }

        int strRow = 0, strCol = 0, endRow = m - 1, endCol = n - 1;
        ListNode curr = head;

        while (curr != null && strRow <= endRow && strCol <= endCol) {

            for (int i = strCol; i <= endCol && curr != null; i++) {
                arr[strRow][i] = curr.val;
                curr = curr.next;
            }
            strRow++;

            for (int i = strRow; i <= endRow && curr != null; i++) {
                arr[i][endCol] = curr.val;
                curr = curr.next;
            }
            endCol--;

            if (strRow <= endRow) {
                for (int i = endCol; i >= strCol && curr != null; i--) {
                    arr[endRow][i] = curr.val;
                    curr = curr.next;
                }
                endRow--;
            }

            if (strCol <= endCol) {
                for (int i = endRow; i >= strRow && curr != null; i--) {
                    arr[i][strCol] = curr.val;
                    curr = curr.next;
                }
                strCol++;
            }
        }
        return arr;
    }
}
