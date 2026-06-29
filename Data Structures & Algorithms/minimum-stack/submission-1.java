class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minstack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerLast(val);
        if(minstack.isEmpty()){
            minstack.offerLast(val);
        }else{
            minstack.offerLast(Math.min(val, minstack.peekLast()));
        }
    }
    
    public void pop() {
        stack.pollLast();
        minstack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minstack.peekLast();
    }
}
