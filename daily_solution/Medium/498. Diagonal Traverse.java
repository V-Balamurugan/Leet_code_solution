class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        System.gc();
        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];
        int index = 0;

        // Start from first row
        for (int col = 0; col < cols; col++) {

            ArrayList<Integer> temp = new ArrayList<>();

            int r = 0;
            int c = col;

            while (r < rows && c >= 0) {
                temp.add(mat[r][c]);
                r++;
                c--;
            }

            if (col % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int num : temp) {
                result[index++] = num;
            }
        }

        // Start from first column (except first row)
        for (int row = 1; row < rows; row++) {

            ArrayList<Integer> temp = new ArrayList<>();

            int r = row;
            int c = cols - 1;

            while (r < rows && c >= 0) {
                temp.add(mat[r][c]);
                r++;
                c--;
            }

            if ((row + cols - 1) % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int num : temp) {
                result[index++] = num;
            }
        }

        return result;
    }
}
