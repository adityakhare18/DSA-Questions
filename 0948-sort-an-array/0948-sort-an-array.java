class Solution {
    public int[] sortArray(int[] arr) {
        int st = 0,end = arr.length-1;
        solve(arr,st,end);
        return arr;
    }
    public void solve(int[] arr,int st,int end){
        if(st < end){
            int pi = partition(arr,st,end);
            solve(arr,st,pi-1);
            solve(arr,pi+1,end);
        }
    }
    public int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low;j<high;j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,high);
        return i;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}