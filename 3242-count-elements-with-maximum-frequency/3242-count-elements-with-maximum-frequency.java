class Solution {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        } 
        int max = 0;
        int sum = 0;  
         for (int frequency : map.values()) {
            if (frequency > max) {
                max = frequency;
            }
        }

        // Sum frequencies of elements with the maximum frequency
        for (int frequency : map.values()) {
            if (frequency == max) {
                sum += frequency;
            }
        }
        return sum;
    }
}