package org.sqlsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleSQL {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.Local the driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. Connect to the DataBase
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "test1234");
		
		//3. Write the sql  query
		
		String s = "select * from employees";
		
		//4. Prepare the statement
		
		PreparedStatement statement = connection.prepareStatement(s);
		
		//5.Execute the query
		
		ResultSet rs = statement.executeQuery();
		
		//6. Iterate the result
		
		while (rs.next()) {
			
			String string = rs.getString("First_name");
			String string2 = rs.getString("Last_name");
			
			System.out.println(string+string2);
			System.out.println("This is master copy");
			System.out.println("This is edited by anand");
			System.out.println("This is edited by Master second time");
			System.out.println("This is edited by anand second time locally");
			System.out.println("Third");
			
			
		}
		
		connection.close();
		
	}
	
}
