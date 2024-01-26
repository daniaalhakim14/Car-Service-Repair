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

import controller.StaffController;
import database.MyDatabase;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarServiceCompleted extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    JComboBox<String> combo;
    JComboBox<String> combo1;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CarServiceCompleted frame = new CarServiceCompleted();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
     Connection conn=null;
   
     public void refreshTable() throws ClassNotFoundException, SQLException
     {
    	    DefaultTableModel dm = new DefaultTableModel() {
    	        @Override
    	        public Class<?> getColumnClass(int column) {
    	            return (column == 8) ? Boolean.class : String.class;
    	        }
    	    };

    	    String[] header = { "ServiceID", "CustID", "CarModel", "CarName", "DateOfAppointment", "Description",
    	            "StaffID", "Status" };

    	    String sqlQuery = "SELECT ServiceID, CustID, CarModel, CarName, DateOfAppointment, Description, StaffID, Status FROM car_service WHERE Status = 'Completed'";

    	    try (Connection conn = MyDatabase.doConnection();
    	         PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
    	         ResultSet resultSet = preparedStatement.executeQuery()) {

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

    	        // Get the existing JTable from the content pane
    	        JTable table = (JTable) ((JScrollPane) getContentPane().getComponent(0)).getViewport().getView();

    	        // Update the existing JTable with the new model
    	        table.setModel(dm);
    	    } catch (Exception ex) {
    	        ex.printStackTrace();
    	    }
     }
    public CarServiceCompleted() throws ClassNotFoundException, SQLException {
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

        String sqlQuery = "SELECT ServiceID, CustID, CarModel, CarName, DateOfAppointment, Description, StaffID, Status FROM car_service Where Status = 'COMPLETED'";

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
            		StaffController staffController = new StaffController();
            		staffController.updateTableComplete(model);
            		try {
						refreshTable();
				
					} catch (ClassNotFoundException | SQLException e1) {

						e1.printStackTrace();
					}

            	}
            });
            btnUpdate.setBounds(381, 391, 103, 37);
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
            btnBack.setBounds(241, 391, 103, 37);
            contentPane.add(btnBack);
            setVisible(true);
     
        }
    }
    
}

