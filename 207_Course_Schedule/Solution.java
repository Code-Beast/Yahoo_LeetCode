class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i ++) {
            if (preMap.containsKey(prerequisites[i][0])) {
                preMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                Set<Integer> pres = new HashSet<>();
                pres.add(prerequisites[i][1]);
                preMap.put(prerequisites[i][0], pres);
            }
        }
        
        Set<Integer> memo = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry: preMap.entrySet()) {
            int course = entry.getKey();
            Set<Integer> pres = entry.getValue();
            memo.add(course);
            if (!isValid(preMap, memo, course, pres))
                return false;
            memo.clear();
        }
        
        return true;
    }
    
    private boolean isValid(Map<Integer, Set<Integer>> preMap, Set<Integer> memo, int course, Set<Integer> pres) {
        for (int pre: pres) {
            if (memo.contains(pre)) continue;
            Set<Integer> newPres = preMap.get(pre);
            memo.add(pre);
            if (newPres == null) continue;
            if (newPres.contains(course) || !isValid(preMap, memo, course, newPres)) return false;
        }
        return true;
    }
}

// Runtime: 531ms



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] presMap = new boolean[numCourses][numCourses];
        int[] memo = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i ++) {
            presMap[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        
        for (int course = 0; course < numCourses; course ++) {
            if (!isValid(presMap, memo, course))
                return false;
        }
        
        return true;
    }
    
    private boolean isValid(boolean[][] presMap, int[] memo, int course) {
        if (memo[course] == -1) return false;
        if (memo[course] == 1) return true;
        memo[course] = -1;
        for (int i = 0; i < presMap[course].length; i ++) {
            if (presMap[course][i] && !isValid(presMap, memo, i))
                return false;
        }
        memo[course] = 1;
        return true;
    }
}

// Runtime: 28ms



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> presMap = new ArrayList<>();
        int[] memo = new int[numCourses];
        
        for (int i = 0; i < numCourses; i ++) {
            presMap.add(new ArrayList<>());
        };
        
        for (int i = 0; i < prerequisites.length; i ++) {
            presMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for (int course = 0; course < numCourses; course ++) {
            if (!isValid(presMap, memo, course))
                return false;
        }
        
        return true;
    }
    
    private boolean isValid(List<List<Integer>> presMap, int[] memo, int course) {
        if (memo[course] == -1) return false;
        if (memo[course] == 1) return true;
        memo[course] = -1;
        for (int preCourse: presMap.get(course)) {
            if (!isValid(presMap, memo, preCourse))
                return false;
        }
        memo[course] = 1;
        return true;
    }
}

// Runtime: 6ms



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> presMap = new ArrayList<>();
        int[] out = new int[numCourses];
        
        for (int i = 0; i < numCourses; i ++) {
            presMap.add(new ArrayList<>());
        };
        
        for (int i = 0; i < prerequisites.length; i ++) {
            presMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            out[prerequisites[i][1]] ++;
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < numCourses; i ++) {
            if (out[i] == 0) queue.addLast(i);
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int pre: presMap.get(course)) {
                out[pre] --;
                if (out[pre] == 0) queue.addLast(pre);
            }
        }
        
        for (int i = 0; i < numCourses; i ++) {
            if (out[i] != 0) return false;
        }
        
        return true;
    }
}

// Runtime: 8ms
