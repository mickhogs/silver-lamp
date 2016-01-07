package questions;

import businesslogic.StockProfiler;
import models.StockOpportunity;

public class QuestionOne {

	public static void main(String[] args) {
		int[] userStocksInput = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			userStocksInput[i] = Integer.parseInt(args[i]);
		}

		StockProfiler stockProfiler = new StockProfiler(userStocksInput);
		StockOpportunity stockOpportunity = new StockOpportunity();

		stockOpportunity = stockProfiler.findBestStocks();

		System.out.println(stockOpportunity.toString());
	}
}
