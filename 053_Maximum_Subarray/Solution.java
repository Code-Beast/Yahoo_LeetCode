class Solution {
    public int maxSubArray(int[] nums) {
        int maximum = nums[0];
        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            if (sum <= 0) {
                sum = 0;
            }
            sum += nums[i];
            maximum = Math.max(maximum, sum);
        }
        
        return maximum;
    }
}

// Runtime: 8ms
// Time: O(n)
// Space: O(1)



class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int minSum = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            
            if (sum - minSum > max) max = sum - minSum;
            if (sum < minSum) minSum = sum;
        }
        
        return max;
    }
}

// Runtime: 8ms
// Time: O(n)
// Space: O(1)



class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}

// Runtime: 22ms
// Time: O(nlog(n))
// Space: O(log(n))
