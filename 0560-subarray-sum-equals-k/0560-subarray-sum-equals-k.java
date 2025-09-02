class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            int comp = sum - k;
            if(map.containsKey(comp)){
                cnt += map.get(comp);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}