class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] > 0)
            st.push(arr[i]);

            else{
                while(st.size() > 0 && st.peek() > 0 && Math.abs(arr[i]) > st.peek())
                st.pop();
                if(st.size() == 0 || st.peek() < 0)
                st.push(arr[i]);
                else if(Math.abs(arr[i]) == st.peek())
                st.pop();
            }
        }
        int[] ans = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}