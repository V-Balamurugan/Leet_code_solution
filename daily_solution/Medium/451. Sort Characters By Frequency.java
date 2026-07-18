class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        StringBuilder result = new StringBuilder();

        while (result.length() < s.length()) {
            int max = 0;
            int index = 0;

            // Find character with maximum frequency
            for (int i = 0; i < 128; i++) {
                if (freq[i] > max) {
                    max = freq[i];
                    index = i;
                }
            }

            // Add character 'max' times
            for (int i = 0; i < max; i++) {
                result.append((char) index);
            }

            // Mark character as processed
            freq[index] = 0;
        }

        return result.toString();
    }
}
