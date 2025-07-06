class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalSum = 0;
        for (int i : arr) totalSum += i;

        if (totalSum % k != 0) return false;

        boolean[] vis = new boolean[arr.length];
        return solve(arr, totalSum / k, k, 0, 0, vis);
    }

    public boolean solve(int[] arr, int target, int k, int currSum, int idx, boolean[] vis) {
        if (k == 0) return true;
        if (currSum > target) return false;
        if (currSum == target)
            return solve(arr, target, k - 1, 0, 0, vis); 

        for (int i = idx; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (solve(arr, target, k, currSum + arr[i], i + 1, vis))
                    return true;
                vis[i] = false;
            }
        }

        return false;
    }
}
