import java.util.HashMap;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        // index -> {number of s1 processed, number of s2 matched}
        HashMap<Integer, int[]> map = new HashMap<>();

        int s1Count = 0;   // Number of s1 strings processed
        int s2Count = 0;   // Number of complete s2 strings matched
        int index = 0;     // Current index in s2

        while (s1Count < n1) {

            // Traverse one copy of s1
            for (int i = 0; i < s1.length(); i++) {

                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;

                    // One complete s2 found
                    if (index == s2.length()) {
                        s2Count++;
                        index = 0;
                    }
                }
            }

            s1Count++;

            // If we've seen this s2 index before, we've found a cycle
            if (map.containsKey(index)) {

                int[] prev = map.get(index);

                int prevS1 = prev[0];
                int prevS2 = prev[1];

                // Length of one cycle
                int cycleS1 = s1Count - prevS1;
                int cycleS2 = s2Count - prevS2;

                // Remaining s1 copies
                int remain = n1 - s1Count;

                // Skip as many complete cycles as possible
                int times = remain / cycleS1;

                s1Count += times * cycleS1;
                s2Count += times * cycleS2;

            } else {
                map.put(index, new int[]{s1Count, s2Count});
            }
        }

        return s2Count / n2;
    }
}
