class Solution {
    public int diagonalSum(int[][] mat) {
        int result=0,primary =0,secondary=0,j=mat[0].length-1,same =0;
        for(int i=0;i<mat.length;i++){
            primary += mat[i][i];
            secondary += mat[i][j--];
        }
        result = primary + secondary;
        if(mat.length%2!=0){
            int temp = mat.length/2;
            same = mat[temp][temp];
        }
        return result - same;
        
    }
}
