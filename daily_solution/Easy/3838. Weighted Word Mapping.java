class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String result = "";
        for(int i=0;i<words.length;i++){
            int let = 0;
            for(char c:words[i].toCharArray()){
                int val = c-'a';
                let += weights[val];
            }
            int temp = let%26;
            result = result + (char)('z'-temp);
        }
        return result;
    }
}
