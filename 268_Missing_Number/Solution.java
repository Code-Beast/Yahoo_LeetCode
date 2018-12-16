class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length + 1;
        
        for (int num: nums) {
            sum += num;
        }
        return (n + 1) * n / 2 - sum;
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(1)



// Counting
class Solution {
    public int missingNumber(int[] nums) {
        boolean[] hasNum = new boolean[nums.length + 1];
        
        for (int num: nums) {
            hasNum[num] = true;
        }
        
        for (int i = 0; i < hasNum.length; i ++) {
            if (hasNum[i] == false) {
                return i;
            }
        }
        
        return 0;
    }
}

// Runtime: 1ms
// Time: O(n)
// Space: O(n)



class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        
        // in tatal nums.length + 1
        // res = 0 is like the first number 0
        // then i + 1 (i from 0 to nums.length) equals 1 - nums.length + 1
        for (int i = 0; i < nums.length;  i ++) {
            res ^=  (i + 1) ^ nums[i]; 
        }
        
        return res;
    }
}

// Runtime: 0ms
// Time: O(n)
// Space: O(1)



class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid - 1;
            else if (nums[mid] == mid) left = mid + 1;
        }
        
        return left;
    }
}

// Runtime: 8ms
// Time: O(nlogn)
// Space: O(1)
