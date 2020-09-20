package gui.patient;

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
import gui.ComboBoxReports;
import gui.TableModelReport;
import gui.login.Login;
import services.loadsave.analysistypes.LoadAnalysisTypes;
import services.loadsave.homevisitprices.LoadHomeVisitPrices;
import services.loadsave.reports.LoadReports;
import services.loadsave.reports.SaveReports;
import services.loadsave.saveanalysis.SaveAnalysis;
import services.loadsave.users.LoadUsers;
import services.loadsave.users.SaveUsers;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class PatientMenu extends JFrame {

	private static final long serialVersionUID = -5910109315651366798L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Report> comboBoxReports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientMenu frame = new PatientMenu(args);
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
	public PatientMenu(String[] args) {
		setResizable(false);
		CardLayout cl = new CardLayout(0, 0);
		ArrayList<Analysis> analysisTypesList = LoadAnalysisTypes.analysisTypesList;
		Total t = new Total(0);
		ArrayList<Integer> types = new ArrayList<Integer>();
		Patient cu = (Patient) LoadUsers.getCurrentUser(CurrentUser.currentUser);
		String lbo = String.valueOf(cu.getLbo());
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setTitle("Labi Lab");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 170, 453);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(180, 0, 706, 464);
		contentPane.add(panel_1);
		panel_1.setLayout(cl);
		
		
		JButton btnNewButton = new JButton("Analysis reports");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_719555203151300");
			}
		});
		btnNewButton.setBounds(10, 50, 150, 23);
		panel.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					Login.main(args);
					CurrentUser.currentUser = null;
					dispose();
				}
			}
		});
		btnLogOut.setBounds(33, 419, 96, 23);
		panel.add(btnLogOut);
		
		
		JPanel blank = new JPanel();
		panel_1.add(blank, "name_719548010439100");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_719555203151300");
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 134, 686, 282);
		panel_3.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		comboBoxReports = new JComboBox<Report>(new ComboBoxReports(lbo));
		comboBoxReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(new JTable(new TableModelReport((Report) comboBoxReports.getSelectedItem())));
			}
		});
		comboBoxReports.setBounds(25, 40, 219, 20);
		panel_3.add(comboBoxReports);
		
		JButton btnNewButton_2 = new JButton("Save to file");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveAnalysis.saveAnalysis((Report) comboBoxReports.getSelectedItem());
			}
		});
		btnNewButton_2.setBounds(525, 430, 149, 23);
		panel_3.add(btnNewButton_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_1.add(panel_3_1, "name_719597935336000");
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 119, 122, 20);
		panel_3_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(281, 216, 109, 14);
		panel_3_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Vitamini");
		lblNewLabel_7.setBounds(29, 28, 59, 14);
		panel_3_1.add(lblNewLabel_7);
		
		JButton btnMakeAnAppointment = new JButton("Make appointment");
		btnMakeAnAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_719597935336000");
				lblNewLabel_2.setText(String.valueOf(t.total));
			}
		});
		btnMakeAnAppointment.setBounds(10, 84, 150, 23);
		panel.add(btnMakeAnAppointment);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Vitamini C");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()) {
					double d = t.total + analysisTypesList.get(0).getPrice();
					t.setTotal(d);
					types.add(1);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(0).getPrice();
					t.setTotal(d);
					types.remove(new Integer(1));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox.setBounds(39, 44, 97, 23);
		panel_3_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Vitamini E");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1.isSelected()) {
					double d = t.total + analysisTypesList.get(1).getPrice();
					t.setTotal(d);
					types.add(2);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(1).getPrice();
					t.setTotal(d);
					types.remove(new Integer(2));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(39, 70, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Vitamini A");
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2.isSelected()) {
					double d = t.total + analysisTypesList.get(2).getPrice();
					t.setTotal(d);
					types.add(3);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(2).getPrice();
					t.setTotal(d);
					types.remove(new Integer(3));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2.setBounds(39, 96, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("Hormoni");
		lblNewLabel_7_1.setBounds(29, 122, 59, 14);
		panel_3_1.add(lblNewLabel_7_1);
		
		JCheckBox chckbxGastrin = new JCheckBox("Gastrin");
		chckbxGastrin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxGastrin.isSelected()) {
					double d = t.total + analysisTypesList.get(3).getPrice();
					t.setTotal(d);
					types.add(4);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(3).getPrice();
					t.setTotal(d);
					types.remove(new Integer(4));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxGastrin.setBounds(39, 138, 97, 23);
		panel_3_1.add(chckbxGastrin);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Leptin");
		chckbxNewCheckBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1_1.isSelected()) {
					double d = t.total + analysisTypesList.get(4).getPrice();
					t.setTotal(d);
					types.add(5);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(4).getPrice();
					t.setTotal(d);
					types.remove(new Integer(5));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1_1.setBounds(39, 164, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Melatonin");
		chckbxNewCheckBox_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2_1.isSelected()) {
					double d = t.total + analysisTypesList.get(5).getPrice();
					t.setTotal(d);
					types.add(6);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(5).getPrice();
					t.setTotal(d);
					types.remove(new Integer(6));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2_1.setBounds(39, 190, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_2_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Biohemija");
		lblNewLabel_7_2.setBounds(29, 216, 59, 14);
		panel_3_1.add(lblNewLabel_7_2);
		
		JCheckBox chckbxUrea = new JCheckBox("Urea");
		chckbxUrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxUrea.isSelected()) {
					double d = t.total + analysisTypesList.get(6).getPrice();
					t.setTotal(d);
					types.add(7);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(6).getPrice();
					t.setTotal(d);
					types.remove(new Integer(7));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxUrea.setBounds(39, 232, 97, 23);
		panel_3_1.add(chckbxUrea);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Kreatinin");
		chckbxNewCheckBox_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1_2.isSelected()) {
					double d = t.total + analysisTypesList.get(7).getPrice();
					t.setTotal(d);
					types.add(8);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(7).getPrice();
					t.setTotal(d);
					types.remove(new Integer(8));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1_2.setBounds(39, 258, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("Ceruloplazmin");
		chckbxNewCheckBox_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2_2.isSelected()) {
					double d = t.total + analysisTypesList.get(8).getPrice();
					t.setTotal(d);
					types.add(9);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(8).getPrice();
					t.setTotal(d);
					types.remove(new Integer(9));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2_2.setBounds(39, 284, 133, 23);
		panel_3_1.add(chckbxNewCheckBox_2_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("Hematologija");
		lblNewLabel_7_3.setBounds(29, 310, 75, 14);
		panel_3_1.add(lblNewLabel_7_3);
		
		JCheckBox chckbxSedimentacija = new JCheckBox("Sedimentacija");
		chckbxSedimentacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxSedimentacija.isSelected()) {
					double d = t.total + analysisTypesList.get(9).getPrice();
					t.setTotal(d);
					types.add(10);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(9).getPrice();
					t.setTotal(d);
					types.remove(new Integer(10));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxSedimentacija.setBounds(39, 326, 122, 23);
		panel_3_1.add(chckbxSedimentacija);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Leukociti");
		chckbxNewCheckBox_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_1_3.isSelected()) {
					double d = t.total + analysisTypesList.get(10).getPrice();
					t.setTotal(d);
					types.add(11);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(10).getPrice();
					t.setTotal(d);
					types.remove(new Integer(11));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_1_3.setBounds(39, 352, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_1_3);
		
		JCheckBox chckbxNewCheckBox_2_3 = new JCheckBox("Trombociti");
		chckbxNewCheckBox_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox_2_3.isSelected()) {
					double d = t.total + analysisTypesList.get(11).getPrice();
					t.setTotal(d);
					types.add(12);
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					double d = t.total - analysisTypesList.get(11).getPrice();
					t.setTotal(d);
					types.remove(new Integer(12));
					lblNewLabel_2.setText(String.valueOf(d));
				}
			}
		});
		chckbxNewCheckBox_2_3.setBounds(39, 378, 97, 23);
		panel_3_1.add(chckbxNewCheckBox_2_3);
		
		JLabel lblNewLabel_8 = new JLabel("Date");
		lblNewLabel_8.setBounds(212, 28, 87, 14);
		panel_3_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(212, 45, 122, 20);
		panel_3_1.add(textField);
		
		JButton btnNewButton_1 = new JButton("Create request");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				if (t.total > LoadHomeVisitPrices.homeVisitPrices.getTemp()) {
					if (!textField.getText().equals("")) {
						int[] a = new int[types.size()];
						for(int i = 0;i < a.length;i++) {
						    a[i] = types.get(i);
						  }
						try {
							String date = textField.getText();
							if (!(textField_1.getText().equals(""))) {
								date = date +" "+ textField_1.getText().trim() + ":00";
							}
						
							Report r = new Report(a, date, t.total);
							
							LoadReports.reportsList.add(r);
							SaveReports.saveReports();
							for (User u : LoadUsers.usersList) {
								if (u instanceof Patient) {
									Patient p = (Patient) u;
									if (CurrentUser.currentUser.equals(p.getUsername())) {
										p.addReport(r);
										SaveUsers.saveUsers();
										b = true;
									}
								}
							}
						} catch (DateTimeParseException e1) {
							JOptionPane.showMessageDialog(null, "Date and/or time are incorrect! Date format: dd.mm.yyyy. Time format: HH:MM"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
						if (b) {
							JOptionPane.showMessageDialog (null, "New analysis created!", "Success!", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "A date must be specified!"
								+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
				} else {
					JOptionPane.showMessageDialog(null, "At least one analysis must be selected!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(212, 284, 127, 23);
		panel_3_1.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("House visit");
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double d;
				if (chckbxNewCheckBox_3.isSelected()) {
					if (textField_1.getText().equals("")) {
						d = t.total + LoadHomeVisitPrices.homeVisitPrices.getDate();
						t.setTotal(d);
						LoadHomeVisitPrices.homeVisitPrices.setTemp(LoadHomeVisitPrices.homeVisitPrices.getDate());
					} else {
						d = t.total + LoadHomeVisitPrices.homeVisitPrices.getDatetime();
						t.setTotal(d);
						LoadHomeVisitPrices.homeVisitPrices.setTemp(LoadHomeVisitPrices.homeVisitPrices.getDatetime());
					}
					lblNewLabel_2.setText(String.valueOf(d));
				} else {
					d = t.total - LoadHomeVisitPrices.homeVisitPrices.getTemp();
					t.setTotal(d);
					lblNewLabel_2.setText(String.valueOf(d));
				}	
			}
		});
		chckbxNewCheckBox_3.setBounds(212, 146, 122, 23);
		panel_3_1.add(chckbxNewCheckBox_3);
		
		JLabel lblNewLabel = new JLabel("Specific time(costs more if it's a house visit)");
		lblNewLabel.setBounds(212, 100, 307, 14);
		panel_3_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(212, 216, 59, 14);
		panel_3_1.add(lblNewLabel_1);
		

		cl.show(panel_1, "name_719548010439100");
	}
}
