import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ytnn {
	private int x;
	private int y;

	private BufferedImage image; // Ö÷Í¼Æ¬
	// ±¼ÅÜ
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;

	private int timer1 = 0;

	public ytnn() {
		try {

			this.image1 = ImageIO.read(new File("image\\ËØ²Ä\\Ó£ÌïÄİÄİ\\1.png"));
			this.image2 = ImageIO.read(new File("image\\ËØ²Ä\\Ó£ÌïÄİÄİ\\2.png"));
			this.image3 = ImageIO.read(new File("image\\ËØ²Ä\\Ó£ÌïÄİÄİ\\3.png"));
			this.image4 = ImageIO.read(new File("image\\ËØ²Ä\\Ó£ÌïÄİÄİ\\4.png"));
			this.image5 = ImageIO.read(new File("image\\ËØ²Ä\\Ó£ÌïÄİÄİ\\5.png"));
			this.image6 = ImageIO.read(new File("image\\ËØ²Ä\\Ó£ÌïÄİÄİ\\6.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = -10;
		y = 250;
	}

	public void jumpMove() {

		Stepping();

	}

	public void Stepping() {
			int temp = timer1++ % 6;
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

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth() - 20, image.getHeight() - 20); // ¿ÖÁúÍ·²¿ÇøÓò

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
