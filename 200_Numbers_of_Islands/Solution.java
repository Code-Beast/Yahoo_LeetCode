class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        char currMark = '1';
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1')
                    helper(grid, i, j, ++ currMark);
            }
        }
        
        return currMark - '1';
    }
    
    public void helper(char[][] grid, int row, int col, char mark) {
        grid[row][col] = mark;
        int m = grid.length;
        int n = grid[0].length;
        
        if (row < m - 1 && grid[row + 1][col] == '1')
            helper(grid, row + 1, col, mark);
        if (col < n - 1 && grid[row][col + 1] == '1')
            helper(grid, row, col + 1, mark);
        if (row > 0 && grid[row - 1][col] == '1')
            helper(grid, row - 1, col, mark);
        if (col > 0 && grid[row][col - 1] == '1')
            helper(grid, row, col - 1, mark);
    }
}

// Runtime: 7ms
// Time: O(n)
// Space: O(n)



class Solution {
    private int m;
    private int n;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1')
                    count ++;
                    helper(grid, i, j);
            }
        }
        
        return count;
    }
    
    public void helper(char[][] grid, int row, int col) {
        if (row == m|| col == n || row < 0 || col < 0 || grid[row][col] != '1') 
            return;
        grid[row][col] = '0';
        
        helper(grid, row + 1, col);
        helper(grid, row, col + 1);
        helper(grid, row - 1, col);
        helper(grid, row, col - 1);
    }
}

// Runtime: 7ms
// Time: O(n)
// Space: O(n)
