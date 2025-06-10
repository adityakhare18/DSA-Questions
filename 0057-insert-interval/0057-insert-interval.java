class Solution {
    public int[][] insert(int[][] arr, int[] newArr) {
        if (arr.length == 0) {
            int[][] ans = new int[1][2];
            ans[0][0] = newArr[0];
            ans[0][1] = newArr[1];
            return ans;
        }

        List<List<Integer>> list = new ArrayList<>();
        boolean inserted = false;

        for (int i = 0; i < arr.length; i++) {
            int st = arr[i][0];
            List<Integer> ls = new ArrayList<>();

            if (!inserted && newArr[0] < st) {
                // Insert newArr before current interval
                ls.add(newArr[0]);
                ls.add(newArr[1]);
                list.add(ls);
                inserted = true;

                // Add current interval
                ls = new ArrayList<>();
                ls.add(st);
                ls.add(arr[i][1]);
                list.add(ls);
            } else {
                // Add current interval
                ls.add(st);
                ls.add(arr[i][1]);
                list.add(ls);
            }
        }

        // If newArr wasn't added yet (newArr comes after all existing)
        if (!inserted) {
            List<Integer> ls = new ArrayList<>();
            ls.add(newArr[0]);
            ls.add(newArr[1]);
            list.add(ls);
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        
        return merge(ans);
    }

    public int[][] merge(int[][] arr) {
        int n = arr.length;
        List<List<Integer>> list = new ArrayList<>();

        // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); // ✅ Ensure sorted

        for (int i = 0; i < n; i++) {
            int st = arr[i][0];
            int end = arr[i][1];
            List<Integer> ls = new ArrayList<>();

            while (i + 1 < n && end >= arr[i + 1][0]) {
                end = Math.max(end, arr[i + 1][1]);
                i++;
            }
            ls.add(st);
            ls.add(end);
            list.add(ls);
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}
