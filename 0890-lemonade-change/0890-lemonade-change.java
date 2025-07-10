class Solution {
    public boolean lemonadeChange(int[] arr) {
        int five = 0;
        int ten = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 5){
                five += 1;
            }
            else if(arr[i] == 10){
                if(five >= 1){
                    ten += 1;
                    five -= 1;
                }
                else return false;
            }
            else{
                if(ten >= 1 && five >= 1){
                    ten -= 1;
                    five -= 1;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else
                return false;
            }
        }
        return true;
    }
}