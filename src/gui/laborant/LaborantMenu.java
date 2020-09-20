package gui.laborant;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.CurrentUser;
import entities.Report;
import entities.users.Laborant;
import entities.users.User;
import gui.login.Login;
import services.loadsave.reports.LoadReports;
import services.loadsave.reports.SaveReports;
import services.loadsave.users.LoadUsers;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class LaborantMenu extends JFrame {

	private static final long serialVersionUID = 3990096224942161593L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaborantMenu frame = new LaborantMenu(args);
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
	public LaborantMenu(String[] args) {
		CardLayout cl = new CardLayout(0, 0);
		DefaultComboBoxModel<Report> def = new DefaultComboBoxModel<Report>();
		ArrayList<Report> rl = LoadReports.getLaborantReports();
		for (Report r : rl) {
			def.addElement(r);
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 178, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					Login.main(args);
					CurrentUser.currentUser = null;
					dispose();
				}
			}
		});
		btnNewButton.setBounds(42, 438, 89, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(188, 0, 673, 483);
		contentPane.add(panel_1);
		panel_1.setLayout(cl);
		
		JButton btnNewButton_1 = new JButton("Analyize samples");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel_1, "name_842468393530900");
			}
		});
		btnNewButton_1.setBounds(11, 56, 158, 23);
		panel.add(btnNewButton_1);
			
		JPanel blank = new JPanel();
		panel_1.add(blank, "name_842457903267900");
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_842468393530900");
		panel_3.setLayout(null);
		
		JComboBox<Report> comboBox = new JComboBox<Report>();
		comboBox.setModel(def);
		comboBox.setBounds(61, 55, 175, 20);
		panel_3.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(280, 55, 100, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != -1) {
					if (!textField.getText().equals("")) {
						if (textField.getText().split(",").length == ((Report) comboBox.getSelectedItem()).getAnalysis().length) {
							try {
								((Report) comboBox.getSelectedItem()).setResults(textField.getText().split(","));
								SaveReports.saveReports();
								def.removeElementAt(comboBox.getSelectedIndex());
								for (User u : LoadUsers.usersList) {
									if (u.getUsername().equals(CurrentUser.currentUser)) {
										Laborant l = (Laborant) u;
										l.addAnalysis(textField.getText().split(",").length);
									}
								}
								JOptionPane.showMessageDialog (null, "Results were saved!", "Success!", JOptionPane.INFORMATION_MESSAGE);
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Bad input!"
										+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "This can't be empty!"
								+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Select analysis!"
							+ " Please try again.","", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(285, 99, 89, 23);
		panel_3.add(btnNewButton_2);
		setLocationRelativeTo(null);
		setTitle("Labi Lab");
		
		
		cl.show(panel_1, "name_842457903267900");
	}
}
