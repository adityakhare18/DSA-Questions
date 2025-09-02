class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            int idx = Math.abs(arr[i]);
            if(arr[idx-1] < 0)
            ans.add(idx);

            arr[idx-1] *= -1;
        }
        return ans;

    }
}

//count sort lagaya hai haar elememt ko -1 se multiple kiya hia agr vo already -1 hai to mtlb duplicate h