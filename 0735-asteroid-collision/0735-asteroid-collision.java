class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i] > 0)
            st.push(arr[i]);
            else{
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(arr[i]) > st.peek())
                st.pop();
                if(st.isEmpty() || st.peek() < 0)
                st.push(arr[i]);
                else if(st.peek() == Math.abs(arr[i]))
                st.pop();
            }
        }
        int stSize = st.size();
        int[] ans = new int[stSize];
        for(int i=stSize-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}