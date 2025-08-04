class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = findLeft(arr,n);
        int[] right = findRight(arr,n);

        int total = 0;
        for(int i=0;i<n;i++){
            total += (Math.min(left[i],right[i])) - arr[i];
        }
        return total;

    }

    public int[] findLeft(int[] arr,int n){
        int[] left = new int[n];
        left[0] = arr[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],arr[i]);
        }
        return left;
    }
    public int[] findRight(int[] arr,int n){
        int[] right = new int[n];
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],arr[i]);
        }
        return right;
    }
}