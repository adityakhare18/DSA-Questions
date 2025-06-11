class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i:arr){
            set.add(i);
        }

         int ans = 1, cnt = 1; 
        Iterator<Integer> iterator = set.iterator();
        int prev = iterator.next();

        while(iterator.hasNext()){
            int curr = iterator.next();

            if(curr == prev + 1)
            cnt++;
            else{
                ans = Math.max(cnt,ans);
                cnt = 1;
            }

            prev = curr;
        }

        ans = Math.max(ans,cnt);

        return ans;
    }
}