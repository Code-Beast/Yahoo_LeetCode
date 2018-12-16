class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i ++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        List<Character> keyList = new ArrayList(frequencyMap.keySet());
        Collections.sort(keyList, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        StringBuilder sb = new StringBuilder();
        for (char key : keyList) {
            for (int i = 0; i < frequencyMap.get(key); i ++) {
                sb.append(key);
            }
        }
        
        return sb.toString();
    }
}

// Runtime: 120ms



class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i ++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        while (pq.peek() != null) {
            Map.Entry<Character, Integer> entry = pq.poll();
            for (int i = 0; i < entry.getValue(); i ++)
                sb.append(entry.getKey());
        }
        
        return sb.toString();
    }
}

// 64ms



class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i ++) {
            frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        String[] memo = new String[s.length() + 1];
        Arrays.fill(memo, "");
        StringBuilder sb = new StringBuilder();
        
        for (char key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            for (int i = 0; i < frequency; i ++) {
                sb.append(key);
            }
            memo[frequencyMap.get(key)] = memo[frequencyMap.get(key)].concat(sb.toString());
            sb.setLength(0);
        }
        
        for (int i = s.length(); i >= 0; i --) 
            sb.append(memo[i]);
        
        return sb.toString();
    }
}

// Runtime: 40ms



class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
						
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
                
        for (char key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            for (int i = 0; i < frequency; i ++) {
                bucket[frequency].add(key);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i --) {
            int j = 0;
            if (bucket[i] != null) {
                while (j < bucket[i].size()) {
                    sb.append(bucket[i].get(j ++));
                }
            }   
        }
            
        return sb.toString();
    }
}

// Runtime: 27ms
