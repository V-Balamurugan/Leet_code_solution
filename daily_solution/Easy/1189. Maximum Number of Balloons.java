class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[127];
        for(char c : text.toCharArray()){
            freq[c]++;
        }
        int count = 0,n=text.length()/7;
        for(int i=0;i<n;i++){
            if(freq['b']-->0&&freq['a']-->0&&freq['l']-->0&&freq['l']-->0&&freq['o']-->0&&freq['o']-->0&&freq['n']-->0){
                count +=1;
            
            }
        }
        return count;
    }
}
