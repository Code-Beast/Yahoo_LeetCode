// Given an integer array, 
// your task is to find all the different possible increasing subsequences of the given array, 
// and the length of an increasing subsequence should be at least 2 .

// Each layer, check duplicate, check if less than last element, then handle separately.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) return res;
        
        helper(0, nums, res, new ArrayList<>());
        
        return res;
    }
    
    private void helper(int idx, int[] nums, List<List<Integer>> res, List<Integer> prefix) {
        if (idx == nums.length) {
            if (prefix.size() >= 2) {
                List<Integer> subsequence = new ArrayList<>();
                subsequence.addAll(prefix);
                res.add(subsequence);
            }
            return;
        }
        
        if (idx == 0 || prefix.size() == 0 || nums[idx] > prefix.get(prefix.size() - 1)) {
            helper(idx + 1, nums, res, prefix);
            prefix.add(nums[idx]);
            helper(idx + 1, nums, res, prefix);
            prefix.remove(prefix.size() - 1);
        } else if (nums[idx] == prefix.get(prefix.size() - 1)) {
            prefix.add(nums[idx]);
            helper(idx + 1, nums, res, prefix);
            prefix.remove(prefix.size() - 1);
        } else {
        	helper(idx + 1, nums, res, prefix);
        }
    }

    public static void main(String[] argv) {
    	System.out.println(new Solution().findSubsequences(new int[]{4, 6, 5, 7, 7}));
    }
}

// Runtime: 12ms