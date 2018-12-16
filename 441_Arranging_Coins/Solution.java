class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(1 + (long)8 * n) - 1) / 2;
    }
}

// Runtime: 25ms
// Time: O(1)
// Space: O(1)



class Solution {
    public int arrangeCoins(int n) {
        long sum = 0;
        int num = 0;
        while (sum <= n) {
            num += 1;
            sum += num;
        } 
        
        return num - 1;
    }
}

// Runtime: 32ms
// Time: O(n^(1/2))
// Space: O(n)



class Solution {
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        long sum = 0;
        
        while (left <= right) {
            sum = ((long)mid + 1) * mid / 2;
            if (sum > n) right = mid - 1;
            else if (sum == n) return mid;
            else left = mid + 1;
            mid = left + (right - left) / 2;
            System.out.println(mid);
        }
        
        return left - 1;
    }
}

// Runtime: 87ms
// Time: O(logn)
// Space: O(1)
