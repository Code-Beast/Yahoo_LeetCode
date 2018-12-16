class Solution {
    public int numTrees(int n) {
        int num = 0;
        Set<Integer> memo = new HashSet<>();
        for (int i = 1; i <= n; i ++) {
            memo.add(i);
            num += numTreesRoot(1, n, i, memo);
            memo.remove(i);
        }
        return num;
    }
    
    private int numTreesRoot(int start, int end, int root, Set<Integer> memo) {
        if (start == end) return 1;
        int num1 = 0;
        int num2 = 0;
        
        if (start == root) num1 = 1;
        else {
            for (int i = start; i < root; i ++) {
                if (!memo.contains(i)) {
                    memo.add(i);
                    num1 += numTreesRoot(start, root - 1, i, memo);
                    memo.remove(i);
                }
            }
        }
        
        if (end == root) num2 = 1;
        else {
            for (int i = end; i > root; i --) {
                if (!memo.contains(i)) {
                    memo.add(i);
                    num2 += numTreesRoot(root + 1, end, i, memo);
                    memo.remove(i);
                }
            }
        }
        
        return num1 * num2;
    }
}

// Time Limit Exceeded



class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        return dp[n];
    }
}

// Runtime: 0ms
