package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import pricematch.StrategiesMap;
import pricematch.StrategyData;
import pricematch.getPrice;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField top10NRTextField;
	private JTable dataTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		StrategiesMap comboMap = new StrategiesMap();
		JComboBox strategiesComboBox = new JComboBox();
		strategiesComboBox.setBounds(6, 292, 117, 27);
		Iterator iter = comboMap.getStrategiesMap().entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			strategiesComboBox.addItem(entry.getKey().toString());
		}

		contentPane.add(strategiesComboBox);

		JButton btnFetchData = new JButton("Fetch Data");
		btnFetchData.setBounds(232, 291, 117, 29);
		contentPane.add(btnFetchData);

		top10NRTextField = new JTextField();
		top10NRTextField.setHorizontalAlignment(SwingConstants.CENTER);
		top10NRTextField.setBounds(135, 291, 85, 26);
		top10NRTextField.setText("0.00");
		contentPane.add(top10NRTextField);
		top10NRTextField.setColumns(10);

		JLabel lblCurrent = new JLabel("Current:");
		lblCurrent.setBounds(6, 6, 61, 16);
		contentPane.add(lblCurrent);

		JLabel Currentstockname = new JLabel("/");
		Currentstockname.setHorizontalAlignment(SwingConstants.CENTER);
		Currentstockname.setBounds(16, 34, 117, 29);
		contentPane.add(Currentstockname);

		JLabel lblHS300 = new JLabel("HS300:");
		lblHS300.setBounds(135, 6, 61, 16);
		contentPane.add(lblHS300);

		JLabel HSCompare = new JLabel("/");
		HSCompare.setHorizontalAlignment(SwingConstants.CENTER);
		HSCompare.setBounds(145, 34, 117, 29);
		contentPane.add(HSCompare);

		JLabel lblZz = new JLabel("ZZ1000:");
		lblZz.setBounds(263, 6, 61, 16);
		contentPane.add(lblZz);

		JLabel ZZCompare = new JLabel("/");
		ZZCompare.setHorizontalAlignment(SwingConstants.CENTER);
		ZZCompare.setBounds(273, 34, 117, 29);
		contentPane.add(ZZCompare);

		JLabel lblSzIndex = new JLabel("SZ Index:");
		lblSzIndex.setBounds(392, 6, 85, 16);
		contentPane.add(lblSzIndex);

		JLabel SZCompare = new JLabel("/");
		SZCompare.setHorizontalAlignment(SwingConstants.CENTER);
		SZCompare.setBounds(402, 34, 117, 29);
		contentPane.add(SZCompare);

		JButton btnSwitch = new JButton("Show Convert");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSwitch.setBounds(361, 291, 158, 29);
		contentPane.add(btnSwitch);

		final Object[] columnNames = { "Stock", "Percent", "Current", "Cost", "Return", "New Stock" };
		String[] urlsStrategies = {
				"https://111.202.65.195/zuhe/detail?appVersion=1.5.10&appname=jingdonggupiao&channel=AppStore&deviceId=B786BDBB-C566-356D-68CB-17EA5E6F3E4E&deviceModel=iPhone&deviceToken=cc0415eb05dc5e72fdeb18affebd1e205bf2e04ca99cb4c0deed698915bd2f84&dt=1&gpsp=i9OQ0FogQ7exDSu1KW9wBg%3D%3D&id=12177&idfa=B786BDBB-C566-356D-F2DA-AD8B5CC5F14B&jailBroken=false&lan=en-CN&machineName=iPhone9%2C2&mm=ddfa3a8e60834ef2265666cdc6f105c0&partner=AppStore&platCode=3&platVersion=10.3.2&screen=1242%2A2208&timestamp=1499455555&wsKey=AAFZR0U7AEDoUpvaqLvLp3KWPKng-P1vpmRxY7MOQxJB335ilg5BFdcOPoo3GKwMpSl3iJfl8tcu8Zam5OtG-VIoefFyxX5Y" };
		List<StrategyData> rawData = getPrice.getStrategiesData(urlsStrategies);
		Object[][] data = new Object[rawData.get(0).getInStock().size()][6];
		for (int i = 0; i < rawData.get(0).getInStock().size(); i++) {
			for (int j = 0; j < 6; j++) {
				switch (j) {
				case 0:
					data[i][j] = rawData.get(0).getInStock().get(i).getName();
					break;
				case 1:
					data[i][j] = rawData.get(0).getInStock().get(i).getPrcent();
					break;
				case 2:
					data[i][j] = rawData.get(0).getInStock().get(i).getCurrentPrice();
					break;
				case 3:
					data[i][j] = rawData.get(0).getInStock().get(i).getCostPrice();
					break;
				case 4:
					data[i][j] = rawData.get(0).getInStock().get(i).getReturnRateSum();
					break;
				case 5:
					data[i][j] = "";
					break;
				}
			}
		}
		dataTable = new JTable(data, columnNames);
		dataTable.setPreferredScrollableViewportSize(new Dimension(300, 80));
		TableColumn column = null;
		int colunms = dataTable.getColumnCount();
		for (int i = 0; i < colunms; i++) {
			column = dataTable.getColumnModel().getColumn(i);
			column.setPreferredWidth(82);
		}
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scroll = new JScrollPane(dataTable);
		scroll.setBounds(15, 85, 500, 200);
		contentPane.add(scroll);
		this.setVisible(true);
	}
}
