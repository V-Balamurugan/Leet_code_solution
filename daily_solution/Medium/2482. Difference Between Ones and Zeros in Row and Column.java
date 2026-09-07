-----------------------------------------(Brute force)----------------------------------------

class Solution {

    static int countrow(int val, int[][] grid, int r, int c) {
        int count = 0;

        for (int i = 0; i < c; i++) {
            if (grid[r][i] == val) {
                count++;
            }
        }

        return count;
    }

    static int countcol(int val, int[][] grid, int r, int c) {
        int count = 0;

        for (int i = 0; i < r; i++) {
            if (grid[i][c] == val) {
                count++;
            }
        }

        return count;
    }

    public int[][] onesMinusZeros(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[] rowOne = new int[r];
        int[] rowZero = new int[r];

        int[] colOne = new int[c];
        int[] colZero = new int[c];

        // Count each row only once
        for (int i = 0; i < r; i++) {
            rowOne[i] = countrow(1, grid, i, c);
            rowZero[i] = countrow(0, grid, i, c);
        }

        // Count each column only once
        for (int j = 0; j < c; j++) {
            colOne[j] = countcol(1, grid, r, j);
            colZero[j] = countcol(0, grid, r, j);
        }

        int[][] result = new int[r][c];

        // Use stored values
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                result[i][j] =
                        rowOne[i]
                        + colOne[j]
                        - rowZero[i]
                        - colZero[j];
            }
        }

        return result;
    }
}
