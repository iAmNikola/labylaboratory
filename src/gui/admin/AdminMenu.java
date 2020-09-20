package gui.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.CurrentUser;
import entities.users.Laborant;
import entities.users.Technician;
import exceptions.BadEduInputException;
import exceptions.BadNameInputException;
import exceptions.BadPassInputException;
import exceptions.BadSpecInputException;
import exceptions.BadUserInputException;
import gui.TableModelIncome;
import gui.TableModelPatients;
import gui.TableModelSpending;
import gui.login.Login;
import services.CheckFunctions;
import services.loadsave.users.LoadUsers;
import services.loadsave.users.SaveUsers;
import services.loadsave.coefficientbonus.LoadCoefficientBonus;
import services.loadsave.coefficientbonus.SaveCoefficientBonus;
import services.loadsave.homevisitprices.LoadHomeVisitPrices;
import services.loadsave.homevisitprices.SaveHomeVisitPrices;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;

public class AdminMenu extends JFrame {

	private static final long serialVersionUID = -6759085180732534472L;
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
	private JTextField textField_11;
	private JTable incomeTable = new JTable(new TableModelIncome());
	private JTable spendingTable = new JTable(new TableModelSpending());
	private JTable patientsTable = new JTable(new TableModelPatients());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu(args);
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
	public AdminMenu(String[] args) {
		CardLayout cl = new CardLayout(0,0);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setTitle("Labi Lab");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 167, 472);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(177, 0, 725, 472);
		contentPane.add(panel_1);
		panel_1.setLayout(cl);
		
