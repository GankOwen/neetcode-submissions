class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long total = 0;
        int maxPile = 0;
        for(int p : piles){
            total += p;
            maxPile = Math.max(p, maxPile);
        }

        int left = (int) Math.max(1L, (total + h - 1) / h);
        int right = maxPile;

        while(left < right){
            int mid = left + (right - left)/ 2;
            if(canFinish(mid, h, piles)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canFinish(int k, int h, int[] piles){
        int hours = 0;
        for(int p : piles){
            hours += (p + k - 1) / k;
            if(hours > h) return false;
        }
        return true;
    }

    
}
