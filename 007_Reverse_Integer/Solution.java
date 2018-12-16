class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int revX = 0;
        
        x = Math.abs(x);
        while (x > 0) {
            if (revX > (Math.pow(2, 31) - 1) / 10) return 0;
            revX =  revX * 10 + x % 10;
            if (revX < 0) return 0;
            x /= 10;
        }
        
        return revX * sign;
    }
}

// Runtime: 25ms
// Time: O(n)
// Space: O(1)
