package pricematch;

public class InStockChange {
	private String stockName;
	private long tradeTime;
	private double proportionFrom;
	private double proportionTo;

	public InStockChange(String stockName, long tradeTime, double proportionFrom, double proportionTo) {
		super();
		this.stockName = stockName;
		this.tradeTime = tradeTime;
		this.proportionFrom = proportionFrom;
		this.proportionTo = proportionTo;
	}

//	public InStockChange() {
//	}

	public String getStockName() {
		return stockName;
	}

	public double getTradeTime() {
		return tradeTime;
	}

	public double getProportionFrom() {
		return proportionFrom;
	}

	public double getProportionTo() {
		return proportionTo;
	}
}
