// import javafx.util.Pair;
// import java.util.*;

// class Solution {
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> countMap = new HashMap<>();
//         PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k, new CompareByCount());
//         for (int num : nums) {
//             countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//         }

//         countMap.forEach((key, val) -> pq.add(new Pair<Integer, Integer>(key, val)));

//         List<Integer> res = new ArrayList<>();
//         for (int i = 0; i < k; i ++) {
//             res.add(pq.poll().getKey());
//         }
//         return res;
//     }
    
//     private class CompareByCount implements Comparator<Pair<Integer, Integer>> {
//         public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
//             return b.getValue() - a.getValue();
//         }
//     }

//     public static void main(String[] argv) {
//         System.out.println(new Solution().topKFrequent(new int[]{0, 0, 2, 2, 2, 2, 0}, 2));
//     }
// }

// // Runtime: 100ms



// import java.util.*;

// class Solution {
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> countMap = new HashMap<>();
//         // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
//         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new CompareByCount());

//         for (int num : nums) {
//             countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//         }

//         for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
//             pq.add(entry);
//             if (pq.size() > k) pq.poll(); 
//         }

//         List<Integer> res = new ArrayList<>();
//         while (res.size() < k) {
//             res.add(pq.poll().getKey());
//         }
//         return res;
//     }
    
//     private class CompareByCount implements Comparator<Map.Entry<Integer, Integer>> {
//         public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
//             return b.getValue() - a.getValue();
//         }
//     }

//     public static void main(String[] argv) {
//         System.out.println(new Solution().topKFrequent(new int[]{0, 0, 2, 2, 2, 2, 0}, 2));
//     }
// }

// // 60ms



// import java.util.*;
// class Solution {
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> countMap = new HashMap<>();
//         List<Integer> res = new ArrayList<>();
//         List<Integer>[] bucket = new List[nums.length + 1];
//         for (int num: nums) {
//             countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//         }
        
//         countMap.forEach((key, val) -> {
//             if (bucket[val] == null)
//                 bucket[val] = new ArrayList<>();
//             bucket[val].add(key);
//         });
        
//         for (int i = bucket.length - 1; i > 0; i --) {
//             if (bucket[i] != null) 
//                 for (int j = bucket[i].size() - 1; j >= 0; j --) {
//                     res.add(bucket[i].get(j));
//                     if (res.size() >= k)
//                         return res;
//                 }
//         }
//         return res;
//     }

//     public static void main(String[] argv) {
//         System.out.println(new Solution().topKFrequent(new int[]{0, 0, 2, 2, 2, 2, 0}, 2));
//     }
// }

// // Runtime: 80ms



// use treeMap. Use frequency as the key so we can get all freqencies in order
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
           int freq = map.get(num);
           if(!freqMap.containsKey(freq)){
               freqMap.put(freq, new LinkedList<>());
           }
           freqMap.get(freq).add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
