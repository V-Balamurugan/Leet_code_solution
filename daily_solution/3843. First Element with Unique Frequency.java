class Solution {
    public int firstUniqueFreq(int[] nums) {
        int max = nums[0];
        for(int i:nums){
            if(max<i){
                max = i;
            }
        }
        int freq[]=new int[max+1];

        for(int i: nums){
            freq[i]++;
        }
        int m = freq[0];
        for(int i: freq){
            if(m<i){
                m = i;
            }
        }
        int freq1[]=new int[m+1];

        for(int i: freq){
            freq1[i]++;
        }

        for(int i:nums){
            if(freq1[freq[i]]==1){
                return i;
            }
        }
        return -1;

    }
}
