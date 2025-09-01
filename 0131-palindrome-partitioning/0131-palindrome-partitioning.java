class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s,ans,new ArrayList<>(),0);
        return ans;
    }
    public void solve(String s,List<List<String>> ans,List<String> ls,int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx,i+1);
            if(isPalindrome(str)){
                ls.add(str);
                solve(s,ans,ls,i+1);
                ls.remove(ls.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int i = 0,j=s.length()-1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--))
            return false;
        }
        return true;
    }
}