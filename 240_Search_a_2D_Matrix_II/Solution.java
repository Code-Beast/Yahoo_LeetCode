class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1, col = 0;
        while (row >= 0 && col < n) {
            int curr = matrix[row][col];
            if (curr == target)
                return true;
            else if (curr < target)
                col ++;
            else
                row --;
        }
        
        return false;
    }
}

// Runtime: 7ms
// Time: O(m + n)
// Space: O(1)
