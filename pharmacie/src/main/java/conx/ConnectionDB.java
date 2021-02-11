package conx;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class ConnectionDB {

	
		
	    public static Connection connect() throws SQLException {
	    	 Connection conn = null;
	    	try {
	            Class.forName("org.postgresql.Driver");
	            System.out.println("Driver O.K.");
	        
	            String url = "jdbc:postgresql://localhost:5432/WebAppPharmacy";
	            String user = "postgres";
	            String passwd = "123456789";
	        
	            conn = DriverManager.getConnection(url, user, passwd);
	            System.out.println("connected successfully !");        
	                 
	          } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(" Nooooooooooo connected successfully!");        

	          }
	    	return conn;
		          
		    }

		    
		    
		}


