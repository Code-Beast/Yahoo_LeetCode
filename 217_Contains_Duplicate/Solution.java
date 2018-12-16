class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i ++) 
            if (nums[i] == nums[i + 1]) return true;
        return false;
    }
}

// Runtime: 8ms
// Time: O(nlogn)
// Space: O(1)



class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> countMap = new HashMap<>();
        
        for (int num: nums) {
            if (countMap.containsKey(num)) {
                return true;
            } else {
                countMap.put(num, true);
            }
        }
        return false;
    }
}

// Runtime: 15ms
// Time: O(n)
// Space: O(n)
