class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                if(map.get(ch) >= l)
                l = map.get(ch) + 1;
                map.put(ch,r);
            }
            map.put(ch,r);
            maxLen = Math.max(maxLen, r-l+1);    
            r++;
        }
        return maxLen;
    }
}