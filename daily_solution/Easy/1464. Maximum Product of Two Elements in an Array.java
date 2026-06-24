------------------------(Best time complexity)--------------------

class Solution {
    public int maxProduct(int[] nums) {
        int n = Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>n){
                m = n;
                n = nums[i];
            }else if(nums[i]>m)
                m = nums[i];
        }
        return (n-1)*(m-1);
    }
}

-------------------------------(average time complexity)----------------------
import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            queue.add(num);
        }
        return (queue.poll()-1)*(queue.poll()-1);
    }
}

-------------------------------(worst time complexity)-----------------------------------

class Solution {
    public int maxProduct(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int t = nums[i];
                    nums[i]=nums[j];
                    nums[j]=t;
                }
            }
        }
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}
