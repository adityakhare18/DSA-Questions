class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int cnt = 0;
        int i = n-1,j=m-1;
        while(i >=0 && j>=0){
            if(g[i] <= s[j]){
                i--;
                j--;
                cnt++;
            }
            else{
                i--;
            }
        }
        return cnt;
    }
}