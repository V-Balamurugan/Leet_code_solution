class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1)
            return n;
        if(n==2)
            return 2;
        int result =1; 
        while(result<=n)
            result*=2;
        return result;
    }
}
