class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        
        for (int i = s.length() - 1; i >= 0; i --) {
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}

// Rumtime: 2ms
// Time: O(n)
// Space: O(n)
