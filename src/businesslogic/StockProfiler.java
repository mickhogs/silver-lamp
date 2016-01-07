package businesslogic;

import java.security.InvalidParameterException;

import models.StockOpportunity;

public class StockProfiler {

	private int[] stockList;

	public StockProfiler(int[] stockList) {
		this.stockList = stockList;
	}

	public StockOpportunity findBestStocks() {
		StockOpportunity stockOpportunity = new StockOpportunity();

		int maxProfit = 0;
		int sellIndex = 0;
		int buyIndex = 0;
		int currentProfit;

		// we must have at least 2 stocks to compare
		if (stockList != null && stockList.length >= 2) {
			for (int i = 0; i < stockList.length - 1; i++) {
				for (int j = i + 1; j < stockList.length; j++) {
					if (stockList[i] < 0 || stockList[j] < 0) {
						throw new InvalidParameterException("Stock value cannot be negative");
					}
					
					currentProfit = stockList[j] - stockList[i];
					
					if (currentProfit >= maxProfit) {
						maxProfit = currentProfit;
						buyIndex = i;
						sellIndex = j;
					}
				}
			}
			
			stockOpportunity.setBuy(stockList[buyIndex]);
			stockOpportunity.setSell(stockList[sellIndex]);
		} else {
			throw new InvalidParameterException("Stock list must have at least two stocks");
		}
		
		return stockOpportunity;
	}
}
