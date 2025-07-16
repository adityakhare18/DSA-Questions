class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int n = arr.length;
        int minEle = 1;
        int maxEle = findMax(arr,n);

        int s = 1,e = maxEle;
        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(sumOfDivisor(arr,n,mid) <= threshold){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
    public int findMax(int[] arr,int n){
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] > ans)
            ans = arr[i];
        }
        return ans;
    }

    public int sumOfDivisor(int[] arr,int n,int divisor){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.ceil((double) arr[i] / (double) divisor);
        }
        return ans;
    }
}