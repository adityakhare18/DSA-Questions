class Solution {
    public int[] singleNumber(int[] arr) {
        
        //xor of full array
        int xor = 0;
        for(int i:arr)
        xor ^= i;


        int mask = xor & (-xor); // or xor&(~(xor-1))
        int a = 0;
        for(int i:arr){
            if((i&mask) != 0)
            a ^= i;
        }

        int b = xor ^ a;
        return new int[]{a,b};
    }
}