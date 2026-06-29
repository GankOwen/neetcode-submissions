class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(String t : tokens){
            switch(t){
                case "+":{
                    deque.offerLast(deque.pollLast() + deque.pollLast());
                    break;
                }
                    
                case "-":{
                    int b = deque.pollLast(), a = deque.pollLast();
                    deque.offerLast(a-b);
                    break;
                }
                    
                case "*":{
                    deque.offerLast(deque.pollLast() * deque.pollLast());
                    break;
                }
                    
                case "/":{
                    int b = deque.pollLast(), a = deque.pollLast();
                    deque.offerLast(a/b);
                    break;
                }
                    
                default:{
                    deque.offerLast(Integer.parseInt(t));
                }
            }
        }
        return deque.pollLast();
    }
}
