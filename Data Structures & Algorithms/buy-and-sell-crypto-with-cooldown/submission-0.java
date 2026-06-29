class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;

        int hold = -prices[0];
        int cool = 0;
        int rest = 0;

        for(int i = 1; i < n; i++){
            int prevHold = hold;
            int prevCool = cool;
            int prevRest = rest;

            int price = prices[i];

            hold = Math.max(prevHold, prevRest - price);

            cool = prevHold + price;

            rest = Math.max(prevRest, prevCool);
        }

        return Math.max(cool, rest);
    }
}
