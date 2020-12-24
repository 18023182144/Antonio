import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static final File file1 = new File("properties" + File.separator + "score.txt");

	public static synchronized void write(int score) {
		Properties properties = new Properties();
		properties.setProperty("score", String.valueOf(score));
		try {
			properties.store(new FileOutputStream(file1), "Score Info");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized int readScore() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(file1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(properties.getProperty("score"));

	}

}
