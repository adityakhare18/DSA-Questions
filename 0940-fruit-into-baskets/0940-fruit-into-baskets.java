class Solution {
    public int totalFruit(int[] arr) {
        int l = 0,r = 0,n = arr.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r < n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size() > 2){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l]) == 0)
                map.remove(arr[l]);
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}