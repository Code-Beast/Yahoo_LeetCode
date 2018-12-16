class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != majority) {
                count --;
            } else {
                count ++;
            }
            
            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }
        
        return majority;
    }
}

// Runtime: 3ms
// Time: O(n)
// Space: O(1)
