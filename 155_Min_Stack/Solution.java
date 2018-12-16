// Using an ArrayList of (element, currMinimum)
class MinStack {

    /** initialize your data structure here. */
    private int minimum;
    private List<List<Integer>> stack;
    
    public MinStack() {
        minimum = Integer.MAX_VALUE;
        stack = new ArrayList<List<Integer>>();
    }
    
    public void push(int x) {
        minimum = Math.min(minimum, x);
        List<Integer> newElement = new ArrayList<>();
        newElement.add(x);
        newElement.add(minimum);
        stack.add(newElement);
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
        minimum = stack.size() == 0 ? Integer.MAX_VALUE : stack.get(stack.size() - 1).get(1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1).get(0);
    }
    
    public int getMin() {
        return minimum;
    }
}

// Runtime: 64ms



class MinStack {
    private Deque<Integer> orderStack = new ArrayDeque<Integer>();
    private Deque<Integer> minStack = new ArrayDeque<Integer>();
    private int currMin = Integer.MAX_VALUE;
        
    /** initialize your data structure here. */
    public MinStack() {}
    
    public void push(int x) {
        orderStack.push(x);
        currMin = x < currMin ? x : currMin;
        minStack.push(currMin);
    }
    
    public void pop() {
        orderStack.pop();
        minStack.pop();
        currMin = orderStack.size() == 0 ? Integer.MAX_VALUE : minStack.peek();
    }
    
    public int top() {
        return orderStack.peek();
    }
    
    public int getMin() {
        return currMin;
    }
}

// Runtime: 80ms



class MinStack {
    private int min_val = Integer.MAX_VALUE;
    private Stack<Integer> s = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {}
    
    public void push(int x) {
        if (x <= min_val) {
            s.push(min_val);
            min_val = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if (s.pop() == min_val) min_val = s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min_val;
    }
}

// Runtime: 61ms
