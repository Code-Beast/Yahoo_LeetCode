import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> history = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
        	if (HashMap.containsKey(nums[i])) {
        		return new int[]{HashMap[nums[i]], i};
        	} else {
        		HashMap.set(target - nums[i], i);
        	}
        }
    }
}

// Runtime: 3ms
// Time: O(n)
// Space: O(n)