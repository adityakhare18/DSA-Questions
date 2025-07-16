class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int maxEle = findMax(arr);
        int sumOfWt = sum(arr);
        int n = arr.length;

        int l = maxEle,h = sumOfWt, ans = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(daysReq(arr,mid,n) <= days){
                ans = mid;
                h = mid - 1;
            }
            else
            l = mid + 1;
        }
        return ans;
    }

    public int findMax(int[] arr){
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > ans)
            ans = arr[i];
        }
        return ans;
    }
    public int sum(int[] arr){
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans += arr[i];
        }
        return ans;
    }

    public int daysReq(int[] arr,int cap,int n){
        int day = 1;
        int load = 0;
        for(int i=0;i<n;i++){
            if(load + arr[i] > cap){
                day++;
                load = arr[i];
            }
            else
            load = load + arr[i];
        }
        return day;
    }
}