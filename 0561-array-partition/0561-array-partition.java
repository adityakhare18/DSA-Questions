class Solution {
    public int arrayPairSum(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0;i<arr.length-1;i+=2){
            int mini = Math.min(arr[i],arr[i+1]);
            sum += mini;
        }
        return sum;
    }
}