package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
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
import java.awt.Scrollbar;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.List;
import java.awt.Choice;

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
	     setBounds(100, 100, 744, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(37, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffHomepageTitle = new JLabel("Staff Homepage");
		lblStaffHomepageTitle.setOpaque(true);
		lblStaffHomepageTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblStaffHomepageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffHomepageTitle.setBackground(new Color(240, 240, 240));
		lblStaffHomepageTitle.setBounds(273, 19, 182, 23);
		contentPane.add(lblStaffHomepageTitle);
		
		JButton btnViewPendingJobs = new JButton("Pending Jobs");
		btnViewPendingJobs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewPendingJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CarServicePending frame = new CarServicePending();
					frame.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnViewPendingJobs.setBounds(278, 148, 172, 23);
		contentPane.add(btnViewPendingJobs);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(-12, 53, 764, 23);
		contentPane.add(separator);
		
		JButton btnOngoingJobs = new JButton("Ongoing Jobs");
		btnOngoingJobs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnOngoingJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					CarServiceOngoing frame = new CarServiceOngoing();
					frame.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnOngoingJobs.setBounds(277, 194, 173, 23);
		contentPane.add(btnOngoingJobs);
		
		JButton btnViewCompletedJob = new JButton("Completed Jobs");
		btnViewCompletedJob.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewCompletedJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CarServiceCompleted frame = new CarServiceCompleted();
					frame.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnViewCompletedJob.setBounds(279, 240, 170, 23);
		contentPane.add(btnViewCompletedJob);
		
		JButton btnCustomerInvoice = new JButton("Customer Invoice");
		btnCustomerInvoice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCustomerInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Invoice frame = new Invoice();
					frame.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCustomerInvoice.setBounds(279, 332, 170, 23);
		contentPane.add(btnCustomerInvoice);
		
		JButton btnViewCancelledJobs = new JButton("Cancelled Jobs");
		btnViewCancelledJobs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewCancelledJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewCancelledJobs.setBounds(279, 286, 170, 23);
		contentPane.add(btnViewCancelledJobs);
		
		
		
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
	
	
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
