class Solution {
    public int minimumOperations(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        while (true) {
            Arrays.sort(arr);

            int small = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    small = arr[i];
                    break;
                }
            }

            if (small == -1) break;

            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) arr[i] -= small;
            }

            cnt++; 
        }

        return cnt;
    }
}
