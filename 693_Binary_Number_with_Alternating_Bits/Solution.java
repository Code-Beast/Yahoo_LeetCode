class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = -1;
        while (n > 0) {
            int bit = n % 2;
            if (bit == lastBit) return false;
            lastBit = bit;
            n /= 2;
        }
        
        return true;
    }
}

// Runtime: 8ms
// Time: O(logn)
// Space: O(1)



// Notice the operands priority
// '+'/'-'/'*'/'/'/'=='/'<'/'>' is more prioritized than &/|/^/>>/<<

class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n + (n >> 1);
        int y = x + 1;
        return (x & y) == 0;
    }
}

// Runtime: 8ms
// Time: O(1)
// Space: O(1)



// Notice the operands priority
// '+'/'-'/'*'/'/'/'=='/'<'/'>' is more prioritized than &/|/^/>>/<<

class Solution {
    public boolean hasAlternatingBits(int n) {
        return (n + n / 2 & n + n / 2 + 1) == 0;
    }
}

// Runtime: 8ms
// Time: O(1)
// Space: O(1)



// Notice the operands priority
// '+'/'-'/'*'/'/'/'=='/'<'/'>' is more prioritized than &/|/^/>>/<<

class Solution {
    public boolean hasAlternatingBits(int n) {
        String binaryStr = Integer.toBinaryString(n);
        for (int i = 1; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i - 1) == binaryStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

// Runtime: 9ms
// Time: O(logn)
// Space: O(n)



// Notice the operands priority
// '+'/'-'/'*'/'/'/'=='/'<'/'>' is more prioritized than &/|/^/>>/<<

class Solution {
    public boolean hasAlternatingBits(int n) {
        return ((n ^= n / 4) & (n - 1)) == 0;
    }
} 

// Runtime: 8ms
// Time: O(1)
// Space: O(1)
