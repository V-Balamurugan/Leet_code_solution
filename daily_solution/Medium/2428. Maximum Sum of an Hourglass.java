--------------------------------------------(Brute force)--------------------------------------------------------------

class Solution {
    static int hourglasssum(int[][] grid){
        int sum = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1 && (j==0 || j==2))
                    continue;
                sum += grid[i][j];
            }
        }
        return sum;
    }
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n<=3 && m<=3)
            return hourglasssum(grid);
        int count = Integer.MIN_VALUE;;
        for(int r=0;r<=n-3;r++){
            for(int c=0;c<=m-3;c++){
                int temp[][]=new int[3][3];
                for(int i=r;i<r+3;i++){
                    for(int j=c;j<c+3;j++){
                        temp[i-r][j-c]=grid[i][j];
                    }
                }
                count = Math.max(count,hourglasssum(temp));
            }
        }
        return count;
    }
}
