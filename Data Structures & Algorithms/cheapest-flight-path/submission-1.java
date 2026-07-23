class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = Integer.MAX_VALUE/2;
        int[] prices = new int[n];
        Arrays.fill(prices, INF);
        prices[src] = 0;

        for(int i = 0; i <=k; i++){
            int[] nextPrices = prices.clone();
            for(int [] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(prices[from] == INF){
                    continue;
                }
                nextPrices[to] = Math.min(nextPrices[to], prices[from] + price);
            }
            prices = nextPrices;
        }
        return prices[dst] == INF ? -1 : prices[dst];
    }
}
