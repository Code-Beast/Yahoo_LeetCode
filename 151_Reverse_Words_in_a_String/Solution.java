public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> wordList = new ArrayList<>();
        boolean isWord = false;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (isWord && ch == ' ') {
                isWord = false;
                wordList.add(sb.toString());
                sb.setLength(0);
            } else if (ch != ' ' && !isWord) {
                isWord = true;
                sb.append(ch);
            } else if (isWord) {
                sb.append(ch);
            }
        }
        if (sb.length() != 0) {
            wordList.add(sb.toString());
            sb.setLength(0);
        }
        
        for (int i = wordList.size() - 1; i >= 0; i --) {
            sb.append(wordList.get(i));
            if (i != 0)
                sb.append(' ');
        }
        
        return sb.toString();
    }
}

// Runtime: 6ms
// Time: O(n)
// Space: O(n)



public class Solution {
    public String reverseWords(String s) {
        String res = "";
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i > 0; --i) {
            res += words[i] + " ";   
        }
        return res + words[0];
    }
}

// Runtime: 18ms



public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

// Runtime: 8ms
