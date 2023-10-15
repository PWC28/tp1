package exercice3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercice3 {
	private String url="jdbc:mysql://localhost:3306/user";
	private String user="root";
    private String password="cissepape";
    Connection connection=null;
	public int question1(String table) {
		int total = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + table; 
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet res = stm.executeQuery();
            if(res.next()) {
            total = res.getInt(1); 
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return total;
	}
}	
