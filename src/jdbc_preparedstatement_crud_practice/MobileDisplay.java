package jdbc_preparedstatement_crud_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MobileDisplay 
{
	public static void main(String[] args) 
	{
		Connection connection=null;
		//load the driver
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2
			String url = "jdbc:mysql://localhost:3307/jdbc_preparedstatement_practice";
			String  user = "root";
			String pass ="root";
			connection=DriverManager.getConnection(url, user, pass);
			
			// step-3 create statement
			Statement statement = connection.createStatement();
			
			// step-4 executeQuery
			
			String displayQuery = "select * from mobile";
			PreparedStatement preparedStatement=connection.prepareStatement(displayQuery);
			

			ResultSet resultSet = statement.executeQuery(displayQuery);
			while(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String name =resultSet.getString("name");
				String color = resultSet.getString("color");
				Double price= resultSet.getDouble("price");
				System.out.println("========================================================");
				
				System.out.println("id="+id);
				System.out.println("name="+name);
				System.out.println("color="+color);
				System.out.println("price="+price);
				System.out.println("========================================================");
				
			}

		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
