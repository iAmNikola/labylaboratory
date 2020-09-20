package gui.technician;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Analysis;
import entities.CurrentUser;
import entities.Report;
import entities.Total;
import entities.users.Patient;
import entities.users.User;
import exceptions.BadLboInputException;
import exceptions.BadNameInputException;
import exceptions.BadPassInputException;
import exceptions.BadPhoneInputException;
import exceptions.BadSexInputException;
import exceptions.BadUserInputException;
import gui.TableModelReport;
import gui.login.Login;
import services.CheckFunctions;
import services.loadsave.analysistypes.LoadAnalysisTypes;
import services.loadsave.reports.LoadReports;
import services.loadsave.reports.SaveReports;
import services.loadsave.saveanalysis.SaveAnalysis;
import services.loadsave.users.LoadUsers;
import services.loadsave.users.SaveUsers;

import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class TechnicianMenu extends JFrame {

	private static final long serialVersionUID = 6049614547118927288L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JComboBox<Report> comboBoxReports;
	private JTable reportTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TechnicianMenu frame = new TechnicianMenu(args);
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
	@SuppressWarnings("unchecked")
	public TechnicianMenu(String[] args) {
		setResizable(false);
		CardLayout cl = new CardLayout(0,0);
		ArrayList<Analysis> analysisTypesList = LoadAnalysisTypes.analysisTypesList;
		Total t = new Total(0);
		ArrayList<Integer> types = new ArrayList<Integer>();
		DefaultComboBoxModel<Report> def = new DefaultComboBoxModel<Report>();
		DefaultComboBoxModel<Report> visit = new DefaultComboBoxModel<Report>();
		ArrayList<Report> rl = LoadReports.getTechnicianReports();
		for (Report r : rl) {
			visit.addElement(r);
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setTitle("Labi Lab");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 171, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(181, 0, 718, 470);
		contentPane.add(panel_1);
		panel_1.setLayout(cl);
		
		JButton btnNewButton = new JButton("Register patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel_1, "name_702471680331900");
			}
		});
		btnNewButton.setBounds(10, 25, 151, 23);
		panel.add(btnNewButton);
		
		JButton btnHomeVisits = new JButton("Home visits");
		btnHomeVisits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_706798885006000");
			}
		});
		btnHomeVisits.setBounds(10, 93, 151, 23);
		panel.add(btnHomeVisits);
		
		JButton btnNewButton_3 = new JButton("Log out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					Login.main(args);
					CurrentUser.currentUser = null;
					dispose();
				}
			}
		});
		btnNewButton_3.setBounds(38, 413, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Analysis reports");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel_1, "name_720089665570700");
			}
		});
		btnNewButton_5.setBounds(10, 127, 151, 23);
		panel.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_702471680331900");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(32, 84, 63, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last name:");
		lblNewLabel_1.setBounds(32, 109, 82, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(33, 34, 86, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(32, 59, 78, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LBO:");
		lblNewLabel_4.setBounds(32, 134, 51, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sex:");
		lblNewLabel_5.setBounds(32, 159, 68, 14);
		panel_2.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(146, 31, 130, 20);
		textField.setColumns(10);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 56, 130, 20);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 81, 130, 20);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 106, 130, 20);
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 131, 130, 20);
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(146, 156, 130, 20);
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Date of birth:");
		lblNewLabel_5_1.setBounds(32, 184, 94, 14);
		panel_2.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Phone:");
		lblNewLabel_5_2.setBounds(32, 209, 68, 14);
		panel_2.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setBounds(32, 234, 68, 14);
		panel_2.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(146, 181, 130, 20);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(146, 206, 130, 20);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(146, 231, 130, 20);
		panel_2.add(textField_8);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_702787519720300");
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(276, 48, 108, 14);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_7 = new JLabel("Vitamini");
		lblNewLabel_7.setBounds(29, 28, 59, 14);
		panel_3.add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Vitamini C");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()) {
					double d = t.total + analysisTypesList.get(0).getPrice();
					t.setTotal(d);
					types.add(1);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(0).getPrice();
					t.setTotal(d);
					types.remove(new Integer(1));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox.setBounds(39, 44, 97, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Vitamini E");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1.isSelected()) {
					double d = t.total + analysisTypesList.get(1).getPrice();
					t.setTotal(d);
					types.add(2);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(1).getPrice();
					t.setTotal(d);
					types.remove(new Integer(2));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(39, 70, 97, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Vitamini A");
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2.isSelected()) {
					double d = t.total + analysisTypesList.get(2).getPrice();
					t.setTotal(d);
					types.add(3);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(2).getPrice();
					t.setTotal(d);
					types.remove(new Integer(3));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2.setBounds(39, 96, 97, 23);
		panel_3.add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("Hormoni");
		lblNewLabel_7_1.setBounds(29, 122, 59, 14);
		panel_3.add(lblNewLabel_7_1);
		
		JCheckBox chckbxGastrin = new JCheckBox("Gastrin");
		chckbxGastrin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxGastrin.isSelected()) {
					double d = t.total + analysisTypesList.get(3).getPrice();
					t.setTotal(d);
					types.add(4);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(3).getPrice();
					t.setTotal(d);
					types.remove(new Integer(4));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxGastrin.setBounds(39, 138, 97, 23);
		panel_3.add(chckbxGastrin);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Leptin");
		chckbxNewCheckBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1_1.isSelected()) {
					double d = t.total + analysisTypesList.get(4).getPrice();
					t.setTotal(d);
					types.add(5);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(4).getPrice();
					t.setTotal(d);
					types.remove(new Integer(5));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1_1.setBounds(39, 164, 97, 23);
		panel_3.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Melatonin");
		chckbxNewCheckBox_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2_1.isSelected()) {
					double d = t.total + analysisTypesList.get(5).getPrice();
					t.setTotal(d);
					types.add(6);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(5).getPrice();
					t.setTotal(d);
					types.remove(new Integer(6));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2_1.setBounds(39, 190, 97, 23);
		panel_3.add(chckbxNewCheckBox_2_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Biohemija");
		lblNewLabel_7_2.setBounds(29, 216, 59, 14);
		panel_3.add(lblNewLabel_7_2);
		
		JCheckBox chckbxUrea = new JCheckBox("Urea");
		chckbxUrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxUrea.isSelected()) {
					double d = t.total + analysisTypesList.get(6).getPrice();
					t.setTotal(d);
					types.add(7);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(6).getPrice();
					t.setTotal(d);
					types.remove(new Integer(7));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxUrea.setBounds(39, 232, 97, 23);
		panel_3.add(chckbxUrea);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Kreatinin");
		chckbxNewCheckBox_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1_2.isSelected()) {
					double d = t.total + analysisTypesList.get(7).getPrice();
					t.setTotal(d);
					types.add(8);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(7).getPrice();
					t.setTotal(d);
					types.remove(new Integer(8));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1_2.setBounds(39, 258, 97, 23);
		panel_3.add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("Ceruloplazmin");
		chckbxNewCheckBox_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2_2.isSelected()) {
					double d = t.total + analysisTypesList.get(8).getPrice();
					t.setTotal(d);
					types.add(9);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(8).getPrice();
					t.setTotal(d);
					types.remove(new Integer(9));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2_2.setBounds(39, 284, 128, 23);
		panel_3.add(chckbxNewCheckBox_2_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("Hematologija");
		lblNewLabel_7_3.setBounds(29, 310, 75, 14);
		panel_3.add(lblNewLabel_7_3);
		
		JCheckBox chckbxSedimentacija = new JCheckBox("Sedimentacija");
		chckbxSedimentacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxSedimentacija.isSelected()) {
					double d = t.total + analysisTypesList.get(9).getPrice();
					t.setTotal(d);
					types.add(10);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(9).getPrice();
					t.setTotal(d);
					types.remove(new Integer(10));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxSedimentacija.setBounds(39, 326, 144, 23);
		panel_3.add(chckbxSedimentacija);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Leukociti");
		chckbxNewCheckBox_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1_3.isSelected()) {
					double d = t.total + analysisTypesList.get(10).getPrice();
					t.setTotal(d);
					types.add(11);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(10).getPrice();
					t.setTotal(d);
					types.remove(new Integer(11));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1_3.setBounds(39, 352, 97, 23);
		panel_3.add(chckbxNewCheckBox_1_3);
		
		JCheckBox chckbxNewCheckBox_2_3 = new JCheckBox("Trombociti");
		chckbxNewCheckBox_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2_3.isSelected()) {
					double d = t.total + analysisTypesList.get(11).getPrice();
					t.setTotal(d);
					types.add(12);
					lblNewLabel_12.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(11).getPrice();
					t.setTotal(d);
					types.remove(new Integer(12));
					lblNewLabel_12.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2_3.setBounds(39, 378, 97, 23);
		panel_3.add(chckbxNewCheckBox_2_3);
		
		JLabel lblNewLabel_8 = new JLabel("Patient's LBO");
		lblNewLabel_8.setBounds(209, 122, 87, 14);
		panel_3.add(lblNewLabel_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(209, 139, 122, 20);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Take sample");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(t.total == 0)) {
					if (!textField_9.getText().equals("")) {
						if (CheckFunctions.lboExists(textField_9.getText())) {
							int[] a = new int[types.size()];
							  for(int i = 0;i < a.length;i++) {
							    a[i] = types.get(i);
							  }
							Report r = new Report(CurrentUser.currentUser, a, t.total);
							LoadReports.reportsList.add(r);
							SaveReports.saveReports();
							for (User u : LoadUsers.usersList) {
								if (u instanceof Patient) {
									Patient p = (Patient) u;
									if (textField_9.getText().equals(String.valueOf(p.getLbo()))) {
										p.addReport(r);
										SaveUsers.saveUsers();
									}
								}
							}
							JOptionPane.showMessageDialog (null, "New analysis created!", "Success!", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "The LBO you input doesn't exist in the database!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "The LBO field can't stay empty!"
								+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
				} else {
					JOptionPane.showMessageDialog(null, "At least one analysis must be selected!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(209, 176, 122, 23);
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("Total:");
		lblNewLabel_11.setBounds(209, 48, 64, 14);
		panel_3.add(lblNewLabel_11);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "name_706798885006000");
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Opened home visit offers");
		lblNewLabel_9.setBounds(38, 34, 162, 14);
		panel_4.add(lblNewLabel_9);
		
		JComboBox<Report> comboBox = new JComboBox<Report>();
		comboBox.setModel(visit);
		comboBox.setBounds(38, 59, 162, 20);
		panel_4.add(comboBox);
		
		JButton btnNewButton_4 = new JButton("Take");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
						Report r = (Report) comboBox.getSelectedItem();
						r.setTechnician(CurrentUser.currentUser);
						SaveReports.saveReports();
						visit.removeElementAt(comboBox.getSelectedIndex());
						JOptionPane.showMessageDialog (null, "Home visit was taken!", "Success!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Select home visit!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setBounds(72, 111, 89, 23);
		panel_4.add(btnNewButton_4);
		
		JPanel blank = new JPanel();
		panel_1.add(blank, "name_706829433160400");
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "name_720089665570700");
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_8_1 = new JLabel("Patient's LBO");
		lblNewLabel_8_1.setBounds(30, 27, 102, 14);
		panel_5.add(lblNewLabel_8_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(30, 44, 122, 20);
		panel_5.add(textField_10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 163, 698, 234);
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane);
		
		comboBoxReports = new JComboBox();
		comboBoxReports.setModel(def);
		comboBoxReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportTable = new JTable(new TableModelReport((Report) comboBoxReports.getSelectedItem()));
				scrollPane.setViewportView(reportTable);
			}
		});
		comboBoxReports.setBounds(229, 44, 173, 20);
		panel_5.add(comboBoxReports);
		
		JButton btnNewButton_6 = new JButton("Search reports");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (CheckFunctions.lboExists(textField_10.getText())) {
					if(def.getSize()>0) {
						scrollPane.remove(reportTable);
					}
					def.removeAllElements();
					ArrayList<Report> rl = LoadReports.getPatientReports(textField_10.getText());
					for (Report r : rl) {
						def.addElement(r);
					}
					comboBoxReports.setModel(def);
				}
			}
		});
		btnNewButton_6.setBounds(30, 75, 122, 23);
		panel_5.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Print report");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveAnalysis.saveAnalysis((Report) comboBoxReports.getSelectedItem());
			}
		});
		btnNewButton_7.setBounds(565, 424, 122, 23);
		panel_5.add(btnNewButton_7);
		
		JLabel lblNewLabel_10 = new JLabel("Report");
		lblNewLabel_10.setBounds(10, 142, 71, 14);
		panel_5.add(lblNewLabel_10);

		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")
					||textField_5.getText().equals("")||textField_6.getText().equals("")||textField_7.getText().equals("")
					||textField_8.getText().equals(""))) {
					if (textField.getText().equals("")&&!textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "If username is filled, the password should be too!"
								+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
					} else if (!textField.getText().equals("")&&textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "If password is filled, the username should be too!"
								+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							Patient p = new Patient(textField.getText(),textField_1.getText(),textField_2.getText(),
													textField_3.getText(),textField_4.getText(),textField_5.getText(),
													textField_6.getText(),textField_7.getText(),textField_8.getText());
							LoadUsers.usersList.add(p);
							SaveUsers.saveUsers();
							JOptionPane.showMessageDialog (null, "New patient has been registered!", "Success!", JOptionPane.INFORMATION_MESSAGE);
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
							textField_8.setText("");
						} catch (BadNameInputException e1) {
							JOptionPane.showMessageDialog(null, "Incorrect name and last name input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						} catch (BadUserInputException e1) {
							JOptionPane.showMessageDialog(null, "Bad username format! Only lowercase alphanumeric character are allowed."
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						} catch (BadPassInputException e1) {
							JOptionPane.showMessageDialog(null, "Bad password format!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						} catch (BadLboInputException e1) {
							JOptionPane.showMessageDialog(null, "Bad LBO format! LBO is consisted from 11 numbers."
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						} catch (BadPhoneInputException e1) {
							JOptionPane.showMessageDialog(null, "Bad phone number format! Phone number is 10 numbers."
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						} catch (BadSexInputException e1) {
							JOptionPane.showMessageDialog(null, "Bad sex format! Options are \"M\" and \"F\""
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						} catch (DateTimeParseException e1) {
							JOptionPane.showMessageDialog(null, "Invalid date format! The format is DD.MM.YYYY."
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "All fields must be filled(except username and password)!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(102, 273, 85, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewAnalysis = new JButton("New analysis");
		btnNewAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_702787519720300");
				lblNewLabel_12.setText(String.valueOf(t.total));
			}
		});
		btnNewAnalysis.setBounds(10, 59, 151, 23);
		panel.add(btnNewAnalysis);
		
		cl.show(panel_1, "name_706829433160400");
	}
}
