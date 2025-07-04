class Solution {
    public int minOperations(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int freq : map.values()) {
            if (freq == 1) return -1;

            if (freq % 3 == 0) {
                ans += freq / 3;
            } else {
                ans += freq / 3 + 1;
            }
        }

        return ans;
    }
}
