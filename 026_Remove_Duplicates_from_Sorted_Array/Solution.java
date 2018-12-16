class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int countDuplicates = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) countDuplicates ++;
            else nums[i - countDuplicates] = nums[i];
        }
        
        return nums.length - countDuplicates;
    }
}

// Runtime: 8ms
// Time: O(n)
// Space: O(1)



class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i ++) {
        	if(pos != i && nums[pos] != nums[i]) {
        		nums[++ pos] = nums[i]; 
        	}
        }
        return pos + 1;
    }
}

// Runtime: 7ms
// Time: O(n)
// Space: O(1)
