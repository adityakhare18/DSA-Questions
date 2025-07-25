class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0)
        return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:arr)
        pq.add(i);


        int ele = pq.poll();
        int cnt = 1;
        int ans = Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            int el = pq.poll();
            if(el == ele) continue;
            else if(el == ele + 1){
                cnt++;
                ele = el;
            }
            else{
                cnt = 1;
                ele = el;
            }
            ans = Math.max(cnt,ans);
        }
        ans = Math.max(ans,cnt);
        return ans;
    }
}