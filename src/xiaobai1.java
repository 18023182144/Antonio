import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class xiaobai1 {
	private int x;
	private int y;
	private BufferedImage image; // ��ͼƬ

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;

	private int timer1 = 0;

	private boolean jumpState = false;// ��Ծ��״̬
	public static final int LOWEST_Y = 195; // �����ص�����
	private int jumpHeight = 100; // ��Ծ�ĸ߶�
	private int jumpValue = 0;// ��Ծ��������

	private boolean isRemove = false;
	private boolean isDead = false;

	public xiaobai1() {
		try {
			this.image1 = ImageIO.read(new File("image\\�ز�\\ҰԭС��\\1.png"));
			this.image2 = ImageIO.read(new File("image\\�ز�\\ҰԭС��\\2.png"));
			this.image3 = ImageIO.read(new File("image\\�ز�\\ҰԭС��\\3.png"));
			this.image4 = ImageIO.read(new File("image\\�ز�\\ҰԭС��\\4.png"));
			this.image5 = ImageIO.read(new File("image\\�ز�\\ҰԭС��\\5.png"));
			this.image6 = ImageIO.read(new File("image\\�ز�\\ҰԭС��\\6.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 30;
		y = LOWEST_Y;
	}

	public void jumpMove() {
	
		Stepping();

		// ��
		if (jumpState) {
			if (y >= LOWEST_Y) {
				jumpValue = -20;
			}
			if (y <= LOWEST_Y - jumpHeight) {
				jumpValue = 20;
			}
			y += jumpValue;

			if (y >= LOWEST_Y) {
				jumpState = false;
			}
		}
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

	public void jump() {
		this.jumpState = true;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth() - 20, image.getHeight() - 20); // ����ͷ������

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

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	public boolean isRemove() {
		return isRemove;
	}
}
