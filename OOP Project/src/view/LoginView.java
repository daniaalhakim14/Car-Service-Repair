// LOGINVIEW

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new LoginView().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LoginTitleLabel = new JLabel("4TAYA CAR REPAIR AND SERVICE");
		LoginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginTitleLabel.setFont(LoginTitleLabel.getFont().deriveFont(LoginTitleLabel.getFont().getStyle() | Font.BOLD, LoginTitleLabel.getFont().getSize() + 6f));
		LoginTitleLabel.setBounds(176, 38, 352, 37);
		contentPane.add(LoginTitleLabel);
		
		JLabel PasswordLabel = new JLabel("Password: ");
		PasswordLabel.setForeground(new Color(0, 0, 0));
		PasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(243, 260, 72, 29);
		contentPane.add(PasswordLabel);
		
		JLabel UsernameLabel = new JLabel("Username:");
		UsernameLabel.setForeground(new Color(0, 0, 0));
		UsernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		UsernameLabel.setBounds(243, 228, 72, 29);
		contentPane.add(UsernameLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(325, 233, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(325, 265, 86, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(248, 306, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSignUp.setBounds(354, 306, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Pictures\\OOP\\guy image.png"));
		lblNewLabel.setBounds(186, 13, 498, 429);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dhaki\\OneDrive - Universiti Teknikal Malaysia Melaka\\Pictures\\OOP\\4_tayar-removebg-preview.png"));
		lblNewLabel_1.setBounds(28, 44, 287, 398);
		contentPane.add(lblNewLabel_1);
	}
}
