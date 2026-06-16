class Solution {
    public String reverse(String a){
        String rev = "";
        for(char c: a.toCharArray()){
            rev = c+rev;
        }
        return rev;
    }
    public String duplicat(String b){
        return b+b;   
    }
    public String removelast(String c){
        char []a = c.toCharArray();
        if(a.length == 0){
            return new String(a);
        }
        return new String(a).substring(0,a.length-1);
    }
    public String processStr(String s) {
        String result = "";
        for(char c:s.toCharArray()){
            if(c=='#'){
                result = duplicat(result);
            }
            else if(c=='%'){
                result = reverse(result);
            }
            else if(c=='*'){
                result = removelast(result);
            }
            else{
                result += c; 
            }
        }
        return result;
    }
}
