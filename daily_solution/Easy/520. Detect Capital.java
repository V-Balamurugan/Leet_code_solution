class Solution {
    public boolean detectCapitalUse(String word) {
        int count =0;
        for(char c: word.toCharArray()){
            if((c>=65 && c<=90)){
                count ++;
            }
        }
        if(count == word.length()){
            return true;
        }
        else if(count == 0){
            return true;
        }
        else if(count ==1 && word.charAt(0)>=65 && word.charAt(0)<=90){
            return true;
        }
        return false;
    }
}
