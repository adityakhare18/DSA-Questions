class Solution {
    public int[] searchRange(int[] arr, int target) {
        int lb = LB(arr,target);
        if(lb == arr.length || arr[lb] != target){
            return new int[] {-1,-1};
        }
        else{
            int ub = UB(arr,target);
            return new int[] {lb,ub-1};
        }
    }
    public int LB(int[] arr,int target){
        int ans = arr.length;
        int s = 0,e = arr.length - 1;
        while(s <= e){
            int mid = s + (e - s)/2;

            if(arr[mid] >= target){
                ans = mid;
                e = mid - 1;
            }
            else
            s = mid + 1;
        }
        return ans;
    }
    public int UB(int[] arr,int target){
        int ans = arr.length;
        int s = 0,e = arr.length - 1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(arr[mid] > target){
                ans = mid;
                e = mid - 1;
            }
            else
            s = mid + 1;
        }
        return ans;
    }
}