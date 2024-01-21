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
	Connection conn = null;
	public StaffLoginGui() throws ClassNotFoundException, SQLException {
		conn = MyDatabase.doConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginTitleLabel = new JLabel("4TAYA CAR REPAIR AND SERVICE");
		LoginTitleLabel.setForeground(new Color(0, 0, 0));
		LoginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginTitleLabel.setFont(LoginTitleLabel.getFont().deriveFont(LoginTitleLabel.getFont().getStyle() | Font.BOLD, LoginTitleLabel.getFont().getSize() + 6f));
		LoginTitleLabel.setBounds(401, 95, 352, 37);
		contentPane.add(LoginTitleLabel);
		
		JLabel PasswordLabel = new JLabel("Password: ");
		PasswordLabel.setForeground(new Color(255, 255, 255));
		PasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(470, 317, 72, 29);
		contentPane.add(PasswordLabel);
		
		JLabel UsernameLabel = new JLabel("StaffId:");
		UsernameLabel.setForeground(new Color(255, 255, 255));
		UsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		UsernameLabel.setBounds(478, 285, 72, 29);
		contentPane.add(UsernameLabel);
		
		JTextField txtStaffId = new JTextField();
		txtStaffId.setBounds(550, 290, 86, 20);
		contentPane.add(txtStaffId);
		txtStaffId.setColumns(10);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(550, 322, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
							String sql = "SELECT StaffID FROM staff WHERE StaffID=? AND StaffPass=?";				  
						    PreparedStatement preparedStatement = conn.prepareStatement(sql);
							    
						    preparedStatement.setString(1, txtStaffId.getText());
						    preparedStatement.setString(2, txtPassword.getText());
							    
						    // Execute your query and process the result set if needed
						    ResultSet resultSet = preparedStatement.executeQuery();
							int count = 0 ;
							while(resultSet.next()){
								count = count + 1;
								}
							if(count == 1)
							{
								// when login button is press. it will go to staff Home page
								StaffHomepageGui frame = new StaffHomepageGui();
								frame.setVisible(true);
								dispose();
							}else if(count > 1)								{
								JOptionPane.showMessageDialog(null,"Duplicate StaffId and password ");
							}else
							{
								JOptionPane.showMessageDialog(null,"StaffId or password is incorrect");
							}
							   
								resultSet.close();
								preparedStatement.close();
		
					} catch (SQLException u) {
					    JOptionPane.showMessageDialog(null, e);
					} catch (Exception u) {
					    JOptionPane.showMessageDialog(null, e);
					}	
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(485, 363, 89, 23);
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
		btnBack.setBounds(590, 363, 89, 23);
		contentPane.add(btnBack);
	
			
		
		JLabel lblimagePerson = new JLabel("Login");
		lblimagePerson.setFont(new Font("Times New Roman", Font.BOLD, 15));
		// remove C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Documents\\GitHub\\Car-Service-and-Repair-System\\OOP Project\\
		// to run
		lblimagePerson.setIcon(new ImageIcon("C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Documents\\GitHub\\Car-Service-and-Repair-System\\OOP Project\\images\\guy.png"));
		lblimagePerson.setBounds(411, 70, 498, 429);
		contentPane.add(lblimagePerson);
		
		JLabel lblTayar = new JLabel("");
		// remove C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Documents\\GitHub\\Car-Service-and-Repair-System\\OOP Project\\
		// to run
		lblTayar.setIcon(new ImageIcon("C:\\\\Users\\\\dhaki\\\\OneDrive - Universiti Teknikal Malaysia Melaka\\\\Documents\\\\GitHub\\\\Car-Service-and-Repair-System\\\\OOP Project\\\\images\\\\4 tayars.png"));
		lblTayar.setBounds(253, 101, 287, 398);
		contentPane.add(lblTayar);
		
	
	
		
	}
}
