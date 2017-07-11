package pricematch;

import java.util.HashMap;

public class StrategiesMap {
	private static HashMap<String, Integer> strategiesMap;

	public StrategiesMap() {
		
	}

	public static HashMap<String, Integer> getStrategiesMap() {
		strategiesMap = new HashMap<String, Integer>();
		strategiesMap.put("火箭升空", 12177);
		strategiesMap.put("多头回踩", 12177);
		strategiesMap.put("多方炮", 12178);
		strategiesMap.put("揉搓线", 12177);
		strategiesMap.put("底背离", 12177);
		strategiesMap.put("缩量回调", 12177);
		strategiesMap.put("碎步连阳", 12177);
		strategiesMap.put("低位启动", 12177);
		strategiesMap.put("潜行狙击", 12177);
		strategiesMap.put("上升三角", 12177);
		strategiesMap.put("短线突击", 12177);
		strategiesMap.put("箱型震荡", 12177);
		return strategiesMap;
	}
}
