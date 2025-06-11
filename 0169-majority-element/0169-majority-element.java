class Solution {
    public int majorityElement(int[] arr) {
        int ele = arr[0];
        int cnt = 1;

        for(int i=1;i<arr.length;i++){
            if(cnt == 0){
                cnt = 1;
                ele = arr[i];
            }
            else if(arr[i] == ele)
            cnt++;
            else
            cnt--;
        }

        return ele;
    }
}