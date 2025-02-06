class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int latest = 0;
        while(x > 0){
            int temp = x%10;
            latest = (latest*10)+temp;
            x /= 10;
        }
        if(latest==original){
            return true;
        }
        else{
            return false;
        }
    }
}