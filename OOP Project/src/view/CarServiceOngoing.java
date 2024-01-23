package view;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import database.MyDatabase;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarServiceOngoing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    JComboBox<String> combo;
    JComboBox<String> combo1;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CarServiceOngoing frame = new CarServiceOngoing();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
     Connection conn=null;
   
    public CarServiceOngoing() throws ClassNotFoundException, SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 744, 501);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        getContentPane().setLayout(null);

        DefaultTableModel dm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                return (column == 8) ? Boolean.class : String.class;
            }
        };
       
        String[] header = { "ServiceID", "CustID", "CarModel", "CarName", "DateOfAppointment", "Description",
                "StaffID", "Status" };

        String sqlQuery = "SELECT ServiceID, CustID, CarModel, CarName, DateOfAppointment, Description, StaffID, Status FROM car_service Where Status = 'Ongoing'";

        try (
        		Connection conn = MyDatabase.doConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()){
        

            List<Object[]> resultList = new ArrayList<>();

            while (resultSet.next()) {
                String serviceID = resultSet.getString("ServiceID");
                String custID = resultSet.getString("CustID");
                String carModel = resultSet.getString("CarModel");
                String carName = resultSet.getString("CarName");
                String dateOfAppointment = resultSet.getString("DateOfAppointment");
                String description = resultSet.getString("Description");
                String staffID = resultSet.getString("StaffID");
                String status = resultSet.getString("Status");

                Object[] rowData = { serviceID, custID, carModel, carName, dateOfAppointment,
                        description, staffID, status, true };

                resultList.add(rowData);
            }

            Object[][] data = resultList.toArray(new Object[0][]);
            dm.setDataVector(data, header);

            JTable table = new JTable(dm);
            combo = new JComboBox<>();
          
            combo.addItem("Pending");
            combo.addItem("Ongoing");
            combo.addItem("Completed");
            combo.addItem("Cancelled");
            
            TableColumn col = table.getColumnModel().getColumn(7);
            col.setCellEditor(new DefaultCellEditor(combo));
           

            JScrollPane pane = new JScrollPane(table);
            pane.setBounds(51, 69, 625, 311);
            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            getContentPane().add(pane);
            
            JLabel lblNewLabel = new JLabel("Pending Repair And Service Jobs");
            lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setBounds(229, 30, 269, 28);
            contentPane.add(lblNewLabel);
            
            JButton btnUpdate = new JButton("Update\r\n");
            btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
            btnUpdate.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int rowCount = model.getRowCount();

            		   // Iterate through each row
            	        for (int i = 0; i < rowCount; i++) {
            	            // Check if the status column (index 7) has been modified
            	            String newStatus = (String) model.getValueAt(i, 7);
            	 

            	            if (!newStatus.equals("Ongoing")) {  // Only update if status is not "Pending"
            	                // If the status is different from "Pending", update the corresponding row in the database
            	                String serviceID = (String) model.getValueAt(i, 0);
            	      
            	
            	                
            	                try {
            	                    updateStatusInDatabase(serviceID, newStatus);
            	                } catch (ClassNotFoundException e1) {
            	                    e1.printStackTrace();
            	                }
            	            } 
            	       
            	        }
                       // Refresh the table after updating the database
                       //refreshTable();

            	}
            });
            btnUpdate.setBounds(241, 391, 103, 37);
            contentPane.add(btnUpdate);
            
            JButton btnBack = new JButton("Back\r\n");
            btnBack.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            			StaffHomepageGui frame = new StaffHomepageGui();
						frame.setVisible(true);
						dispose();
            	}
            });
            btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
            btnBack.setBounds(381, 391, 103, 37);
            contentPane.add(btnBack);
            setVisible(true);
     
        }
    }
    private void updateStatusInDatabase(String serviceID, String newStatus) throws ClassNotFoundException {
    	String updateQuery = "UPDATE car_service SET Status = ? WHERE ServiceID = ?";


        try (Connection conn = MyDatabase.doConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, serviceID);
 

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
               JOptionPane.showMessageDialog(null,"Status updated successfully for ServiceID: " + serviceID);
            } else {
                JOptionPane.showMessageDialog(null,"Failed to update status for ServiceID: " + serviceID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