		JButton btnNewButton = new JButton("Register employee");
		btnNewButton.setBounds(10, 21, 147, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel_1, "name_635969054539600");
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					Login.main(args);
					CurrentUser.currentUser = null;
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(34, 431, 89, 23);
		panel.add(btnNewButton_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "name_635969054539600");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(29, 25, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last name:");
		lblNewLabel_1.setBounds(29, 50, 68, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(29, 75, 68, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(29, 100, 68, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Education:");
		lblNewLabel_4.setBounds(29, 125, 68, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Specialization:");
		lblNewLabel_5.setBounds(29, 150, 96, 14);
		panel_2.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField.setBounds(135, 22, 145, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_1.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_1.setColumns(10);
		textField_1.setBounds(135, 47, 145, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_2.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_2.setColumns(10);
		textField_2.setBounds(135, 72, 145, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_3.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_3.setColumns(10);
		textField_3.setBounds(135, 97, 145, 20);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_4.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_4.setColumns(10);
		textField_4.setBounds(135, 122, 145, 20);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_5.getText().length()>=43&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_5.setColumns(10);
		textField_5.setBounds(135, 147, 145, 20);
		panel_2.add(textField_5);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textField_2.getText().equals("")||textField_3.getText().equals(""))) {
					if (CheckFunctions.isUsernameFree(textField_2.getText())) {
						if (textField_5.getText().equals("")) {
							try {
								Technician t = new Technician(textField_2.getText(), textField_3.getText(),textField.getText(), textField_1.getText(), textField_4.getText());
								LoadUsers.usersList.add(t);
								SaveUsers.saveUsers();
								JOptionPane.showMessageDialog (null, "A new technician has been added to the system!", "Success!", JOptionPane.INFORMATION_MESSAGE);
								textField_2.setText("");
								textField_3.setText("");
								textField.setText("");
								textField_1.setText("");
								textField_4.setText("");
							} catch (BadNameInputException e1) {
								JOptionPane.showMessageDialog(null, "Incorrect name and last name input!"
																+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadUserInputException e1) {
								JOptionPane.showMessageDialog(null, "Bad username format! Only lowercase letters and \"_\" are allowed."
																+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadPassInputException e1) {
								JOptionPane.showMessageDialog(null, "Bad password!"
																+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadEduInputException e1) {
								JOptionPane.showMessageDialog(null, "Inncorect education level input! Values from 3-8 are valid."
																+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							try {
								Laborant l = new Laborant(textField_2.getText(), textField_3.getText(),textField.getText(), textField_1.getText(), textField_4.getText(), textField_5.getText());
								LoadUsers.usersList.add(l);
								SaveUsers.saveUsers();
								JOptionPane.showMessageDialog (null, "A new laborant has been added to the system!", "Success", JOptionPane.INFORMATION_MESSAGE);
								textField_2.setText("");
								textField_3.setText("");
								textField.setText("");
								textField_1.setText("");
								textField_4.setText("");
								textField_5.setText("");
							} catch (BadNameInputException e1) {
								JOptionPane.showMessageDialog(null, "Incorrect name and last name input!"
										+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadUserInputException e1) {
								JOptionPane.showMessageDialog(null, "Bad username format! Only lowercase alphanumeric character are allowed."
										+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadPassInputException e1) {
								JOptionPane.showMessageDialog(null, "Bad password format!"
										+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadEduInputException e1) {
								JOptionPane.showMessageDialog(null, "Inncorect education level input! Values from 3-8 are valid."
										+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							} catch (BadSpecInputException e1) {
								JOptionPane.showMessageDialog(null, "Input specialization doesn't exist or you input the same multiple times."
										+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Username already in use!"
								+ " Please choose another one.","", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "All fields must be filled(except specialization)!"
													+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(113, 199, 89, 23);
		panel_2.add(btnNewButton_2);
		
		JPanel blank = new JPanel();
		panel_1.add(blank, "name_636845049777000");
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, "name_636919499203300");
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Current pay coefficient for Laborant:");
		lblNewLabel_6.setBounds(26, 30, 228, 14);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Current pay coefficient for Technician:");
		lblNewLabel_6_1.setBounds(26, 55, 228, 14);
		panel_4.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(264, 30, 72, 14);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(264, 55, 72, 14);
		panel_4.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_6.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_6.setBounds(37, 129, 141, 20);
		panel_4.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_7.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_7.setBounds(236, 129, 149, 20);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("New laborant coefficient");
		lblNewLabel_9.setBounds(37, 107, 160, 14);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New technician coefficient");
		lblNewLabel_10.setBounds(236, 107, 176, 14);
		panel_4.add(lblNewLabel_10);
		
		JButton btnNewButton_6 = new JButton("Apply");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				if (!(textField_6.getText().equals("") && textField_7.getText().equals(""))) {
					if (!textField_6.getText().equals("")) {
						try {
							LoadCoefficientBonus.coefficients.setLabCoefficient(textField_6.getText());
							SaveCoefficientBonus.saveCoefficientBonus();
							lblNewLabel_7.setText(textField_6.getText());
							textField_6.setText("");
							b = true;
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Bad input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}	
					}
					if (!textField_7.getText().equals("")) {
						try {
							LoadCoefficientBonus.coefficients.setTechCoefficient(textField_7.getText());
							SaveCoefficientBonus.saveCoefficientBonus();
							lblNewLabel_8.setText(textField_7.getText());
							textField_7.setText("");
							b = true;
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Bad input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
					}
					if(b){
						JOptionPane.showMessageDialog (null, "Changes applied!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "At least one field must be filled!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6.setBounds(150, 165, 89, 23);
		panel_4.add(btnNewButton_6);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_637876085401800");
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6_2 = new JLabel("Current bonus for laborant:");
		lblNewLabel_6_2.setBounds(34, 26, 184, 14);
		panel_3.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Current bonus for technician:");
		lblNewLabel_6_2_1.setBounds(34, 58, 184, 14);
		panel_3.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(219, 26, 58, 14);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(219, 58, 58, 14);
		panel_3.add(lblNewLabel_12);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_8.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_8.setBounds(34, 127, 148, 20);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("New bonus for laborant");
		lblNewLabel_13.setBounds(34, 102, 152, 14);
		panel_3.add(lblNewLabel_13);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_9.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_9.setColumns(10);
		textField_9.setBounds(231, 127, 148, 20);
		panel_3.add(textField_9);
		
		JLabel lblNewLabel_13_1 = new JLabel("New bonus for technician");
		lblNewLabel_13_1.setBounds(231, 102, 148, 14);
		panel_3.add(lblNewLabel_13_1);
		
		JButton btnNewButton_7 = new JButton("Apply");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				if (!(textField_8.getText().equals("") && textField_9.getText().equals(""))) {
					if (!textField_8.getText().equals("")) {
						try {
							LoadCoefficientBonus.bonuses.setLabBonus(textField_8.getText());
							SaveCoefficientBonus.saveCoefficientBonus();
							lblNewLabel_11.setText(textField_8.getText());
							textField_8.setText("");
							b = true;
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Bad input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}	
					}
					if (!textField_9.getText().equals("")) {
						try {
							LoadCoefficientBonus.bonuses.setTechBonus(textField_9.getText());
							SaveCoefficientBonus.saveCoefficientBonus();
							lblNewLabel_12.setText(textField_9.getText());
							textField_9.setText("");
							b = true;
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Bad input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
					}
					if(b){
						JOptionPane.showMessageDialog (null, "Changes applied!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "At least one field must be filled!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_7.setBounds(153, 167, 89, 23);
		panel_3.add(btnNewButton_7);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, "name_638231259869200");
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Current home visit price:");
		lblNewLabel_14.setBounds(84, 24, 168, 14);
		panel_5.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBounds(262, 24, 59, 14);
		panel_5.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Current home visit with time  price:");
		lblNewLabel_16.setBounds(33, 49, 219, 14);
		panel_5.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBounds(262, 49, 46, 14);
		panel_5.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New home visit price");
		lblNewLabel_18.setBounds(33, 106, 132, 14);
		panel_5.add(lblNewLabel_18);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_10.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_10.setBounds(32, 131, 133, 20);
		panel_5.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_18_1 = new JLabel("New home visit with time price");
		lblNewLabel_18_1.setBounds(224, 106, 202, 14);
		panel_5.add(lblNewLabel_18_1);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_11.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_11.setColumns(10);
		textField_11.setBounds(223, 131, 152, 20);
		panel_5.add(textField_11);
		
		JButton btnNewButton_8 = new JButton("Apply");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				if (!(textField_10.getText().equals("") && textField_11.getText().equals(""))) {
					if (!textField_10.getText().equals("")) {
						try {
							LoadHomeVisitPrices.homeVisitPrices.setDate(textField_10.getText());
							SaveHomeVisitPrices.saveHomeVisitPrices();
							lblNewLabel_15.setText(textField_10.getText());
							textField_10.setText("");
							b = true;
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Bad input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}	
					}
					if (!textField_11.getText().equals("")) {
						try {
							LoadHomeVisitPrices.homeVisitPrices.setDatetime(textField_11.getText());
							SaveHomeVisitPrices.saveHomeVisitPrices();
							lblNewLabel_17.setText(textField_11.getText());
							textField_11.setText("");
							b = true;
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Bad input!"
									+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
						}
					}
					if(b){
						JOptionPane.showMessageDialog (null, "Changes applied!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "At least one field must be filled!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_8.setBounds(152, 174, 89, 23);
		panel_5.add(btnNewButton_8);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, "name_638989490151000");
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 25, 715, 192);
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_7.add(scrollPane);
		scrollPane.setViewportView(incomeTable);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 243, 715, 229);
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_8.add(scrollPane_1);
		scrollPane_1.setViewportView(spendingTable);
		
		JLabel lblNewLabel_19 = new JLabel("Earnings");
		lblNewLabel_19.setBounds(10, 11, 92, 14);
		panel_6.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Spendings");
		lblNewLabel_20.setBounds(10, 228, 92, 14);
		panel_6.add(lblNewLabel_20);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9, "name_639229572325400");
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_9.add(scrollPane_2);
		scrollPane_2.setViewportView(patientsTable);
		
		
		JButton btnNewButton_3 = new JButton("Pay coefficient");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel_1, "name_636919499203300");
				lblNewLabel_7.setText(String.valueOf(LoadCoefficientBonus.coefficients.getLabCoefficient()));
				lblNewLabel_8.setText(String.valueOf(LoadCoefficientBonus.coefficients.getTechCoefficient()));		
			}
		});
		btnNewButton_3.setBounds(10, 55, 147, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Bonus");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_637876085401800");
				lblNewLabel_11.setText(String.valueOf(LoadCoefficientBonus.bonuses.getLabBonus()));
				lblNewLabel_12.setText(String.valueOf(LoadCoefficientBonus.bonuses.getTechBonus()));
			}
		});
		btnNewButton_4.setBounds(10, 89, 147, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Home visit price");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_638231259869200");
				lblNewLabel_15.setText(String.valueOf(LoadHomeVisitPrices.homeVisitPrices.getDate()));
				lblNewLabel_17.setText(String.valueOf(LoadHomeVisitPrices.homeVisitPrices.getDatetime()));
			}
		});
		btnNewButton_5.setBounds(10, 123, 147, 23);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Spendings/Earnings");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_638989490151000");
			}
		});
		btnNewButton_5_1.setBounds(10, 157, 147, 23);
		panel.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("Patients report");
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_639229572325400");
			}
		});
		btnNewButton_5_2.setBounds(10, 191, 147, 23);
		panel.add(btnNewButton_5_2);
		
		
		cl.show(panel_1, "name_636845049777000");
	}
}
