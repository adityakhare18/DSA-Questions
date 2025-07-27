class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int st = arr[i][0];
            int end = arr[i][1];
            List<Integer> ls = new ArrayList<>();
            while(i+1 < n && end >= arr[i+1][0]){
                end = Math.max(end,arr[i+1][1]);
                i++;
            }
            ls.add(st);
            ls.add(end);
            ans.add(ls);
        }

        int[][] ansArray = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            ansArray[i][0] = ans.get(i).get(0);
            ansArray[i][1] = ans.get(i).get(1);
        }
        return ansArray;
    }
}