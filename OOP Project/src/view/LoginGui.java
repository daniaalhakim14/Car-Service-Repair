// LOGINVIEW

package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.MyDatabase;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Color;


public class LoginGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new LoginGui().setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public LoginGui() {
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
		PasswordLabel.setBounds(468, 317, 72, 29);
		contentPane.add(PasswordLabel);
		
		JLabel UsernameLabel = new JLabel("Email:");
		UsernameLabel.setForeground(new Color(255, 255, 255));
		UsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		UsernameLabel.setBounds(479, 285, 72, 29);
		contentPane.add(UsernameLabel);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(550, 290, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(550, 322, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
						String sql = "SELECT StaffID FROM staff WHERE StaffID=? AND StaffPass=?";
						Connection conn = MyDatabase.doConnection();
					  
					    PreparedStatement preparedStatement = conn.prepareStatement(sql);
					    
					    preparedStatement.setString(1, txtEmail.getText());
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
						}else if(count > 1)
						{
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
				
				
		btnLogin.setBounds(473, 363, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSignUp.setBounds(579, 363, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblimagePerson = new JLabel("");
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
