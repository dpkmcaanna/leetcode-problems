class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE, minIndex = 0 ;
        int n = prices.length;

        for(int i = 0; i < n; i++) {
            if(minPrice > prices[i]) {
                minPrice = prices[i];
                minIndex = i;
            }

            maxProfit = minIndex < i ? Math.max(maxProfit, prices[i] - minPrice) : maxProfit;
        }

        return maxProfit;
    }
}