class Solution {
    public int searchInsert(int[] arr, int target) {
        int ans = arr.length;
        int s = 0,e = arr.length - 1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] == target)
            return mid;
            if(arr[mid] > target){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
}