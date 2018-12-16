// import java.util.*;

// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Map<String, Integer> memo = new HashMap<>();
//         Set<String> wordSet = new HashSet<>(wordList);
//         Deque<String> queue = new ArrayDeque<>();
//         memo.put(beginWord, 1);
//         queue.push(beginWord);

//         while (!queue.isEmpty()) {
//             String word = queue.poll();
//             for (int i = 0; i < word.length(); i ++) {
//                 StringBuilder sb = new StringBuilder();
//                 sb.append(word);
//                 for (char ch = 'a'; ch <= 'z'; ch ++) {
//                     sb.setCharAt(i, ch);
//                     String newWord = sb.toString();
//                     if (wordSet.contains(newWord) && newWord.equals(endWord)) return memo.get(word) + 1;
//                     if (wordSet.contains(newWord) && !memo.containsKey(newWord)) {
//                         queue.addLast(newWord);
//                         memo.put(newWord, memo.get(word) + 1);
//                     }
//                 }
//             }
//         }
//         return 0;
//     }

//     public static void main(String[] argv) {
//         System.out.println(new Solution().ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
//     }
// }

// Runtime: 133ms


import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);
        int res = 1;

        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k --) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i ++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(word);
                    for (char ch = 'a'; ch <= 'z'; ch ++) {
                        sb.setCharAt(i, ch);
                        String newWord = sb.toString();
                        if (wordSet.contains(newWord) && newWord.equals(endWord))
                            return res + 1;
                        if (newWord != word && wordSet.contains(newWord)) {
                            queue.addLast(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            res ++;
        }
        return 0;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}

