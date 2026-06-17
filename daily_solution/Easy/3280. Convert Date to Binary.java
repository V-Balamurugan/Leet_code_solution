class Solution {
    public String conversion(int a) {
        if (a == 0) return "0";

        StringBuilder binary = new StringBuilder();

        while (a != 0) {
            binary.append(a % 2);
            a /= 2;
        }

        return binary.reverse().toString();
    }

    public String convertDateToBinary(String date) {
        String result = "";
        date = date + '-';

        int num = 0;

        for (char c : date.toCharArray()) {
            if (c != '-') {
                num = num * 10 + (c - '0');
            } else {
                result += conversion(num) + '-';
                num = 0;
            }
        }

        return result.substring(0, result.length() - 1);
    }
}
