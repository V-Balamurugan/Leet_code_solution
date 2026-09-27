class Solution {

    static String reverse(String str) {
        String rev = "";

        for (char c : str.toCharArray()) {
            rev = c + rev;
        }

        return rev;
    }

    public String reverseParentheses(String s) {

        String result = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                int j = i + 1;
                int count = 1;

                // Find matching ')'
                while (j < s.length() && count > 0) {

                    if (s.charAt(j) == '(') {
                        count++;
                    }
                    else if (s.charAt(j) == ')') {
                        count--;
                    }

                    j++;
                }

                // Content between '(' and matching ')'
                String temp = s.substring(i + 1, j - 1);

                // Handle nested parentheses
                temp = reverseParentheses(temp);

                // Reverse the result
                result += reverse(temp);

                // Skip everything we already processed
                i = j - 1;
            }
            else {
                result += s.charAt(i);
            }
        }

        return result;
    }
}
