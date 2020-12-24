import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server implements MyProtocal {
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public Server() throws IOException, SQLException, ClassNotFoundException {
		ServerSocket ss = new ServerSocket(12332);
		while (true) {
			s = ss.accept();
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			int command = ois.readInt();
			if (command == LOGIN) {
				login();
			} else if (command == REGISTER) {
				register();
			}
		}
	}

	public void login() throws IOException, ClassNotFoundException {
		String account = ois.readUTF();
		String password = ois.readUTF();
		boolean result = false;
		try {
			String sql = "select * from user where account='" + account + "' and password='" + password + "'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			if (rs.next())
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		oos.writeBoolean(result);
		oos.flush();
	}

	public void register() throws IOException, ClassNotFoundException {
		String account = ois.readUTF();
		String password = ois.readUTF();
		String msg = "注册成功";
		try {
			String sql = "insert into user(account,password) values('" + account + "','" + password + "')";
			DataConnection.getStat().executeUpdate(sql);
		} catch (Exception e) {
			msg = "用户已存在";
		}
		oos.writeUTF(msg);
		oos.flush();
	}

	public static void main(String[] args) {

		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
