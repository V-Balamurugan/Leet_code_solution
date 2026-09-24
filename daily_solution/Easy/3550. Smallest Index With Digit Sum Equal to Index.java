class Solution {
    static int sumdig(int n){
        int sum = 0;
        while(n!=0){
            sum += n%10;
            n=n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i==sumdig(nums[i])){
                return i;
            }
        }
        return -1;
    }
}
