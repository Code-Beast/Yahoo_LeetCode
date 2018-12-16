class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        
        int upper = (int)Math.pow(10, n) - 1;
        int lower = (int)Math.pow(10, n - 1);
        
        for (int i = upper; i >= lower; i --) {
            long palindrome = getPalindrome(i);
            if (palindrome > (long)upper * (long)upper) continue;
            for (long j = upper; j * j >= palindrome; j --) {
                if (palindrome % j == 0) {
                    return (int)(palindrome % 1337);
                }
            }
        }
  
        return -1;
    }
    
    private long getPalindrome(int front) {
        int num = front;
        int end = 0;
        int count = 0;
        while (num > 0) {
            end = end * 10 + num % 10;
            num /= 10;
            count ++;
        }
        
        return front * (long)Math.pow(10, count) + end;
    }
}

// Runtime: 269ms

