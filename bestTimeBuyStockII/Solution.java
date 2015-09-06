public class Solution {
    public int maxProfit(int[] prices) {
        /*
         * i < j where price[j] - prices[i] yeilds max 
         */
        if (prices.length == 0) return 0;
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length;i++) {
			maxSoFar = Math.max(maxSoFar, maxCur += Math.max(0, prices[i] - prices[i -1]));
        }
        return maxSoFar;
    }
}
