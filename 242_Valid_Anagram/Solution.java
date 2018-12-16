class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            alphabet[s.charAt(i) - 'a'] ++;
        }
        
        for (int i = 0; i < t.length(); i ++) {
            alphabet[t.charAt(i) - 'a'] --;
            if (alphabet[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}

// Runtime: 3ms
// Time: O(n)
// Space: O(1)



class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] sAlphabet = new int[26];
        int[] tAlphabet = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            sAlphabet[s.charAt(i) - 'a'] ++;
            tAlphabet[t.charAt(i) - 'a'] ++;
        }
        
        for (int i = 0; i < 26; i ++) {
            if (sAlphabet[i] != tAlphabet[i]) return false;
        }
        return true;
    }
}

// Runtime: 5ms
// Time: O(m+n)
// Space: O(1)



class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            alphabet[s.charAt(i) - 'a'] ++;
            alphabet[t.charAt(i) - 'a'] --;
        }
        
        for (int i = 0; i < 26; i ++) {
            if (alphabet[i] != 0) return false;
        }
        return true;
    }
}

// Runtime: 3ms
// Time: O(m+n)
// Space: O(1)
