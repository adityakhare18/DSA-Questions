class Solution {
    public List<Integer> majorityElement(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i]) > arr.length/3 && !ls.contains(arr[i]))
            ls.add(arr[i]);
        }
        return ls;
    }
}