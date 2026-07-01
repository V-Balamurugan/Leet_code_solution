--------------------optimised solutins----------------------------------
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        System.gc(); //The JVM is not required to run garbage collection immediately (or at all) in response to this call. The decision is ultimately up to the JVM implementation.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.peek();
    }
}

-------------------our solution -------------------------------------------
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        System.gc();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int result = 0;
        for(int i=0;i<=nums.length-k;i++)
          result = queue.poll();
        return result;
    }
}
