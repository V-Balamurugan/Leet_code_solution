import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[] rowMin = new int[r];
        int[] colMax = new int[c];
        
        // Find row minimums
        for (int i = 0; i < r; i++) {
            int temp = matrix[i][0];
            for (int j = 0; j < c; j++) {
                if (temp > matrix[i][j])
                    temp = matrix[i][j];
            }
            rowMin[i] = temp;
        }
        
        // Find column maximums
        for (int j = 0; j < c; j++) {
            int temp = matrix[0][j];
            for (int i = 0; i < r; i++) {
                if (temp < matrix[i][j])
                    temp = matrix[i][j];
            }
            colMax[j] = temp;
        }
        
        // Compare rowMin and colMax
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rowMin[i] == colMax[j]) {
                    result.add(rowMin[i]);
                }
            }
        }
        
        return result;
    }
}
