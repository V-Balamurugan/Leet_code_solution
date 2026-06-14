class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        nums = Arrays.copyOf(nums,nums.length+1);
        nums[nums.length-1]=0;
        int result =0, max = 0;
        for(int n :nums){
            if(n==0){
                if(result<max){
                    result = max;
                    max=0;
                }
                else{
                    result = result;
                    max=0;
                }
            }else{
                max +=1;
            }
        }
        return result;
    }
}
