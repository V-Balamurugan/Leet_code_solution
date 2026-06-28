class Solution {
    public static int[] sort1(int[] n){
        for(int i = 0; i < n.length; i++){
            for(int j = i + 1; j < n.length; j++){
                if(n[i] > n[j]){
                    int t = n[i];
                    n[i] = n[j];
                    n[j] = t;
                }
            }
        }
        return n;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = sort1(nums);

        while(k > 0){
            // If the smallest number is negative, flip it.
            if(nums[0] < 0){
                nums[0] = -nums[0];
                nums = sort1(nums);
                k--;
            }else{
                // All numbers are non-negative.
                // Only one more flip is needed if k is odd.
                if(k % 2 == 1){
                    nums[0] = -nums[0];
                }
                break;
            }
        }

        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum;
    }
}
