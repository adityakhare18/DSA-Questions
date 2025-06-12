class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            ans = Math.max(Math.abs(nums[i] - nums[i-1]),ans);
        }
        ans = Math.max(ans,Math.abs(nums[0] - nums[n-1]));
        return ans;
    }
}