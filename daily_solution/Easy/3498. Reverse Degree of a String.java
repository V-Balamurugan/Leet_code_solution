class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int count = 0;
        for(char c: s.toCharArray()){
            count++;
            sum += (26-(c -'a')) *count;
        }
        return sum;
    }
}
