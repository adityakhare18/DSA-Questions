class Solution {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int profit = 0;
        for(int i=1;i<arr.length;i++){
            int cost = arr[i] - min;
            profit = Math.max(cost,profit);
            min = Math.min(arr[i],min);
        }
        return profit;
    }
}