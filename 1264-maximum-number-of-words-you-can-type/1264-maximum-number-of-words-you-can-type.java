class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        HashSet<Character> set = new HashSet<>();
        for(char ch:brokenLetters.toCharArray()){
            set.add(ch);
        }
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            boolean found = false;
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                if(set.contains(ch)){
                    found = true;
                    break;
                }
            }
            if(!found)
            cnt++;
        }
        return cnt;
    }
}