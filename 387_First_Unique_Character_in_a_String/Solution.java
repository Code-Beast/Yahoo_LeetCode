class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Boolean> countMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (countMap.containsKey(ch)) {
                if(countMap.get(ch) == true) {
                    countMap.put(ch, false);
                }
            } else {
                countMap.put(ch, true);
            }
        }
        
        for (int i = 0; i < s.length(); i ++) {
            if (countMap.get(s.charAt(i)) == true) {
                return i;
            }
        }
        
        return -1;
    }
}

// Runtime: 60ms
// Time: O(n)
// Space: O(1)



class Solution {
    public int firstUniqChar(String s) {
        int[] charMap = new int[26];
        
        for (int i = 0; i < s.length(); i ++) {
            charMap[s.charAt(i) - 'a'] ++;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            if (charMap[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

// Runtime: 14ms
// Time: O(n)
// Space: O(1)
