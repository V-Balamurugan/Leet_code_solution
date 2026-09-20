class Solution {
    public String sortSentence(String s) {
        s = s+" ";
        char c[]=s.toCharArray();
        int n = 0;
        for(int i=0;i<c.length;i++){
            if(c[i]==' ')
                n++;
        }
        String temp[] = new String[n];
        String result = "";
        for(int i=0;i<c.length;i++){
            if((c[i]>='0' && c[i]<='9')&&c[i+1]==' '){
                temp[((int)c[i]-'0')-1]=result;
                result = "";
                i++;
            }
            else if (c[i] == ' ') {
                continue;
            }
            else {
                result += c[i];
            }
                
        }
        String str = "";
        for(int i=0;i<n-1;i++){
            str += temp[i]+" ";
        }
        return str+temp[n-1];


    }
}
