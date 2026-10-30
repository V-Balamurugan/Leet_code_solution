
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int i : spaces) {
            result.append(s, index, i);
            result.append(" ");
            index = i;
        }

        result.append(s.substring(index));

        return result.toString();
    }
}
