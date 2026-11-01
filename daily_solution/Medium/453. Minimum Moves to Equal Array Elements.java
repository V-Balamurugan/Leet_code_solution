class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();
        int count = 0;
        for(int i=0;i<n;i++){
            int temp = nums[i]-min;
            if(temp==0) continue;
            count += temp;
        }
        return count;
    }
}
