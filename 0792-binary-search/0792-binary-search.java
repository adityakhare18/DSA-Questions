class Solution {
    public int search(int[] arr, int target) {
        return solve(arr,target,0,arr.length-1);
    }
    public int solve(int[] arr,int target,int s,int e){
        if(s > e)
        return -1;

        int mid = s + (e-s)/2;
        if(arr[mid] == target)
        return mid;
        else if(arr[mid] > target){
            return solve(arr,target,s,mid-1);
        }
        else{
            return solve(arr,target,mid+1,e);
        }
    }
}