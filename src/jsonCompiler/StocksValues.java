package jsonCompiler;

public class StocksValues {

	private double costPrice;
	private CurrentPrice current;
	private String industry;
	private String industryId;
	private double percent;
	private double returnRateSum;
	private String stockCode;
	private String stockName;

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCurrent(CurrentPrice current) {
		this.current = current;
	}

	public CurrentPrice getCurrent() {
		return current;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double getPercent() {
		return percent;
	}

	public void setReturnRateSum(double returnRateSum) {
		this.returnRateSum = returnRateSum;
	}

	public double getReturnRateSum() {
		return returnRateSum;
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
