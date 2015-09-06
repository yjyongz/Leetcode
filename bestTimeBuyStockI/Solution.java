public class Solution {
    public int maxProfit(int[] prices) {
		/*
		 * i < j where price[j] - prices[i] yeilds max 
		 */
		if (prices == null || prices.length == 0) return 0;
		int max = 0, buy = prices[0];
		for (int i = 1; i < prices.length;i++) {
			if (max < prices[i] - buy) {
				max = prices[i]  - buy;
			} else if (buy > prices[i]){
				buy = prices[i];
			}	
		}        
		return max;
    }
}
