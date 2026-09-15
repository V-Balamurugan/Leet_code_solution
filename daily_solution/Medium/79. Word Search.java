class Solution {

    public boolean exist(char[][] board, String word) {

        int r = board.length;
        int c = board[0].length;

        // Step 1: Frequency check
        int[] freq = new int[127];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                freq[board[i][j]]++;
            }
        }

        for (char ch : word.toCharArray()) {
            freq[ch]--;

            if (freq[ch] < 0) {
                return false;
            }
        }

        // Step 2: Try every cell as starting point
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean dfs(char[][] board, String word,
                        int i, int j, int index) {

        // Word completely found
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Check 4 directions
        boolean found =
                dfs(board, word, i - 1, j, index + 1) || // up
                dfs(board, word, i + 1, j, index + 1) || // down
                dfs(board, word, i, j - 1, index + 1) || // left
                dfs(board, word, i, j + 1, index + 1);    // right

        // Restore cell
        board[i][j] = temp;

        return found;
    }
}
