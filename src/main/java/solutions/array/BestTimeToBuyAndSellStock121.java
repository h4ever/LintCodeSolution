package solutions.array;

public class BestTimeToBuyAndSellStock121 {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

similiar as MaximumSubarray53
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {
        int maxCur=0; int maxSoFar=0;
        for(int i=1;i<prices.length;i++){
            maxCur=Math.max(0,maxCur+=(prices[i]-prices[i-1]));
            maxSoFar=Math.max(maxCur,maxSoFar);
        }
        return maxSoFar;
    }
}
