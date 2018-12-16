class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}

// Runtime: 4ms
// Time: O(logn)
// Space: O(1)



class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) return i - 1;
        }
        return nums.length - 1;
    }
}

// Runtime: 3ms
// Time: O(n)
// Space: O(1)
