import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            char roman = s.charAt(i);
            if (i < s.length() - 1 && romanMap.get(roman) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(roman);
            } else {
                result += romanMap.get(roman);
            }
        }
        
        return result;
    }
}

// Runtime: 44ms
// Time: O(n)
// Space: O(1)