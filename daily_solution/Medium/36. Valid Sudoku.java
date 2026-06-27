class Solution {
    public static boolean chechsudoko(int row, int col, char[][] board) {
        char key = board[row][col];

        // Check column
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == key) {
                return false;
            }
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == key) {
                return false;
            }
        }
        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if ((i != row || j != col) && board[i][j] == key)
                    return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean result = true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if (board[i][j] != '.') {
                    if(!(chechsudoko(i,j,board))){
                        result = false;
                    }
                }
            }
        }
        return result;
        
    }
}
