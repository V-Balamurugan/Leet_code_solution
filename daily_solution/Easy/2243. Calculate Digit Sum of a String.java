class Solution {
    private int getSum(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += ch - '0';
        }
        return sum;
    }

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                String group = s.substring(i, Math.min(i + k, s.length()));
                temp.append(getSum(group));
            }

            s = temp.toString();
        }

        return s;
    }
}
