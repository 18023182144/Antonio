import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Background1 {

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image_over;

	private int x1; // 两个图片的坐标
	private int x2;
	private int y;

	public static final int SPEED1 = 20;// 背景滚动速度

	public Background1() {
		try {
			image1 = ImageIO.read(new File("image1/map.png"));
			image2 = ImageIO.read(new File("image1/map1.png"));

			image_over = ImageIO.read(new File("image\\素材\\GAMEOVER.png"));

		} catch (IOException e) {

			e.printStackTrace();
		}
		x1 = 0;
		x2 = 734;
		y = 0;
	}

	public void roll() {
		x1 -= SPEED1;
		x2 -= SPEED1;
		if (x1 <= -734) {
			x1 = 734;
		}
		if (x2 <= -734) {
			x2 = 734;
		}
	}

	public BufferedImage getImage1() {
		return image1;
	}

	public BufferedImage getImage2() {
		return image2;
	}

	public void setImage1(BufferedImage image1) {
		this.image1 = image1;
	}

	public void setImage2(BufferedImage image2) {
		this.image2 = image2;
	}

	public BufferedImage getImage_over() {
		return image_over;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY() {
		return y;
	}
}