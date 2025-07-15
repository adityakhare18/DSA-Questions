class Solution {
    public int minDays(int[] arr, int m, int k) {
        if (m * k > arr.length) 
            return -1;

        int minEle = Integer.MAX_VALUE;
        int maxEle = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxEle) {
                maxEle = arr[i];
            }
            if (arr[i] < minEle) { 
                minEle = arr[i];
            }
        }

        int l = minEle,h = maxEle;
        int ans = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(isPossible(arr,m,k,mid)){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] arr, int m, int k, int day) {
        int cnt = 0;
        int noOfBouquet = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day)
                cnt++;
            else
                cnt = 0;

            if (cnt == k) {         
                noOfBouquet++;
                cnt = 0;
            }
        }

        return noOfBouquet >= m;
    }
}
