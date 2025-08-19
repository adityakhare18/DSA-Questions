class Solution {
    public long zeroFilledSubarray(int[] arr) {
        long cnt = 0;   
        long streak = 0; 

        for (int num : arr) {
            if (num == 0) {
                streak++;          //lagataar zero
                cnt += streak;     //count of lagataar zero
            } else {
                streak = 0;      
            }
        }

        return cnt;
    }
}
