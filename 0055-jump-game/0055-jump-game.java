class Solution {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        int maxIdx = 0;//how much idx frog can jump.
        for(int i=0;i<n;i++){
            if(i > maxIdx) return false;
            maxIdx = Math.max(maxIdx,i+arr[i]);
        }
        return true;
    }
}