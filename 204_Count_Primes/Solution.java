class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        int limit = (int)Math.floor(Math.sqrt(n - 1));
        int count = 0;
        boolean[] primes = new boolean[n - 1]; // 1 -> n-1
        Arrays.fill(primes, true);
        primes[0] = false;

        for (int i = 3; i < n; i += 2) {
            if (primes[i - 1]) {
                count ++;
                if (i <= limit) { 
                    for (int j = i * i; j < n; j += i) {
                        primes[j - 1] = false;
                    }
                }
            }
        }

        return count + 1;
    }
}

// Runtime: 18ms
// Space: O(n)



class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        int limit = (int)Math.floor(Math.sqrt(n - 1));
        int count = 0;
        boolean[] nonPrimes = new boolean[n - 1]; // 1 -> n-1
        
        
        for (int i = 2; i < n; i ++) {
            if (!nonPrimes[i - 1]) {
                count ++;
                if (i <= limit) {
                    for (int j = i * i; j < n; j += i) {
                        nonPrimes[j - 1] = true;
                    }     
                }
            }
        }
        
        return count;
    }
}

// Runtime: 14ms
// Space: O(n)
