class Solution {
    public void moveZeroes(int[] nums) {
        int currCount = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                currCount += 1;
            } else if (currCount != 0){
                nums[i - currCount] = nums[i];
                nums[i] = 0;
            }
        }
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(1)



class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                swap(nums, i, j ++);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(1)
