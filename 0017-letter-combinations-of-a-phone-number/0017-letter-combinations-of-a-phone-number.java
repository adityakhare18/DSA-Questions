class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        String[] mapping = {"","",  "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(digits, sb, index, ans, mapping);
        return ans;
    }
    public void solve(String d,StringBuilder sb,int idx,List<String> ans,String[] mapping){
        if(idx == d.length()){
            ans.add(sb.toString());
            return;
        }

        String letter = mapping[d.charAt(idx) - '0'];
        for(char ch: letter.toCharArray()){
            sb.append(ch);
            solve(d,sb,idx+1,ans,mapping);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}