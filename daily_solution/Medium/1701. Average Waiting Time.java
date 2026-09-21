class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long end = 0;
        long result = 0;
        for(int i=0;i<n;i++){
            end = Math.max(end,customers[i][0])+customers[i][1];
            result += end - customers[i][0];
        }
        return (double)result/n;
    }
}
