import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return helper(s, 0, wordDict, memo);
    }
    
    private boolean helper(String s, int start, List<String> wordDict, Map<Integer, Boolean> memo) {
        if (start == s.length()) return true;
        if (memo.containsKey(start)) return memo.get(start);
        for (String word : wordDict) {
            if (s.substring(start).startsWith(word) && helper(s, start + word.length(), wordDict, memo)) {
                memo.put(start, true);
                return true;
            }
        }
        memo.put(start, false);
        return false;
    }

    public static void main(String[] argv) {
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(new Solution().wordBreak("applepenapple", wordDict));
    }
}

// Runtime: 6ms



import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 0; i < dp.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] argv) {
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(new Solution().wordBreak("applepenapple", wordDict));
    }
}

// Runtime: 18ms