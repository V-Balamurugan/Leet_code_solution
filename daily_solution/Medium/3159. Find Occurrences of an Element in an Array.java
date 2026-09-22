--------------------------------------------(Array (or) Hash Table approach)----------------------------------------------

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = queries.length;
        int result[]=new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x)
                pos.add(i);
        }
        for(int i=0;i<n;i++){
            int k = queries[i];
            if(k<=pos.size()){
                result[i]=pos.get(k-1);
            }
            else{
                result[i]=-1;
            }
        }

        return result;
    }
}

---------------------------------------------(Broute force approach)-----------------------------------------------
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = queries.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int count = 0;
            result[i]=-1;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==x){
                    count++;
                    if(count == queries[i]){
                        result[i]=j;
                        continue;
                    }
                }
            }
        }
        return result;
    }
}
