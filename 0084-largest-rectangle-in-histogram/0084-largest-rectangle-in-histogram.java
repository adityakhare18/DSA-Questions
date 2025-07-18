class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] prev = prevSmaller(arr,n);
        int[] next = nextSmaller(arr,n);

        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int l = arr[i];
            if(next[i] == -1)
            next[i] = n;

            int b = next[i] - prev[i] -1 ;

            maxArea = Math.max(maxArea,l*b);
        }
        return maxArea;
    }
    public int[] prevSmaller(int[] arr,int n){
        Deque<Integer> dq = new ArrayDeque<>();

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && arr[dq.peek()] >= arr[i])
            dq.pop();

            ans[i] = dq.size() == 0 ? -1 : dq.peek();
            dq.push(i);
        }
        return ans;
    }

    public int[] nextSmaller(int[] arr,int n){
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && arr[dq.peek()] >= arr[i])
            dq.pop();

            ans[i] = dq.isEmpty() ? -1 : dq.peek();
            dq.push(i);
        }
        return ans;
    }
}