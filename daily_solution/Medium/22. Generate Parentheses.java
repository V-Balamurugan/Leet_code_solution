class Solution {
    static void generate(List<String> result, String current,
                         int open, int close, int n) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }

        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        String para = "";
        for(int i=0;i<n;i++){
            para += "()";
        }
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
        
    }
}
