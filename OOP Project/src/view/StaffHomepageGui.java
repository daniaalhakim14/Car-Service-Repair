package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StaffHomepageGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffHomepageGui frame = new StaffHomepageGui();
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
	public StaffHomepageGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(37, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffHomepageTitle = new JLabel("Staff Homepage");
		lblStaffHomepageTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblStaffHomepageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffHomepageTitle.setBackground(new Color(240, 240, 240));
		lblStaffHomepageTitle.setBounds(301, 11, 182, 51);
		contentPane.add(lblStaffHomepageTitle);
		
		JButton btnViewPendingJobs = new JButton("Pending Jobs");
		btnViewPendingJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StaffCustomerServiceGui frame = new StaffCustomerServiceGui();
					frame.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnViewPendingJobs.setBounds(328, 136, 129, 23);
		contentPane.add(btnViewPendingJobs);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 50, 764, 23);
		contentPane.add(separator);
	}
}
