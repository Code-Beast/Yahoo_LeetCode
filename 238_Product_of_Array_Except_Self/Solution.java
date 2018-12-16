class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;
        int size = nums.length;
        if (size == 0 || size == 1) return nums;
        
        int[] res = new int[size];
        
        res[0] = 1;
        for (int i = 1; i < size; i ++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        res[0] = nums[size - 1];
        for (int i = size - 2; i > 0; i --) {
            res[i] *= res[0];
            res[0] *= nums[i];
        }
        
        return res;
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(n)
