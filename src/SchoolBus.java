import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SchoolBus {
	private int x; // У������
	private int y;

	private BufferedImage image; // ��ͼƬ

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage image8;

	private int timer = 0;

	public SchoolBus() {
		try {

			this.image1 = ImageIO.read(new File("image\\�ز�\\У��\\У��1.png"));
			this.image2 = ImageIO.read(new File("image\\�ز�\\У��\\У��2.png"));
			this.image3 = ImageIO.read(new File("image\\�ز�\\У��\\У��3.png"));
			this.image4 = ImageIO.read(new File("image\\�ز�\\У��\\У��4.png"));
			this.image5 = ImageIO.read(new File("image\\�ز�\\У��\\У��5.png"));
			this.image6 = ImageIO.read(new File("image\\�ز�\\У��\\У��6.png"));
			this.image7 = ImageIO.read(new File("image\\�ز�\\У��\\У��7.png"));
			this.image8 = ImageIO.read(new File("image\\�ز�\\У��\\У��8.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 610;
		y = 100;
	}

	public void jumpMove() {
		// �ܲ�
		Stepping();

	}

	public void Stepping() {
		int temp = timer++ % 8;
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
		if (temp == 6) {
			image = image7;
		}
		if (temp == 7) {
			image = image8;
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
