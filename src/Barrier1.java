import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Barrier1 {
	private int x;
	private int y;

	private BufferedImage image;// Ö÷Í¼

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;

	private int speed = Background1.SPEED1;

	private int timer1 = 0; // ¼ÆÊ±Æ÷1

	private int flag = 0;

	public Barrier1() {
		try {
			image1 = ImageIO.read(new File("image1/cactus01.png"));
			image2 = ImageIO.read(new File("image1/cactus02.png"));
			image3 = ImageIO.read(new File("image1/cactus03.png"));
			image4 = ImageIO.read(new File("image1/bird1.png"));
			image5 = ImageIO.read(new File("image1/bird2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 730;
		y = 209;

		image = image1;
		flag = 1;

		int temp = new Random().nextInt(5);
		if (temp == 0) {
			image = image1;
			flag = 1;
		}
		if (temp == 1) {
			image = image2;
			flag = 2;
		}
		if (temp == 2) {
			image = image3;
			flag = 3;
		}
		if (temp == 3) {
			image = image4;
			flag = 4;
			y = 150;
		}
		if (temp == 5) {
			image = image5;
			flag = 5;
			y = 200;
		}

	}

	public void cactusMove() {
		x -= (speed + 10);
	}

	public void move1() {
		int temp = timer1++ % 2;
		if (temp == 0) {
			image1 = image4;
		}
		if (temp == 1) {
			image1 = image5;
		}
	}

	public void move2() {
		int temp = timer1++ % 2;
		if (temp == 0) {
			image1 = image4;
		}
		if (temp == 1) {
			image1 = image5;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getImage().getWidth(), getImage().getHeight());
	}

	public boolean acrossBorder() {
		return this.x <= -100;
	}

	public BufferedImage getImage() {
		if (flag == 1) {
			image = image1;
		}
		if (flag == 2) {
			image = image2;
		}
		if (flag == 3) {
			image = image3;
		}
		if (flag == 4) {
			image = image4;
		}
		if (flag == 5) {
			image = image5;
		}
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getFlag() {
		return flag;
	}
}
