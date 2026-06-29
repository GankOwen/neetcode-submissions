class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c==')'){
                if(stack.isEmpty() || stack.pollLast()!='('){
                    return false;
                }
            }else if(c==']'){
                if(stack.isEmpty() || stack.pollLast()!='['){
                    return false;
                }
            }else if(c=='}'){
                if(stack.isEmpty() || stack.pollLast()!='{'){
                    return false;
                }
            }else{
                stack.offerLast(c);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
