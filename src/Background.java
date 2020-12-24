import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	private BufferedImage image1;
	private BufferedImage image2;

	private BufferedImage image_over;
	private BufferedImage image_start;
	private BufferedImage image_pause;
	private BufferedImage image_win;

	private int x1;
	private int x2;
	private int y;

	public static final int SPEED1 = 20;

	public Background() {
		try {

			image1 = ImageIO.read(new File("image\\匼第\\華芞11.jpg"));
			image2 = ImageIO.read(new File("image\\匼第\\華芞12.jpg"));

			image_start = ImageIO.read(new File("image\\羲宎蚔牁偌聽.png"));
			image_pause = ImageIO.read(new File("image\\pause.png"));
			image_win = ImageIO.read(new File("image\\匼第\\蔣戚.png"));
			image_over = ImageIO.read(new File("image\\匼第\\GAMEOVER.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		x1 = 0;
		x2 = 980;
		y = 0;

	}

	public void roll() {
		x1 -= SPEED1;
		x2 -= SPEED1;
		if (x1 <= -980) {
			x1 = 980;
		}
		if (x2 <= -980) {
			x2 = 980;
		}
	}

	public BufferedImage getImage1() {
		return image1;
	}

	public BufferedImage getImage2() {
		return image2;
	}

	public BufferedImage getImage_over() {
		return image_over;
	}

	public BufferedImage getImage_pause() {
		return image_pause;
	}

	public BufferedImage getImage_start() {
		return image_start;
	}

	public BufferedImage getImage_win() {
		return image_win;
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
