class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character> bracket = new Stack<>();
        Stack<Integer> score = new Stack<>();
        score.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                bracket.push(c);
                score.push(0);
            } else {
                bracket.pop();
                int inside = score.pop();
                int value;
                if (inside == 0) {
                    value = 1;          // ()
                } else {
                    value = inside * 2; // (A)
                }
                int parent = score.pop();
                score.push(parent + value); // A + B
            }
        }
        return score.pop();
    }
}
