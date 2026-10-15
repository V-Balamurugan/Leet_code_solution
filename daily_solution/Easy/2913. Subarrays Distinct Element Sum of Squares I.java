
import java.util.*;

class Solution {

    static int distinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        return set.size();
    }

    static int convertarr(String s) {
        String[] parts = s.trim().split("\\s+");
        int[] farr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            farr[i] = Integer.parseInt(parts[i]);
        }

        int dist = distinct(farr);
        return dist * dist;
    }

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();

        // Step 1: Generate and store all subarrays
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder subarray = new StringBuilder();

            for (int j = i; j < n; j++) {
                subarray.append(nums.get(j)).append(" ");
                arr.add(subarray.toString());
            }
        }

        // Step 2: Calculate squared distinct counts
        int result = 0;

        for (int i = 0; i < arr.size(); i++) {
            result += convertarr(arr.get(i));
        }

        return result;
    }
}
