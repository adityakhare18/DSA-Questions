class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        List<Integer> ls = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
            dq.pollLast();

            dq.addLast(i);
        }

        for(int i=k;i<arr.length;i++){
            ls.add(arr[dq.peekFirst()]);

            while(!dq.isEmpty() && i-k >= dq.peekFirst())
            dq.pollFirst();

            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
            dq.pollLast();

            dq.addLast(i);

        }
        ls.add(arr[dq.peekFirst()]);
        int[] ans = new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}