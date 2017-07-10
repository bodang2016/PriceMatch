package jsonCompiler;

public class CurrentPrice {

	private double change1Range;
	private double current;
	private int tradeType;
	private String tradeTypeLabel;

	public void setChange1Range(double change1Range) {
		this.change1Range = change1Range;
	}

	public double getChange1Range() {
		return change1Range;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public double getCurrent() {
		return current;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeTypeLabel(String tradeTypeLabel) {
		this.tradeTypeLabel = tradeTypeLabel;
	}

	public String getTradeTypeLabel() {
		return tradeTypeLabel;
	}

}