
import java.sql.*;

public class DataConnection {

	private static Statement stat;

	public static Statement getStat() throws ClassNotFoundException, SQLException {
		if (stat == null)
			init();
		return stat;
	}

	private static void init() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/antonio";
		String name = "root";
		String pw = "0000";
		Connection con = DriverManager.getConnection(url, name, pw);
		stat = con.createStatement();
	}

}
