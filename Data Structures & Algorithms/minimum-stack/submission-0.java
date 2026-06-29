class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> mins;
    public MinStack() {
        stack = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(mins.isEmpty()){
            mins.push(val);
        }else{
            mins.push(Math.min(mins.peek(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
