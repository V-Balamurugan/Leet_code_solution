class Solution {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        String[] word = new String[10000];
        int index = 0;
        String w = "";

        // Collect words manually
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                w += c[i];
            } else {
                if (!w.isEmpty()) {
                    word[index++] = w;
                    w = "";
                }
            }
        }
        // Add the last word if present
        if (!w.isEmpty()) {
            word[index++] = w;
        }

        // Build result in reverse order
        String result = "";
        for (int i = index - 1; i >= 0; i--) {
            result += word[i];
            if (i > 0) result += " ";  // avoid trailing space
        }

        return result;
    }
}
