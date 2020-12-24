import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class fjc {
	private int x; // 风间彻坐标
	private int y;

	private BufferedImage image; // 主图片
	// 奔跑
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;

	private int timer = 0;

	public fjc() {
		try {

			this.image1 = ImageIO.read(new File("image\\素材\\风间彻\\1.png"));
			this.image2 = ImageIO.read(new File("image\\素材\\风间彻\\2.png"));
			this.image3 = ImageIO.read(new File("image\\素材\\风间彻\\3.png"));
			this.image4 = ImageIO.read(new File("image\\素材\\风间彻\\4.png"));
			this.image5 = ImageIO.read(new File("image\\素材\\风间彻\\5.png"));
			this.image6 = ImageIO.read(new File("image\\素材\\风间彻\\6.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 810;
		y = 240;
	}

	public void jumpMove() {
		// 跑步
		Stepping();

	}

	public void Stepping() {
		int temp = timer++ % 6;
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
		if (temp == 4) {
			image = image5;
		}
		if (temp == 5) {
			image = image6;
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
