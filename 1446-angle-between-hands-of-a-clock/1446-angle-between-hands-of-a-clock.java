class Solution {
    public double angleClock(int hour, int minutes) {
        double ans=Math.abs((30*(hour%12))-(5.5*minutes));
        if(ans>180){
            return 360-ans;
        }
        else{
            return ans;
        }
    }
}