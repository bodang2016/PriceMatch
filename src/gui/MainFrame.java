package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import pricematch.StrategiesMap;
import pricematch.StrategyData;
import pricematch.getPrice;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
	private List<StrategyData> rawData;
	private DefaultTableModel tableModel;
	private Object[][] data = { {} };
	private JScrollPane scroll;
	final Object[] columnNames = { "Stock", "Percent", "Current", "Cost", "Return", "New Stock" };
	private DecimalFormat df = new DecimalFormat("#0.00");

	JComboBox<String> strategiesComboBox;
	JLabel lblWeekData;
	JLabel lblMonthData;
	JLabel lblSumData;
	JLabel Currentstockname;
	JLabel HSCompare;
	JLabel ZZCompare;
	JLabel SZCompare;
	JLabel NrTopCompare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setResizable(false);
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

		strategiesComboBox = new JComboBox<String>();
		strategiesComboBox.setBounds(6, 311, 117, 27);
		Iterator iter = StrategiesMap.getStrategiesMap().entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			strategiesComboBox.addItem(entry.getKey().toString());
		}

		contentPane.add(strategiesComboBox);

		top10NRTextField = new JTextField();
		top10NRTextField.setHorizontalAlignment(SwingConstants.CENTER);
		top10NRTextField.setBounds(135, 311, 85, 26);
		top10NRTextField.setText("0.00");
		contentPane.add(top10NRTextField);
		top10NRTextField.setColumns(10);

		initIndexLabel();
		initStatsLabel();

		JButton btnSwitch = new JButton("Show Convert");
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSwitch.setBounds(361, 311, 158, 29);
		contentPane.add(btnSwitch);

		tableModel = new DefaultTableModel(data, columnNames);

		dataTable = new JTable(tableModel);

		dataTable.setPreferredScrollableViewportSize(new Dimension(300, 80));
		setColumnWidth();
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scroll = new JScrollPane(dataTable);
		scroll.setBounds(15, 105, 500, 200);
		contentPane.add(scroll);

		JButton btnFetchData = new JButton("Fetch Data");
		btnFetchData.setBounds(232, 311, 117, 29);
		contentPane.add(btnFetchData);
		btnFetchData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int strategiesId = StrategiesMap.getStrategiesMap()
						.get(strategiesComboBox.getSelectedItem().toString());
				String[] urlsStrategies = {
						"https://111.202.65.195/zuhe/detail?appVersion=1.5.10&appname=jingdonggupiao&channel=AppStore&deviceId=B786BDBB-C566-356D-68CB-17EA5E6F3E4E&deviceModel=iPhone&deviceToken=cc0415eb05dc5e72fdeb18affebd1e205bf2e04ca99cb4c0deed698915bd2f84&dt=1&gpsp=i9OQ0FogQ7exDSu1KW9wBg%3D%3D&id="
								+ strategiesId
								+ "&idfa=B786BDBB-C566-356D-F2DA-AD8B5CC5F14B&jailBroken=false&lan=en-CN&machineName=iPhone9%2C2&mm=ddfa3a8e60834ef2265666cdc6f105c0&partner=AppStore&platCode=3&platVersion=10.3.2&screen=1242%2A2208&timestamp=1499455555&wsKey=AAFZR0U7AEDoUpvaqLvLp3KWPKng-P1vpmRxY7MOQxJB335ilg5BFdcOPoo3GKwMpSl3iJfl8tcu8Zam5OtG-VIoefFyxX5Y" };
				rawData = getPrice.getStrategiesData(urlsStrategies);
				compareHeader();
				data = new Object[rawData.get(0).getInStock().size()][6];
				for (int i = 0; i < rawData.get(0).getInStock().size(); i++) {
					for (int j = 0; j < 6; j++) {
						switch (j) {
						case 0:
							data[i][j] = rawData.get(0).getInStock().get(i).getName();
							break;
						case 1:
							data[i][j] = df.format(rawData.get(0).getInStock().get(i).getPrcent() * 100) + "%";
							break;
						case 2:
							data[i][j] = rawData.get(0).getInStock().get(i).getCurrentPrice();
							break;
						case 3:
							data[i][j] = rawData.get(0).getInStock().get(i).getCostPrice();
							break;
						case 4:
							data[i][j] = df.format(rawData.get(0).getInStock().get(i).getReturnRateSum() * 100) + "%";
							break;
						case 5:
							data[i][j] = "";
							break;
						}
					}
				}
				tableModel = new DefaultTableModel(data, columnNames);
				dataTable.setModel(tableModel);
				setColumnWidth();
				tableModel.fireTableDataChanged();
			}

		});

		this.setVisible(true);
	}

	private void setColumnWidth() {
		TableColumn column = null;
		int colunms = dataTable.getColumnCount();
		for (int i = 0; i < colunms; i++) {
			column = dataTable.getColumnModel().getColumn(i);
			column.setPreferredWidth(82);
		}
	}

	private void compareHeader() {
		if (!rawData.isEmpty()) {
			String[] stocks = { "sz399300", "sh000852", "sh000001" };
			List<Double> increases = new ArrayList<Double>();
			increases = getPrice.getWeekIndexIncrease(stocks);
			double ReturnRateWeek = rawData.get(0).getReturnRateW();

			Currentstockname.setText(strategiesComboBox.getSelectedItem().toString());
			lblWeekData.setText(String.valueOf(df.format(ReturnRateWeek * 100)) + "%");
			lblMonthData.setText(String.valueOf(df.format(rawData.get(0).getReturnRateM() * 100)) + "%");
			lblSumData.setText(String.valueOf(df.format(rawData.get(0).getReturnRateSum() * 100)) + "%");

			if (ReturnRateWeek < increases.get(0)) {
				HSCompare.setText(df.format(increases.get(0) * 100).toString() + "%");
				HSCompare.setBackground(Color.green);
			} else {
				HSCompare.setText(df.format(increases.get(0) * 100).toString() + "%");
				HSCompare.setBackground(Color.red);
			}
			if (ReturnRateWeek < increases.get(1)) {
				ZZCompare.setText(df.format(increases.get(1) * 100).toString() + "%");
				ZZCompare.setBackground(Color.green);
			} else {
				ZZCompare.setText(df.format(increases.get(1) * 100).toString() + "%");
				ZZCompare.setBackground(Color.red);
			}
			if (ReturnRateWeek < increases.get(2)) {
				SZCompare.setText(df.format(increases.get(2) * 100).toString() + "%");
				SZCompare.setBackground(Color.green);
			} else {
				SZCompare.setText(df.format(increases.get(2) * 100).toString() + "%");
				SZCompare.setBackground(Color.red);
			}
			if (ReturnRateWeek < Double.valueOf(top10NRTextField.getText()) / 100) {
				NrTopCompare.setText(top10NRTextField.getText() + "%");
				NrTopCompare.setBackground(Color.green);
			} else {
				NrTopCompare.setText(top10NRTextField.getText() + "%");
				NrTopCompare.setBackground(Color.red);
			}
		}
	}

	private void initIndexLabel() {
		JLabel lblCurrent = new JLabel("Current:");
		lblCurrent.setBounds(6, 6, 61, 16);
		contentPane.add(lblCurrent);

		Currentstockname = new JLabel("/");
		Currentstockname.setHorizontalAlignment(SwingConstants.CENTER);
		Currentstockname.setFont(new Font("宋体", Font.BOLD, 16));
		Currentstockname.setBounds(16, 34, 117, 29);
		contentPane.add(Currentstockname);

		JLabel lblHS300 = new JLabel("HS300:");
		lblHS300.setBounds(135, 6, 61, 16);
		contentPane.add(lblHS300);

		HSCompare = new JLabel("/");
		HSCompare.setHorizontalAlignment(SwingConstants.CENTER);
		HSCompare.setBounds(145, 34, 77, 29);
		HSCompare.setOpaque(true);
		HSCompare.setBackground(Color.gray);
		contentPane.add(HSCompare);

		JLabel lblZz = new JLabel("ZZ1000:");
		lblZz.setBounds(233, 6, 61, 16);
		contentPane.add(lblZz);

		ZZCompare = new JLabel("/");
		ZZCompare.setHorizontalAlignment(SwingConstants.CENTER);
		ZZCompare.setBounds(243, 34, 77, 29);
		ZZCompare.setOpaque(true);
		ZZCompare.setBackground(Color.gray);
		contentPane.add(ZZCompare);

		JLabel lblSzIndex = new JLabel("SZ Index:");
		lblSzIndex.setBounds(332, 6, 85, 16);
		contentPane.add(lblSzIndex);

		SZCompare = new JLabel("/");
		SZCompare.setHorizontalAlignment(SwingConstants.CENTER);
		SZCompare.setBounds(342, 34, 77, 29);
		SZCompare.setOpaque(true);
		SZCompare.setBackground(Color.gray);
		contentPane.add(SZCompare);

		JLabel lblNrTop = new JLabel("NR TOP10:");
		lblNrTop.setBounds(431, 6, 85, 16);
		contentPane.add(lblNrTop);

		NrTopCompare = new JLabel("/");
		NrTopCompare.setHorizontalAlignment(SwingConstants.CENTER);
		NrTopCompare.setBounds(441, 34, 77, 29);
		NrTopCompare.setOpaque(true);
		NrTopCompare.setBackground(Color.gray);
		contentPane.add(NrTopCompare);
	}

	private void initStatsLabel() {

		JLabel lblWeek = new JLabel("Week:");
		lblWeek.setBounds(135, 66, 61, 16);
		contentPane.add(lblWeek);

		lblWeekData = new JLabel("/");
		lblWeekData.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekData.setBounds(145, 86, 77, 11);
		contentPane.add(lblWeekData);

		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(233, 66, 61, 16);
		contentPane.add(lblMonth);

		lblMonthData = new JLabel("/");
		lblMonthData.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthData.setBounds(243, 86, 77, 11);
		contentPane.add(lblMonthData);

		JLabel lblSum = new JLabel("Sum:");
		lblSum.setBounds(332, 66, 85, 16);
		contentPane.add(lblSum);

		lblSumData = new JLabel("/");
		lblSumData.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumData.setBounds(342, 86, 77, 11);
		contentPane.add(lblSumData);
	}
}
