class Solution {
    static boolean palindrome(String s){

        int left = 0;
        int right = s.length() - 1;

        while(left < right){

            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(palindrome(s.substring(i,j+1))){
                    result+=1;
                }
            }
        }
        return result;
        
    }
}
