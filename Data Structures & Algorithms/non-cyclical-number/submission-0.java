class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n!=1){
            if(seen.contains(n)) return false;
            seen.add(n);
            n = next(n);
        }
        return true;
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
