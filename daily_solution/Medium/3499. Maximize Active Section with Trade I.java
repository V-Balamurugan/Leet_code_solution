class Solution {

    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();
        int ones = 0;

        // Count original 1s
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        int max = ones;

        int i = 0;

        while (i < n) {

            // Find a zero section
            if (s.charAt(i) == '0') {

                int leftZero = 0;

                // Count left zeros
                while (i < n && s.charAt(i) == '0') {
                    leftZero++;
                    i++;
                }

                // No 1 section after this
                if (i == n) {
                    break;
                }

                // Count 1 section
                int oneCount = 0;

                while (i < n && s.charAt(i) == '1') {
                    oneCount++;
                    i++;
                }

                // Need zero section on right
                if (i < n && s.charAt(i) == '0') {

                    int rightZero = 0;
                    int j = i;

                    while (j < n && s.charAt(j) == '0') {
                        rightZero++;
                        j++;
                    }

                    // Same as converting:
                    // 0...0 1...1 0...0
                    // into one connected section
                    int count = ones - oneCount
                                      + leftZero
                                      + oneCount
                                      + rightZero;

                    max = Math.max(max, count);
                }

            } else {
                i++;
            }
        }

        return max;
    }
}
