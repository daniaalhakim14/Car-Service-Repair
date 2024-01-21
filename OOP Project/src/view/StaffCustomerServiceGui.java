package view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.MyDatabase;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

	

public class StaffCustomerServiceGui extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	Connection conn = null;
	
	public StaffCustomerServiceGui() throws ClassNotFoundException, SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		conn = MyDatabase.doConnection();
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 119, 733, 316);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadTable = new JButton("Load Pending Jobs");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql ="Select * from car_service";
					PreparedStatement preparedStatement = conn.prepareStatement(sql);
					ResultSet result=preparedStatement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));
					
					
				}catch(Exception d) {
					d.printStackTrace();
				}
				
			}
		});
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLoadTable.setBounds(384, 446, 166, 23);
		getContentPane().add(btnLoadTable);
		
		JLabel lblNewLabel = new JLabel("Pending Jobs");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(398, 72, 137, 23);
		getContentPane().add(lblNewLabel);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffCustomerServiceGui frame = new StaffCustomerServiceGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
