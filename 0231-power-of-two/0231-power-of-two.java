class Solution {
    public boolean solve(int n){
        if(n<=0){
            return false;
        }

        if(n==1)
        return true;
        
        if(n % 2 != 0){
            return false;
        }

        return solve(n/2);
    }
    public boolean isPowerOfTwo(int n) {
        return solve(n);
    }
}