import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dad {
	private int x; // 小新坐标
	private int y;

	private BufferedImage image; // 主图片
	// 变身之前奔跑的图
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;

	// 技能
	private BufferedImage image30;
	private BufferedImage image31;
	private BufferedImage image32;
	private BufferedImage image33;
	private BufferedImage image34;
	private BufferedImage image35;
	private BufferedImage image36;
	private BufferedImage image37;
	private BufferedImage image38;
	private BufferedImage image39;

	private int timer1 = 0;
	private int timer_skill1 = 0;// 技能1计时器
	private boolean skill1State1 = false;// 放技能1的标志

	public Dad() {
		try {

			this.image1 = ImageIO.read(new File("image\\素材\\野原广志\\1.png"));
			this.image2 = ImageIO.read(new File("image\\素材\\野原广志\\2.png"));
			this.image3 = ImageIO.read(new File("image\\素材\\野原广志\\3.png"));
			this.image4 = ImageIO.read(new File("image\\素材\\野原广志\\4.png"));
			this.image5 = ImageIO.read(new File("image\\素材\\野原广志\\5.png"));
			this.image6 = ImageIO.read(new File("image\\素材\\野原广志\\6.png"));

			this.image30 = ImageIO.read(new File("image\\素材\\野原广志\\a1.png"));
			this.image31 = ImageIO.read(new File("image\\素材\\野原广志\\a2.png"));
			this.image32 = ImageIO.read(new File("image\\素材\\野原广志\\a3.png"));
			this.image33 = ImageIO.read(new File("image\\素材\\野原广志\\a4.png"));
			this.image34 = ImageIO.read(new File("image\\素材\\野原广志\\a5.png"));
			this.image35 = ImageIO.read(new File("image\\素材\\野原广志\\a6.png"));
			this.image36 = ImageIO.read(new File("image\\素材\\野原广志\\a7.png"));
			this.image37 = ImageIO.read(new File("image\\素材\\野原广志\\a8.png"));
			this.image38 = ImageIO.read(new File("image\\素材\\野原广志\\a9.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = -5;
		y = 160;
	}

	public void skillMove() {
		if (skill1State1) {
			step_Skill1();
			if (image == image38) {// 技能释放完毕
				skill1State1 = false;
			}
		}

	}

	// 技能2
	private void step_Skill1() {
		int temp = timer_skill1++ % 10;
		if (temp == 0) {
			image = image30;
		}
		if (temp == 1) {
			image = image31;
		}
		if (temp == 2) {
			image = image32;
		}
		if (temp == 3) {
			image = image33;
		}
		if (temp == 4) {
			image = image34;
		}
		if (temp == 5) {
			image = image35;
		}
		if (temp == 6) {
			image = image36;
		}
		if (temp == 7) {
			image = image37;
		}
		if (temp == 8) {
			image = image38;
		}
		if (temp == 9) {
			image = image39;
		}

	}

	// 技能的发射子弹
	public Bullet2 shoot(int i) {

		return new Bullet2(this.x - 120, this.y + 50, i);

	}

	public void jumpMove() {
		// 跑步
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

	public void skill1() {
		this.skill1State1 = true;
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
