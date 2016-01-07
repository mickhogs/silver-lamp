package models;

public class StockOpportunity {

	private Integer buy;
	private Integer sell;

	public Integer getBuy() {
		return buy;
	}

	public void setBuy(Integer buy) {
		this.buy = buy;
	}

	public Integer getSell() {
		return sell;
	}

	public void setSell(Integer sell) {
		this.sell = sell;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("buy ");
		builder.append(getBuy());
		builder.append("\nsell ");
		builder.append(getSell());
		return builder.toString();
	}

}
