class Solution {
    static int value(int n){
        int odd =0, even =0;
        for(int i=0;i<n*2;i++){
            if(i%2==0){
                even+=i;
            }
            else{
                odd+=i;
            }
        }
        return gcd(odd, even);
    }
    static int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        System.gc();
        return value(n);
        
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
best approach:
class Solution {
    static int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int odd = n*n;
        int even = n*(n+1);
        return gcd(odd,even);
    }
}
