package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginController;
import controller.StaffController;
import database.MyDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.MyDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StaffLoginGui extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLoginGui frame = new StaffLoginGui();
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
	
	public StaffLoginGui() throws ClassNotFoundException, SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 744, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginTitleLabel = new JLabel("4TAYA CAR REPAIR AND SERVICE");
		LoginTitleLabel.setOpaque(true);
		LoginTitleLabel.setForeground(new Color(0, 0, 0));
		LoginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginTitleLabel.setFont(LoginTitleLabel.getFont().deriveFont(LoginTitleLabel.getFont().getStyle() | Font.BOLD, LoginTitleLabel.getFont().getSize() + 6f));
		LoginTitleLabel.setBounds(188, 39, 352, 37);
		contentPane.add(LoginTitleLabel);
		
		JLabel PasswordLabel = new JLabel("Password: ");
		PasswordLabel.setForeground(new Color(255, 255, 255));
		PasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(241, 236, 72, 29);
		contentPane.add(PasswordLabel);
		
		JLabel UsernameLabel = new JLabel("StaffId:");
		UsernameLabel.setForeground(new Color(255, 255, 255));
		UsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		UsernameLabel.setBounds(252, 204, 72, 29);
		contentPane.add(UsernameLabel);
		
		JTextField txtStaffId = new JTextField();
		txtStaffId.setBounds(323, 209, 86, 20);
		contentPane.add(txtStaffId);
		txtStaffId.setColumns(10);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(323, 241, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String staffID = txtStaffId.getText();
				String staffPassword = txtPassword.getText();
        		LoginController loginController = new LoginController();
        		loginController.staffLogin(staffID, staffPassword);
			
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(363, 282, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui frame;
				try {
					frame = new LoginGui();
					frame.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(258, 282, 89, 23);
		contentPane.add(btnBack);
	
			
		
		JLabel lblimagePerson = new JLabel("Login");
		lblimagePerson.setFont(new Font("Times New Roman", Font.BOLD, 15));
		// remove C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Documents\\GitHub\\Car-Service-and-Repair-System\\OOP Project\\
		// to run
		lblimagePerson.setIcon(new ImageIcon("C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Documents\\GitHub\\Car-Service-and-Repair-System\\OOP Project\\images\\guy.png"));
		lblimagePerson.setBounds(168, 11, 498, 429);
		contentPane.add(lblimagePerson);
		
		JLabel lblTayar = new JLabel("");
		// remove C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Documents\\GitHub\\Car-Service-and-Repair-System\\OOP Project\\
		// to run
		lblTayar.setIcon(new ImageIcon("C:\\\\Users\\\\dhaki\\\\OneDrive - Universiti Teknikal Malaysia Melaka\\\\Documents\\\\GitHub\\\\Car-Service-and-Repair-System\\\\OOP Project\\\\images\\\\4 tayars.png"));
		lblTayar.setBounds(10, 42, 287, 398);
		contentPane.add(lblTayar);

		
	}
	
}
