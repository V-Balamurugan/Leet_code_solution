class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int com[]=new int[n];
        int id =0;
        com[0]=id;
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i]-nums[i-1])>maxDiff)
                id++;
            com[i]=id;
        }
        
        boolean result[] = new boolean[queries.length];
        
        for(int i=0;i<queries.length;i++){
            result[i]=(com[queries[i][0]]==com[queries[i][1]]);
        }
        return result;
    }
}
