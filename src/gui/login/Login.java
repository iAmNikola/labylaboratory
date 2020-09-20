package gui.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import entities.CurrentUser;
import entities.users.*;
import gui.admin.AdminMenu;
import gui.laborant.LaborantMenu;
import gui.patient.PatientMenu;
import gui.technician.TechnicianMenu;
import services.loadsave.users.LoadUsers;


public class Login extends JFrame {

	private static final long serialVersionUID = -3145612941119686793L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(args);
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
	public Login(String[] args) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setTitle("Log in");
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(203, 11, 77, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\"Labi\" Laboratory");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(167, 35, 166, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Userame:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(102, 84, 64, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(102, 125, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(178, 84, 168, 20);
		contentPane.add(textField);
		
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(textField_1.getText().length()>=20&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(177, 122, 169, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener()  { 
			public void actionPerformed(ActionEvent arg0) {
				boolean b = false;
				for (User u : LoadUsers.usersList) {
					if (u.getUsername().equals(textField.getText()) && u.getPassword().equals(textField_1.getText())) {
						b = true;
						if (u instanceof Admin) {
							AdminMenu.main(args);
						} else if (u instanceof Technician) {
							TechnicianMenu.main(args);
						} else if (u instanceof Laborant) {
							LaborantMenu.main(args);
						} else if (u instanceof Patient) {
							PatientMenu.main(args);
						}
						CurrentUser.currentUser = textField.getText();
						if (b) {
							dispose();
							break;
						}
					}
				}
				if(!b) {
					JOptionPane.showMessageDialog(null, "The username and password you input don't associate with any account."
														+ " Please try again.","Access denied!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(191, 162, 89, 23);
		contentPane.add(btnNewButton);
	}

}
