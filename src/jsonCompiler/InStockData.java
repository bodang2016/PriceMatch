package jsonCompiler;

import java.util.List;

public class InStockData {
	private List<ConvertStocks> convertStocks;
	private int id;
	private String reason;
	private long tradeTime;

	public void setConvertStocks(List<ConvertStocks> convertStocks) {
		this.convertStocks = convertStocks;
	}

	public List<ConvertStocks> getConvertStocks() {
		return convertStocks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setTradeTime(long tradeTime) {
		this.tradeTime = tradeTime;
	}

	public long getTradeTime() {
		return tradeTime;
	}

}
