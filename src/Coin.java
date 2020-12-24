import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Coin {
	private int x;
	private int y;

	private BufferedImage image;// ��ͼ

	private BufferedImage image1;
	private BufferedImage enemy1;

	private int speed = Background.SPEED1;

	private int flag = 1;

	private boolean isRemove = false;
	private boolean isDead = false;

	public Coin() {
		try {
			enemy1 = ImageIO.read(new File("image\\�ز�\\���.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 983;
		y = 285;

		// Ĭ��
		image = image1;

		image1 = enemy1;

	}

	// ����
	public void cactusMove() {
		x -= (speed + 10);
	}

	public void move1() {

		if (isRemove) {
			this.y += 20;
			image1 = enemy1;
			isDead = true;
		}

	}

	// ��ȡ��������
	public Rectangle getBounds() {
		return new Rectangle(x, y, getImage().getWidth(), getImage().getHeight());
	}

	// Խ���Ƴ��ж�
	public boolean acrossBorder() {
		return this.x <= -100;
	}

	public BufferedImage getImage() {
		if (flag == 1) {
			image = image1;
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

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	public boolean isRemove() {
		return isRemove;
	}

	public boolean isDead() {
		return isDead;
	}

}
