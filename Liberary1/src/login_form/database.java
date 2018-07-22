package login_form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

	public static Connection getConnection() throws SQLException {
		 Connection con=null;
	     try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","94312");
	         return con;
	     } catch (ClassNotFoundException ex) {
	         Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
	         return null;
	     }
		
	}

}
