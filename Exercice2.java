package exercice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercice2 {
	
	private String url="jdbc:mysql://localhost:3306/user";
	private String user="root";
    private String password="cissepape";
    String query1="INSERT INTO utilisateur (nom,prenom) VALUES (?,?);";
    String query2="INSERT INTO utilisateur (nom,prenom) VALUES (?,?);";
    Connection connection = null;
    
    public void question1()  {
    	try {
    	connection=DriverManager.getConnection(url, user, password);	
    	connection.setAutoCommit(false);
    	
    	PreparedStatement stm=null;
    	stm=connection.prepareStatement(query1);
    	stm.setString(1, "dieye");
    	stm.setString(2, "pape");
    	stm.executeUpdate();
    	
    	stm=connection.prepareStatement(query2);
    	stm.setString(1, "faye");
    	stm.setString(2, "waly");
    	stm.executeUpdate();
    	
    	connection.commit();
        System.out.println("Transaction committed successfully.");
        }
        catch(SQLException e) {
        	System.out.println(e.getMessage());	
        }
    	  	
}
    public void question2() {
    	try {
        	connection=DriverManager.getConnection(url, user, password);	
        	connection.setAutoCommit(false);
        	String query3="INSERT (nom,prenom) VALUES (?,?);";//for triggering an exception
        	PreparedStatement stm=null;
        	stm=connection.prepareStatement(query1);
        	stm.setString(1, "dieye");
        	stm.setString(2, "pape");
        	stm.executeUpdate();
        	
        	stm=connection.prepareStatement(query3);
        	stm.setString(1, "faye");
        	stm.setString(2, "waly");
        	stm.executeUpdate();
        	
        	connection.commit();
            System.out.println("Transaction committed successfully.");
            }
            catch(SQLException e) {
            	System.out.println(e.getMessage());	
            }
        	  	
    }    	  	
	

}