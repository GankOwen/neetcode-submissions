class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long total = 0;
        int max = 0;

        for(int pile : piles){
            total += pile;
            max = Math.max(pile, max);
        }

        int left = (int) Math.max(1L, (total + h - 1)/h);
        int right = max;

        while(left <  right){
            int mid = left + (right - left) / 2;
            if(!canFinish(mid, h, piles)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public boolean canFinish(int k, int h, int[]piles){
        long hours = 0;
        for(int pile : piles){
            hours += (pile + k-1) /k;
            if(hours > h) return false;
        }
        return true;
    }
}
