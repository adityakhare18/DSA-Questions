class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] next = nextSmaller(arr,n);
        int[] prev = prevSmaller(arr,n);
        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int l = arr[i];

            if(next[i] == -1)
            next[i] = n;

            int b = next[i] - prev[i] - 1;

            maxArea = Math.max(maxArea,l*b);
        }
        return maxArea;
    }
    public int[] nextSmaller(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] next = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
            st.pop();

            next[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return next;
    }
    public int[] prevSmaller(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] prev = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()])
            st.pop();

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return prev;
    }
}