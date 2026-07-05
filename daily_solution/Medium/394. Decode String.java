import java.util.Stack;

class Solution {

    static String mulstring(int count, String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(s);
        }

        return result.toString();
    }

    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c != ']') {
                stack.push(c);
            } else {

                // Extract string
                String str = "";
                while (stack.peek() != '[') {
                    str = stack.pop() + str;
                }

                stack.pop(); // remove '['

                // Extract complete number
                String num = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = stack.pop() + num;
                }

                int count = Integer.parseInt(num);

                String repeated = mulstring(count, str);

                // Push decoded string back onto stack
                for (char ch : repeated.toCharArray()) {
                    stack.push(ch);
                }
            }
        }

        // Build final answer
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}
