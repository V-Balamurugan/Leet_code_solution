class Solution {
    public boolean isanagram(String str, String giv){
        int freq[]=new int[26];
        char c[]= str.toCharArray();
        char a[]=giv.toCharArray();
        for(int i =0;i<a.length;i++){
            if(c[i]>='a' && c[i]<='z'){
                freq[(char)c[i]-'a']++;
            } 
            else if(c[i]>='A'&& c[i]<='Z'){
                freq[(char)c[i]-'A']++;
            }
            if(a[i]>='a' && a[i]<='z'){
                freq[(char)a[i]-'a']--;
            } 
            else if(a[i]>='A'&& a[i]<='Z'){
                freq[(char)a[i]-'A']--;
            }
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0)
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        List<Integer> result= new ArrayList<>(); 
        for(int i = 0; i <= s.length() - len; i++) {
            String window = s.substring(i, i + len);

            if(isanagram(window, p)) {
                result.add(i);
            }
        }
        return result;
        
    }
}
