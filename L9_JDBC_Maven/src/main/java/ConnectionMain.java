import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMain {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Reflection api to load the  class at runtime
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");
			System.out.println("Database conn success:"+con);
			String query ="CREATE Database IF NOT EXISTS jbdl60";
			Statement stmt=con.createStatement();
			stmt.execute(query);
			System.out.println("Database schema creation success");
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
