class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        solve(s,ls,ans);
        return ans;
    }
    public void solve(String s,List<String> ls,List<List<String>> ans){
        if(s.length() == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(isPalindrome(sub)){
                ls.add(sub);
                solve(s.substring(i+1),ls,ans);
                ls.remove(ls.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int st = 0,end = s.length()-1;
        while(st<=end){
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}