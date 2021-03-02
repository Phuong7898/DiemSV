package MODEL;

import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;



public class Database {
	public static Connection getConnection() {
		 String server = "DESKTOP-5DIIRHA\\DINHPHUONG";
	        String user = "sa";
	        String password = "123456";
	        String db = "QL_DiemSV";
	        int port = 1433;
	        SQLServerDataSource ds = new SQLServerDataSource();
	        ds.setUser(user);
	        ds.setPassword(password);
	        ds.setDatabaseName(db);
	        ds.setServerName(server);
	        ds.setPortNumber(port);
	        Connection conn = null;
			try {
				conn = ds.getConnection();
			} catch (SQLServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          
	        return conn;
	}
	    
}
