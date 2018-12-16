class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int numSmaller = 0;
            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] <= mid) numSmaller ++;
            }
            if (numSmaller <= mid) low = mid + 1;
            else high = mid;
            numSmaller = 0;
        }
        
        return low;
    }
}

// Runtime: 5ms
// Time: O(nlogn)
// Space: O(1)



class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int t = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        
        while (true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) break;
        }
        
        return slow;
    }
}

// Runtime: 0ms
// Time: O(n)
// Space: O(1)
