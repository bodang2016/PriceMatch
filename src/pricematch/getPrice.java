package pricematch;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import jsonCompiler.ConvertStocks;
import jsonCompiler.InStockData;
import jsonCompiler.LoadJson;
import jsonCompiler.StatsValues;
import jsonCompiler.StocksValues;

public class getPrice {
	public static List<Double> getWeekIndexIncrease(String[] stocks) {
		List<Double> increase = new ArrayList<Double>();
		try {
			byte[] b = new byte[256];
			InputStream in = null;
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			for (int index = 0; index < stocks.length; index++) {
				try {
					URL u = new URL("http://data.gtimg.cn/flashdata/hushen/weekly/" + stocks[index] + ".js");
					in = u.openStream();
					int i;
					while ((i = in.read(b)) != -1) {
						bo.write(b, 0, i);
					}
					String result = bo.toString();
					String[] weeks = result.split("\\n");
					String thisWeekPrice = weeks[weeks.length - 2];
					String lastWeekPrice = weeks[weeks.length - 3];
					String[] thisPriceDataset = thisWeekPrice.split(" ");
					String[] lastPriceDataset = lastWeekPrice.split(" ");
					increase.add((Double.parseDouble(thisPriceDataset[2]) - Double.parseDouble(lastPriceDataset[2]))
							/ Double.parseDouble(lastPriceDataset[2]) * 100);
					bo.reset();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if (in != null) {
						in.close();
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return increase;
	}

	public static List<StrategyData> getStrategiesData(String[] urls) {
		List<StrategyData> strategiesData = new ArrayList<StrategyData>();
		for (int i = 0; i < urls.length; i++) {
			String str = LoadJson.loadFromUrl(urls[i]);
			Map mapsReturn = (Map) JSON.parse(str);
			Map mapsData = (Map) JSON.parse((mapsReturn.get("data").toString()));
			Map mapsPkg = (Map) JSON.parse((mapsData.get("pkg").toString()));

			StrategyData dataCell = new StrategyData();
			StatsValues statsValues = JSON.parseObject(mapsPkg.get("value").toString(), StatsValues.class);
			dataCell.setReturnRateW(statsValues.getReturnRateW());
			dataCell.setReturnRateM(statsValues.getReturnRateM());
			dataCell.setReturnRateSum(statsValues.getReturnRateSum());

			JSONArray stockarray = JSON.parseArray(mapsPkg.get("stocks").toString());
			Iterator<Object> it = stockarray.iterator();
			while (it.hasNext()) {
				JSONObject ob = (JSONObject) it.next();
				StocksValues stocksValues = JSON.parseObject(ob.toString(), StocksValues.class);
				Stock stock = new Stock(stocksValues.getStockName(), stocksValues.getPercent(),
						stocksValues.getCurrent().getCurrent(), stocksValues.getCostPrice(),
						stocksValues.getReturnRateSum());
				dataCell.addInStock(stock);
			}
			strategiesData.add(dataCell);
		}
		return strategiesData;
	}

	public static List<InStockChange> getInStockChangesData(String[] urls) {
		List<InStockChange> inStockChangesData = new ArrayList<InStockChange>();
		for (int i = 0; i < urls.length; i++) {
			String str = LoadJson.loadFromUrl(urls[i]);
			Map mapsReturn = (Map) JSON.parse(str);
			JSONArray inStockarray = JSON.parseArray(mapsReturn.get("data").toString());
			for (int j = 0; j < inStockarray.size(); j++) {
				InStockData inStockData = JSON.parseObject(inStockarray.get(j).toString(), InStockData.class);
				ConvertStocks convertStock = inStockData.getConvertStocks().get(0);
				InStockChange dataCell = new InStockChange(convertStock.getStockName(), inStockData.getTradeTime(),
						convertStock.getProportionFrom(), convertStock.getProportionTo());
				inStockChangesData.add(dataCell);
			}

		}
		return inStockChangesData;

	}
}
