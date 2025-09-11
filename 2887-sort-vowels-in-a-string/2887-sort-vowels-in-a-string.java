class Solution {
    public String sortVowels(String s) {
        char[] cons = new char[s.length()];
        List<Character> ls = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                ls.add(ch);
                cons[i] = '.';
            }
            else{
                cons[i] = ch;
            }
        }
        Collections.sort(ls);
        String ans = "";
        int k = 0;
        for(int i=0;i<cons.length;i++){
            if(cons[i] == '.'){
                ans += ls.get(k++);
            }
            else{
                ans += cons[i];
            }
        }
        return ans;
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        return true;
        else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
        return true;
        else
        return false; 
    }
}