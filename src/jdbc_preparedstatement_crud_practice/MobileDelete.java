package jdbc_preparedstatement_crud_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MobileDelete 
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2
			String url = "jdbc:mysql://localhost:3307/jdbc_preparedstatement_practice";
			String  user = "root";
			String pass ="root";
			connection=DriverManager.getConnection(url, user, pass);
			
			
			//step 3 statement
			String deleteQuery="delete from mobile where id=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1,102);
			int a=preparedStatement.executeUpdate();
			if(a==1)
			{
				System.out.println("data is deleted");
			}
			else 
			{
				System.out.println("given data is not present");
			}
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
