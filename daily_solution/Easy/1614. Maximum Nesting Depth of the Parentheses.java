class Solution {
    static int maxof2(int a,int b){
        return a>b?a:b;
    }
    public int maxDepth(String s) {
        int max = 0;
        int depth =0;
        for(char c:s.toCharArray()){
            if(c=='(')
            {
                depth++;
                max = maxof2(depth,max);
            }
            else if(c==')'){
                depth--;
            }
        }
        return max;

    }
}
