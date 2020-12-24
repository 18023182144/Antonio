import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mom {
	private int x;
	private int y;

	private BufferedImage image;

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;

	private int timer1 = 0;

	public Mom() {
		try {

			this.image1 = ImageIO.read(new File("image\\素材\\野原美伢\\1.png"));
			this.image2 = ImageIO.read(new File("image\\素材\\野原美伢\\2.png"));
			this.image3 = ImageIO.read(new File("image\\素材\\野原美伢\\3.png"));
			this.image4 = ImageIO.read(new File("image\\素材\\野原美伢\\4.png"));
			this.image5 = ImageIO.read(new File("image\\素材\\野原美伢\\5.png"));
			this.image6 = ImageIO.read(new File("image\\素材\\野原美伢\\6.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = -5;
		y = 210;
	}

	public Bullet1 shoot(int i) {
		return new Bullet1(this.x, this.y + 60, i);
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
		return new Rectangle(x, y, image.getWidth() - 20, image.getHeight() - 20); // 恐龙头部区域
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
