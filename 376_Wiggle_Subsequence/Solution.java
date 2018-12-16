class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int currSign = 0;
        int currEnd = 0;
        int currLength = 1;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] - nums[currEnd] != 0 || nums[i] - nums[i - 1] != 0) {
                int diffWithEnd = nums[i] - nums[currEnd];
                int diffWithLast = nums[i] - nums[i - 1];
                if (diffWithEnd != 0 && (currSign == 0 || currSign * diffWithEnd < 0)) {
                    currSign = diffWithEnd > 0 ? 1 : -1;
                    currLength ++;
                } else if (diffWithLast != 0 && (currSign == 0 || currSign * diffWithLast < 0)) {
                    currSign = diffWithLast > 0 ? 1 : -1;
                    currEnd = i;
                    currLength ++;
                }
            }
            i ++;
        }
               
        return currLength;
    }
}

// RUntime: 0ms