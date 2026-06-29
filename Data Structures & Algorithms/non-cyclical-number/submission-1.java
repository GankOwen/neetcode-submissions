class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = next(slow);
            fast = next(next(fast));

            if(fast == 1) return true;
        }while(slow != fast);

        return slow == 1;
    }

    public int next (int x){
        int sum = 0;
        while(x > 0){
            int d = x % 10;
            sum += d * d;
            x /= 10;
        }
        return sum;
    }
}
