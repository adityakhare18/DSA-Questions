class Solution {
    public int findMin(int[] arr) {
        int s = 0,e = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while(s <= e){
            int mid = s + (e-s)/2;

            if(arr[s] <= arr[mid]){
                min = Math.min(arr[s],min);
                s = mid + 1;
            }
            else{
                min = Math.min(arr[mid],min);
                e = mid - 1;
            }
        }
        return min;
    }
}