class Solution {
    public int smallestNumber(int n) {
        for(int i=n;i<=Integer.MAX_VALUE;i++){
            if(allSet(i))
            return i;
        }
        return n;
    }
    public boolean allSet(int n){
        String s = Integer.toBinaryString(n);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0')
            return false;
        }
        return true;
    }
}