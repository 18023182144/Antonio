
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements MyProtocal {
	ObjectOutputStream oos;
	ObjectInputStream ois;

	public Client() throws UnknownHostException, IOException {
		Socket s = new Socket("10.51.159.82", 12332);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}

	public boolean login(String account, String password) throws IOException {
		oos.writeInt(LOGIN);
		oos.flush();
		oos.writeUTF(account);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		boolean result = ois.readBoolean();
		return result;
	}

	public String register(String account, String password) throws IOException {
		oos.writeInt(REGISTER);
		oos.flush();
		oos.writeUTF(account);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		String result = ois.readUTF();
		return result;
	}
}
