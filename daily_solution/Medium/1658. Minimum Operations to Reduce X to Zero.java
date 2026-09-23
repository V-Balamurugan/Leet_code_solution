class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int i:nums) total+=i;
        int target = total-x;
        int n = nums.length;
        if(target<0) return -1;
        if(target == 0) return n;

        int left = 0;
        int sum = 0;
        int longest = -1;
        for(int right = 0;right<n;right++){
            sum += nums[right];
            while(sum > target){
                sum = sum - nums[left++];
            }
            if(sum == target){
                longest = Math.max(longest,right-left+1);
            }
        }
        if(longest == -1)
            return -1;
        else
            return n-longest;
    }
}
