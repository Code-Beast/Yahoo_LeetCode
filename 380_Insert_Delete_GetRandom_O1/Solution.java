class RandomizedSet {

    private Set<Integer> set;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)) return false;
        else {
            set.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        else {
            set.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int r = (int)Math.floor(Math.random() * set.size());
        for (int num: set) {
            if (r -- == 0)
                return num;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// Runtime: 163ms



class RandomizedSet {
    private List<Integer> array = new ArrayList<>();
    private Map<Integer, Integer> idxMap = new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {}
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) return false;
        array.add(val);
        idxMap.put(val, array.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) return false;
        int last = array.get(array.size() - 1);
        int pos = idxMap.get(val);
        array.set(pos, last);
        idxMap.put(last, pos);
        idxMap.remove(val);
        array.remove(array.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return array.get((int)Math.floor(Math.random() * array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// Runtime: 100ms
