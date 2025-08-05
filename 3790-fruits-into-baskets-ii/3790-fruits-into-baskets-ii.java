class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        int n = fruits.length;
        for(int i=0;i<n;i++){
            int fruit = fruits[i];
            for(int j=0;j<n;j++){
                if(baskets[j] >= fruit){
                    ans++;
                    baskets[j] = -1;
                    break;
                }
            }
            
        }
        return n-ans;
    }
}


