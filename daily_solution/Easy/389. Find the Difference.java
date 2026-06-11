class Solution {
    public char findTheDifference(String s, String t) {
        char a[]=s.toCharArray();
        char b[]=t.toCharArray();
        int []freq=new int[127];
        for(int i=0;i<a.length;i++){
            freq[a[i]]++;
        }
        for(int i=0;i<b.length;i++){
            freq[b[i]]--;
        }
        char result = '\0';
        for(int i=0;i<b.length;i++){
            if(freq[b[i]]<0){
                result = b[i];
                freq[b[i]]=0; 
            }
        }
        return result;
    }
}
