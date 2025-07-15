class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int maxEle = -1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            maxEle = Math.max(maxEle,arr[i]);
        }

        int l = 1, high = maxEle;
        int ans = -1;
        while(l <= high){
            int mid = l + (high-l)/2;
            int reqTime = solve(arr,mid);
            if(reqTime <= h){
                ans = mid;
                high = mid -1;
            }
            else
            l = mid + 1;
        }
        return ans;
    }
    public int solve(int[] arr,int hour){
        int totalHours = 0;
        for(int i=0;i<arr.length;i++){
            totalHours += Math.ceil((double)arr[i] / (double)hour);
        }
        return totalHours;
    }
}