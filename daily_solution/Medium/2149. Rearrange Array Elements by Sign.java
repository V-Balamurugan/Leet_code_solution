---------------------------------------(Brute force)----------------------------------

class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        for(int i:nums){
            if(i<0){
                minus.add(i);
            }
            else{
                plus.add(i);
            }
        }
        
        int[] result = new int[nums.length];
        int index = 0;
        for(int i=0;i<plus.size();i++){
            result[index++]=plus.get(i);
            result[index++]=minus.get(i);
        }
        return result;
    }
}

---------------------------(best approach)--------------------------
  class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i : nums) {
            if (i < 0) {
                result[negativeIndex] = i;
                negativeIndex += 2;
            } else {
                result[positiveIndex] = i;
                positiveIndex += 2;
            }
        }

        return result;
    }
}
