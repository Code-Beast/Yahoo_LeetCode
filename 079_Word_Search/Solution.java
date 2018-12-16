class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (helper(i, j, mark, board, 0, word)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(int row, int col, boolean[][] mark, char[][] board, int idx, String word) {
        if (idx == word.length()) return true;
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(idx) || mark[row][col]) return false;
        
        mark[row][col] = true;
        boolean res = helper(row - 1, col, mark, board, idx + 1, word) || helper(row + 1, col, mark, board, idx + 1, word) || helper(row, col - 1, mark, board, idx + 1, word) || helper(row, col + 1, mark, board, idx + 1, word);
        mark[row][col] = false;
        
        return res;
    }
}

// Runtime: 12ms



class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (helper(i, j, board, 0, word)) return true;
            }
        }
        return false;
    }
    
    private boolean helper(int row, int col, char[][] board, int idx, String word) {
        if (idx == word.length()) return true;
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(idx)) return false;
        
        char ch = board[row][col];
        board[row][col] = '#';
        boolean res = helper(row - 1, col, board, idx + 1, word) || helper(row + 1, col, board, idx + 1, word) || helper(row, col - 1, board, idx + 1, word) || helper(row, col + 1, board, idx + 1, word);
        board[row][col] = ch;
        
        return res;
    }
}
// 8ms

// 