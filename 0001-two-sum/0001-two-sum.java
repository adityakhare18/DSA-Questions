class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            int comp = target - arr[i];
            if(map.containsKey(comp)){
                return new int[]{i,map.get(comp)};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}