class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(String token : tokens){
            switch(token){
                case "+":
                    deque.push(deque.pop() + deque.pop());
                    break;

                case "-":{
                    int b = deque.pop(), a = deque.pop();
                    deque.push(a - b);
                    break;
                }
                case "*":
                    deque.push(deque.pop() * deque.pop());
                    break;

                case "/":{
                    int b = deque.pop(), a = deque.pop();
                    deque.push(a/b);
                    break;
                }
                default:
                    deque.push(Integer.parseInt(token));
            }
        }
        return deque.pop();
    }
}
