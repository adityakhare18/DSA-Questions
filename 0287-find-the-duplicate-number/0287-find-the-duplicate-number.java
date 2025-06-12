class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0){
                return Math.abs(nums[i]);
            }
            else
            nums[idx] *= -1;
        }
        return -1;
    }
}


// I am applying counting sort on this 
// whenever i reach to any ele i will take its idx and mark the ele present at that idx to ele*-1 
// i will repeat this process on full array while processing if i got any ele smaller then 0 then that ele is visited again therefore that ele is repeated 