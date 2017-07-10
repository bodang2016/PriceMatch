package jsonCompiler;

public class ConvertStocks {

	private double price;
	private int proportionFrom;
	private double proportionTo;
	private String stockCode;
	private String stockName;

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setProportionFrom(int proportionFrom) {
		this.proportionFrom = proportionFrom;
	}

	public int getProportionFrom() {
		return proportionFrom;
	}

	public void setProportionTo(double proportionTo) {
		this.proportionTo = proportionTo;
	}

	public double getProportionTo() {
		return proportionTo;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockName() {
		return stockName;
	}

}
