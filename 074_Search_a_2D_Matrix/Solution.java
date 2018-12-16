class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int up = 0;
        int down = m - 1;
        while (up <= down) {
            int midV = (up + down) / 2;
            if (matrix[midV][0] == target) return true;
            else if (matrix[midV][0] < target)
                up = midV + 1;
            else down = midV - 1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int midH = (left + right) / 2;
            if (matrix[down][midH] == target) return true;
            else if (matrix[down][midH] < target) {
                left = midH + 1;
            } else {
                right = midH - 1;
            }
        }
        return false;
    }
}

// Runtime: 6ms
// Time: O(logmn)
// Space: O(1)
