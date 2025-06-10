class Solution {
    public int maxProfit(int[] arr) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(buyPrice < arr[i]){
                profit = Math.max(arr[i]-buyPrice,profit);
            }
            else{
                buyPrice = arr[i];
            }
        }
        return profit;
    }
}