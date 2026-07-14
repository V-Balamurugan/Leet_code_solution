class Solution {
    public int threeSumMulti(int[] arr, int target) {
        System.gc();
        long count = 0;
        int mod = 1000000007;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int left = i+1, right=arr.length-1;
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                if(sum<target){
                    left++;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    if(arr[left]==arr[right]){
                        int n = right-left+1;
                        count += (long)n*(n-1)/2;
                        break;
                    }
                    int lcount = 1, rcount =1;
                    while(left+1<right && arr[left+1]==arr[left]){
                        lcount++;
                        left++;
                    }
                    while(right-1>left && arr[right-1]==arr[right]){
                        rcount++;
                        right--;
                    }
                    count += (long)lcount*rcount;
                    left++;
                    right--;
                }
            }
        }
        
        
        return (int)(count % mod);
        
    }
}
