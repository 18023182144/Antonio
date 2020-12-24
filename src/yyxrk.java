import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class yyxrk {
	private int x;
	private int y;

	private BufferedImage image; // 主图片
	
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;

	private int timer = 0;

	public yyxrk() {
		try {

			this.image1 = ImageIO.read(new File("image\\素材\\野原向日葵\\1.png"));
			this.image2 = ImageIO.read(new File("image\\素材\\野原向日葵\\2.png"));
			this.image3 = ImageIO.read(new File("image\\素材\\野原向日葵\\3.png"));
			this.image4 = ImageIO.read(new File("image\\素材\\野原向日葵\\4.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 800;
		y = 290;
	}

	public void jumpMove() {
		// 跑步
		Stepping();

	}

	public void Stepping() {
		int temp = timer++ % 4;
		if (temp == 0) {
			image = image1;
		}
		if (temp == 1) {
			image = image2;
		}
		if (temp == 2) {
			image = image3;
		}
		if (temp == 3) {
			image = image4;
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
