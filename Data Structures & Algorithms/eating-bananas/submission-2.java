class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long total_piles = 0;
        int max_piles = 0;
        for(int p : piles){
            total_piles += p;
            max_piles = Math.max(max_piles, p);
        }
        int lower_bound = (int)((total_piles + h - 1) / h);
        int left = lower_bound, right = max_piles;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canReach(piles, mid, h)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean canReach(int[] piles, int k, int h){
        long hours = 0;
        for(int p : piles){
            hours += (p + k - 1)/k;
            if (hours > h) {
                return false;
            }
        }
        return hours <= h;
    }
    
}
