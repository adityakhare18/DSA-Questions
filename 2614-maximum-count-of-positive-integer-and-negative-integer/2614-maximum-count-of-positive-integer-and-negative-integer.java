class Solution {
    public int maximumCount(int[] arr) {
        int lower = lb(arr,0);
        int upper = arr.length - up(arr,0);
        return Math.max(lower,upper);
    }
    public int lb(int[] arr,int target){
        int s = 0,e = arr.length-1;
        int ans = arr.length;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid]>=target){
                ans = mid;
                e = mid - 1;
            }
            else
            s = mid + 1;
        }
        return ans;
    }
    public int up(int[] arr,int target){
        int s = 0,e = arr.length - 1;
        int ans = arr.length;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] > target){
                ans = mid;
                e = mid -1 ;
            }
            else
            s = mid + 1;
        }
        return ans;
    }
}