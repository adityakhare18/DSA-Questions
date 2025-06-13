class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrays(nums , goal) - numSubarrays(nums , goal-1);   
    }
    public int numSubarrays(int []nums , int goal){
        if(goal < 0) return 0;
        int sum = 0 , l = 0 , r = 0 , count = 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal && l<=r){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}