class Solution {
    private int[] originArr;
    
    public Solution(int[] nums) {
        originArr = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originArr.clone();
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = originArr.clone();
        for (int i = 0; i < res.length; i ++) {
            int swapIdx = (int)Math.floor(Math.random() * (i + 1));
            int temp = res[swapIdx];
            res[swapIdx] = res[i];
            res[i] = temp;
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

// Runtime: 160ms
// Time: O(n^2)
// Space: O(n)
