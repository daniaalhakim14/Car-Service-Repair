//USERCONTROLLER

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.MyDatabase;
import model.User;
import model.ClassNotFoundException;


public class UserController {
	
	public int insertUser(User user) throws java.lang.ClassNotFoundException, SQLException
	{
		String sql = "insert into user(f_Name,l_Name,Ic)values (?,?,?)";
		
		Connection conn = MyDatabase.doConnection();
		
		PreparedStatement preparedStatement =(PreparedStatement)conn.prepareStatement(sql);
		//preparedStatement.setString(1,user.getF_Name());
		//preparedStatement.setString(2,user.getL_Name());
		//preparedStatement.setString(3,user.getIc());
		
		int success = preparedStatement.executeUpdate();
		
		conn.close();
		
		return success;
	}
	
	public static void main(String[]args)
	{
		User abu = new User();
		abu.setF_Name("Abu");
		abu.setL_Name("Bakar");
		abu.setIc("021101160111");
		
		
		
		UserController userController = new UserController();
		int success;
	
			System.out.println("hello");
			try {
				success = userController.insertUser(abu);
			} catch (java.lang.ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Success: " + success);
		
		
	}

}
