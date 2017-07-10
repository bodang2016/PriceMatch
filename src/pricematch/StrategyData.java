package pricematch;

import java.util.ArrayList;
import java.util.List;

public class StrategyData {
	private double returnRateM;
	private double returnRateW;
	private double returnRateSum;
	private List<Stock> inStock;

	public StrategyData() {
		this.inStock = new ArrayList<Stock>();
	}

	public double getReturnRateM() {
		return returnRateM;
	}

	public void setReturnRateM(double returnRateM) {
		this.returnRateM = returnRateM;
	}

	public double getReturnRateW() {
		return returnRateW;
	}

	public void setReturnRateW(double returnRateW) {
		this.returnRateW = returnRateW;
	}

	public double getReturnRateSum() {
		return returnRateSum;
	}

	public void setReturnRateSum(double returnRateSum) {
		this.returnRateSum = returnRateSum;
	}

	public List<Stock> getInStock() {
		return inStock;
	}

	public void addInStock(Stock stock) {
		this.inStock.add(stock);
	}
}
