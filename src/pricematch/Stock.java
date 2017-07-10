package pricematch;

public class Stock {
	private String name;
	private double prcent;
	private double currentPrice;
	private double costPrice;
	private double returnRateSum;

	public Stock(String name, double prcent, double currentPrice, double costPrice, double returnRateSum) {
		this.name = name;
		this.prcent = prcent;
		this.currentPrice = currentPrice;
		this.costPrice = costPrice;
		this.returnRateSum = returnRateSum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrcent() {
		return prcent;
	}

	public void setPrcent(double prcent) {
		this.prcent = prcent;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getReturnRateSum() {
		return returnRateSum;
	}

	public void setReturnRateSum(double returnRateSum) {
		this.returnRateSum = returnRateSum;
	}
}
