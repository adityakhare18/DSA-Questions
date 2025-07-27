class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProd = arr[0];
        int curr = 1;
        for(int i=0;i<n;i++){
            curr *= arr[i];

            maxProd = Math.max(maxProd,curr);

            if(curr == 0) curr = 1;
        }

        curr = 1;
        for(int i=n-1;i>=1;i--){
            curr *= arr[i];

            maxProd = Math.max(maxProd,curr);
            
            if(curr == 0) curr = 1;
        }
        return maxProd;
    }
}