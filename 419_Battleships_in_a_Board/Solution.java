class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length;
        int n = board[0].length;
        int sum = 0;
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == '.' || i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X')
                    continue;
                sum ++;
            }
        }
        
        return sum;
    }
}

// Runtime: 2ms



class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length;
        int n = board[0].length;
        int sum = 0;
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    if (i + 1 == m || board[i + 1][j] == '.') {
                        int k = j + 1;
                        while (k < n && board[i][k] == 'X') {
                            if (i + 1 < m && board[i + 1][k] == 'X')
                                return 0;
                            board[i][k ++] = '.';
                        }
                        sum ++;
                    } else if (j + 1 == n || board[i][j + 1] == '.') {
                        int k = i + 1;
                        while (k < m && board[k][j] == 'X') {
                            if (j + 1 < n && board[k][j + 1] == 'X')
                                return 0;
                            board[k ++][j] = '.';
                        }
                        sum ++; 
                    } else {
                        return 0;
                    }
                }
            }
        }
        
        return sum;
    }
}

// Runtime: 3ms




class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length;
        int n = board[0].length;
        int sum = 0;
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    if (i + 1 == m || board[i + 1][j] == '.') {
                        int k = j + 1;
                        while (k < n && board[i][k] == 'X') {
                            if (i + 1 < m && board[i + 1][k] == 'X')
                                return 0;
                            board[i][k ++] = '.';
                        }
                        sum ++;
                        j = k;
                    } else if (j + 1 == n || board[i][j + 1] == '.') {
                        int k = i + 1;
                        while (k < m && board[k][j] == 'X') {
                            if (j + 1 < n && board[k][j + 1] == 'X')
                                return 0;
                            board[k ++][j] = '.';
                        }
                        sum ++; 
                        j ++;
                    } else {
                        return 0;
                    }
                }
            }
        }
        
        return sum;
    }
}

// Runtime: 2ms
