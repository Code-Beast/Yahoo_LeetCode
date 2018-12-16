/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) end = mid - 1;
            else if (!isBadVersion(mid)) start = mid + 1;
        }
        
        return start;
    }
}

// Runtime: 15ms
// Time: O(logn)
// Space: O(1)



/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        
        return start;
    }
}

// Runtime: 15ms
// Time: O(logn)
// Space: O(1)



/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = start + (end - start) / 2;
        
        while (start <= end) {
            if (isBadVersion(mid)) end = mid - 1;
            else start = mid + 1;
            mid = start + (end - start) / 2;
        }
        
        return start;
    }
}

// Runtime: 12ms
// Time: O(logn)
// Space: O(1)
