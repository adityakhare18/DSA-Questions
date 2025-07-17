class Solution {
    public int[] nextGreaterElement(int[] a1, int[] a2) {
        Stack<Integer> st = new Stack<>();
        int n = a2.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(a2[i],i);
        }

        int[] nge = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a2[i] > st.peek())
            st.pop();

            if(st.isEmpty()){
                nge[i] = -1;
                st.push(a2[i]);
            }
            else{
                nge[i] = st.peek();
                st.push(a2[i]);
            }
        }
        int[] ans = new int[a1.length];

        for(int i=0;i<a1.length;i++){
            ans[i] = nge[map.get(a1[i])];
        }

        return ans;
    }
}