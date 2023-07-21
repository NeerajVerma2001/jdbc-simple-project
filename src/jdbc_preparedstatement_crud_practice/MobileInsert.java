package jdbc_preparedstatement_crud_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MobileInsert 
{
	public static void main(String[] args) 
	{
		Connection connection=null;
		try 
		{
			// step1- load the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2 established the connect
			String url = "jdbc:mysql://localhost:3307/jdbc_preparedstatement_practice";
			String user = "root";
			String pass ="root";
		    connection = DriverManager.getConnection(url, user, pass);
			
		    String insertQuery = "insert into mobile values(?,?,?,?)";
		    
			//step 3 create the statement
			PreparedStatement preparedStatement =  connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, 105);
			preparedStatement.setString(2, "BlackBerry");
			preparedStatement.setString(3, "grey sky");
			preparedStatement.setDouble(4, 100300);
			
			preparedStatement.execute();
			System.out.println("==============data stored===============");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				
			} catch (SQLException e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
