class Solution {

    public static boolean issubstring(String k, String word) {

        if (k.length() > word.length()) {
            return false;
        }

        for (int i = 0; i <= word.length() - k.length(); i++) {

            int count = 0;

            for (int j = 0; j < k.length(); j++) {
                if (word.charAt(i + j) == k.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == k.length()) {
                return true;
            }
        }

        return false;
    }

    public int numOfStrings(String[] patterns, String word) {

        int count = 0;

        for (String s : patterns) {
            if (issubstring(s, word)) {
                count++;
            }
        }

        return count;
    }
}
