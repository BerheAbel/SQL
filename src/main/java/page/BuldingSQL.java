package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuldingSQL {
	String columnValue;
	ResultSet rs = null;
	Connection connection = null;
	Statement statment = null;
	public String getDBdata(String columnName) throws SQLException {
		try {
			//setting properties for mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/techfios";
			String username = "root";
			String password = "root";
			String query = "select * from Abel";
			//Create connection to local database
			connection = DriverManager.getConnection(sqlUrl, username, password);
			//empworing connection to execute enqury
			statment = connection.createStatement();
			//Delivering enqury
			rs = statment.executeQuery(query);
			while(rs.next()) {
				columnValue = rs.getString(columnName);
				return columnName;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs !=null) {
				rs.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		return columnName;
		
	}
}
