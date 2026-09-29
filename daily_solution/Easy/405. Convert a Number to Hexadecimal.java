class Solution {
    static String hex(long num) {
        char[] hex = "0123456789abcdef".toCharArray();
        String result = "";
        while (num != 0) {
            int remainder = (int)(num % 16);
            result = hex[remainder] + result;
            num = num / 16;
        }
        return result;
    }
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long unsignedNum = num;
        if (num < 0) {
            unsignedNum = (long) num + 4294967296L;
        }
        return hex(unsignedNum);
    }
}
