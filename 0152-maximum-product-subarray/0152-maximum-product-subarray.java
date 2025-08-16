class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int currProd = 1;
        int maxProd = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currProd *= arr[i];

            maxProd = Math.max(maxProd,currProd);

            if(currProd == 0) currProd = 1;
        }

        currProd = 1;
        for(int i=n-1;i>=0;i--){
            currProd *= arr[i];

            maxProd = Math.max(maxProd,currProd);

            if(currProd == 0) currProd = 1;
        }

        return maxProd;
    }
}