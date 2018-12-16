// Problem: Given a sorted integer array without duplicates, return the summary of its ranges.

// create a new range when the current element is not continuous with the current range

public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        int startIdx = 0;
        
        for (int i = 1; i <= nums.length; i ++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (i - 1 != startIdx) {
                    sb.append("->");
                    sb.append(nums[i - 1]);
                }
                startIdx = i;
                res.add(sb.toString());
                sb.setLength(0);
                if (i < nums.length) {
                    sb.append(nums[i]);
                }
            }
        }
        
        return res;
    }
}

// Runtime: 201ms



// Using String + instead of StringBuilder
public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int startIdx = 0;
        
        for (int i = 1; i <= nums.length; i ++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (i - 1 != startIdx) {
                    res.add(String.valueOf(nums[startIdx]) + "->" + String.valueOf(nums[i - 1]));
                } else {
                    res.add(String.valueOf(nums[startIdx]));
                }
                if (i != nums.length) startIdx = i;
            }
        }
        
        return res;
    }
}

// Runtime: 167ms

