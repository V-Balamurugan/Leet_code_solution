class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();

        int count=0;
        while(count<k){
            int temp = grid[r-1][c-1];
            int temp1 = grid[0][0];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(i==0 && j==0)
                        continue;
                    int a = grid[i][j];
                    grid[i][j]=temp1;
                    temp1= a;
                }
            }
            count+=1;
            grid[0][0]=temp;
        }
        for (int i = 0; i <r; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j =0; j < c; j++) {
                temp.add(grid[i][j]);
            }
            result.add(temp);
        }
        return result;
    }
}
