class Solution {
    public long sumAndMultiply(int n) {
        int result = 0, num = 0;
        while(n!=0){
            int dig = n%10;
            if(dig !=0){
                result += dig;
                num = num*10+dig;
            }
            n = n/10;
        }
        long x = 0;
        while(num!=0){
            int dig = num%10;
            x = x*10+dig;
            num=num/10;
        }
        return result*x;
    }
}
