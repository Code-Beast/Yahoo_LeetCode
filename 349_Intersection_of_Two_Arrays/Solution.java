class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        
        for (int num1: nums1) {
            set1.add(num1);
        }
        
        for (int num2: nums2) {
            if (set1.contains(num2)) intersect.add(num2);
        }
        
        int[] res = new int[intersect.size()];
        int i = 0;
        
        for (int num: intersect) {
            res[i ++] = num;
        }
        
        return res;
    }
}

// Runtime: 2ms
// Time: O(n)
// Space: O(n)



class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int ptr1 = 0, ptr2 = 0;
        
        Set<Integer> intersect = new HashSet<>();
        
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            int num1 = nums1[ptr1], num2 = nums2[ptr2];
            
            if (num1 == num2) {
                intersect.add(num1);
                ptr1 ++;
                ptr2 ++;
            } else if (num1 > num2) {
                ptr2 ++;
            } else {
                ptr1 ++;
            }
        }
        
        int[] res = new int[intersect.size()];
        int i = 0;
        for (int num: intersect) {
            res[i ++] = num;
        }
        
        return res;
    }
}

// Runtime: 3ms
// Time: O(nlogn)
// Space: O(n)
