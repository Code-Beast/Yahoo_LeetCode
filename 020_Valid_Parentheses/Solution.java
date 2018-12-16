class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> leftRightMap = new HashMap<>();
        leftRightMap.put(')', '(');
        leftRightMap.put(']', '[');
        leftRightMap.put('}', '{');
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i ++) {
            char parenthesis = s.charAt(i);
            if (leftRightMap.containsKey(parenthesis)) {
                if (stack.peek() == leftRightMap.get(parenthesis)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(parenthesis)
            }
        }
        
        return stack.isEmpty();
    }
}

// Runtime: 5ms
// Time: O(n)
// Space: O(n)