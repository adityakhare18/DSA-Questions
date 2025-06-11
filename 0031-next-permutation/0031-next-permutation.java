class Solution {
    public void nextPermutation(int[] arr) {
        int idx1 = -1, idx2 = -1;
        int n = arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                idx1 = i;
                break;
            }
        }

        if(idx1 == -1){
            rev(arr,0);
        }
        else{
            for(int i=n-1;i>=0;i--){
                if(arr[i] > arr[idx1]){
                    idx2 = i;
                    break;
                }
            }
            swap(arr,idx1,idx2);
            rev(arr,idx1+1);
        }
    }

    public void rev(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}