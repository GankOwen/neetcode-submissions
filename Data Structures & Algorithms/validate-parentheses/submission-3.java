class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c =='}'){
                if(stack.size() == 0 || stack.pop() != '{') return false;
            }else if(c == ')'){
                if(stack.size() == 0 || stack.pop() != '(') return false;
            }else if(c == ']'){
                if(stack.size() == 0 || stack.pop() != '[') return false;
            }else{
                stack.push(c);
            }
            
        }
        return stack.size() == 0 ? true : false;
    }
}
