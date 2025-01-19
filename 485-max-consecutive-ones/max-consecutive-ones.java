class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxc[] = new int[10000];
        int j = 0;
        int c = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=1){
                maxc[j] = c;
                c = 0;
                j++;
            }
            else{
                c++;
                if(i==nums.length-1){
                    maxc[j] = c;
                }
            }
        }
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<maxc.length;i++){
            if(largest<maxc[i]){
                largest = maxc[i];
            }
        }
        return largest;
    }
}