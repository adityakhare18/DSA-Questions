class Solution {
    public boolean search(int[] arr, int target) {
        int n = arr.length ;
        int l = 0,h = n-1;
        while(l <= h){
            int mid = l+(h-l)/2;
            if(arr[mid] == target) return true;
            if(arr[l] == arr[mid] && arr[mid] == arr[h]){
                h--;
                l++;
                continue;
            }
            if(arr[l] <= arr[mid]){
                if(arr[l] <= target && target <= arr[mid]){
                    h = mid - 1;
                }
                else l = mid + 1;
            }
            else{
                if(arr[mid] <= target && target <= arr[h]){
                    l = mid + 1;
                }
                else h = mid - 1;
            }
        }
        return false;
    }
}