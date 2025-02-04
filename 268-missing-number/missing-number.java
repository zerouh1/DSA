class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        for(int i=0;i<=size;i++){
            int flag = 1;
            for(int j=0;j<size;j++){
                if(nums[j]==i){
                    flag = 0;
                }
            }
            if(flag==1){
                return i;
            }
        }
        return 0;
    }
}