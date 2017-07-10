package pricematch;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] stocks = { "sz399300", "sh000852", "sh000001" };
		List<Double> increases = new ArrayList<Double>();
		increases = getPrice.getWeekIndexIncrease(stocks);
		System.out.println(increases.get(0));
		System.out.println(increases.get(1));
		System.out.println(increases.get(2));
		
		String[] urlsStrategies = {"https://111.202.65.195/zuhe/detail?appVersion=1.5.10&appname=jingdonggupiao&channel=AppStore&deviceId=B786BDBB-C566-356D-68CB-17EA5E6F3E4E&deviceModel=iPhone&deviceToken=cc0415eb05dc5e72fdeb18affebd1e205bf2e04ca99cb4c0deed698915bd2f84&dt=1&gpsp=i9OQ0FogQ7exDSu1KW9wBg%3D%3D&id=12177&idfa=B786BDBB-C566-356D-F2DA-AD8B5CC5F14B&jailBroken=false&lan=en-CN&machineName=iPhone9%2C2&mm=ddfa3a8e60834ef2265666cdc6f105c0&partner=AppStore&platCode=3&platVersion=10.3.2&screen=1242%2A2208&timestamp=1499455555&wsKey=AAFZR0U7AEDoUpvaqLvLp3KWPKng-P1vpmRxY7MOQxJB335ilg5BFdcOPoo3GKwMpSl3iJfl8tcu8Zam5OtG-VIoefFyxX5Y"};
		System.out.println(getPrice.getStrategiesData(urlsStrategies).get(0).getInStock().get(2).getCurrentPrice());
		
		String[] urlsInstock = {"https://111.202.65.195/convert/history?appVersion=1.5.10&appname=jingdonggupiao&channel=AppStore&deviceId=B786BDBB-C566-356D-68CB-17EA5E6F3E4E&deviceModel=iPhone&deviceToken=cc0415eb05dc5e72fdeb18affebd1e205bf2e04ca99cb4c0deed698915bd2f84&gpsp=i9OQ0FogQ7exDSu1KW9wBg%3D%3D&id=12229&idfa=B786BDBB-C566-356D-F2DA-AD8B5CC5F14B&jailBroken=false&lan=en-CN&machineName=iPhone9%2C2&mm=916080fc2d7636e035d176b707b5fe79&p=3&partner=AppStore&platCode=3&platVersion=10.3.2&ps=10&screen=1242%2A2208&timestamp=1499584960&wsKey=AAFZR0U7AEDoUpvaqLvLp3KWPKng-P1vpmRxY7MOQxJB335ilg5BFdcOPoo3GKwMpSl3iJfl8tcu8Zam5OtG-VIoefFyxX5Y"};
		System.out.println(getPrice.getInStockChangesData(urlsInstock).size());

	}

}
