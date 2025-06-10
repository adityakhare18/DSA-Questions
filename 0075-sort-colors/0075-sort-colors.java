class Solution {
    public void sortColors(int[] nums) {
        int ones = 0,zeros = 0;
        for(int i:nums){
            if(i == 0)
            zeros++;
            else if(i == 1)
            ones++;
        }
        for(int i=0;i<zeros;i++){
            nums[i] = 0;
        }
        for(int i=zeros;i<(zeros+ones);i++){
            nums[i] = 1;
        }
        for(int i=(zeros+ones);i<nums.length;i++){
            nums[i] = 2;
        }
    }
}