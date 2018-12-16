class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        
        List<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);
        res.add(lastRow);
        
        for (int i = 0; i < numRows - 1; i ++)
        {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < lastRow.size() - 1; j ++) {
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            res.add(row);
            lastRow = row;
        }
        return res;
    }
}

// Runtime: 1ms
// Time: O(n^2)
// Time: O(n^2)
