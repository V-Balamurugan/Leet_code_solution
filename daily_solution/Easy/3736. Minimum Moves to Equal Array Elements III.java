class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(max<nums[i]) max = nums[i];
        }
        int count = 0;
        for(int i:nums){
            if(i==max) continue;
            count += max-i;
        }
        return count;
    }
}
