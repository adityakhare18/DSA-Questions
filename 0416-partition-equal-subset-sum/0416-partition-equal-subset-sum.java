class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;
        int n = nums.length;

        Boolean[][] dp = new Boolean[n][target + 1];

        return isPossible(0, 0, nums, target, dp);
    }

    public boolean isPossible(int idx, int currSum, int[] nums, int target, Boolean[][] dp) {
        if (currSum == target)
            return true;
        if (idx == nums.length || currSum > target)
            return false;

        if (dp[idx][currSum] != null)
            return dp[idx][currSum];

        // Include current element
        boolean take = isPossible(idx + 1, currSum + nums[idx], nums, target, dp);
        // Exclude current element
        boolean skip = isPossible(idx + 1, currSum, nums, target, dp);

        dp[idx][currSum] = take || skip;
        return dp[idx][currSum];
    }
}
