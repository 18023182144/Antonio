import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet2 {

	private int x;
	private int y;

	private int speed = 20;

	private BufferedImage bullet;
	// 技能1子弹
	private BufferedImage bullet1;
	// 技能2子弹
	private BufferedImage bullet2;
	private BufferedImage bullet3;
	private BufferedImage bullet4;

	// 爆炸图
	private BufferedImage bomb1;
	private BufferedImage bomb2;
	private BufferedImage bomb3;
	private BufferedImage bomb4;
	private BufferedImage bomb5;
	private BufferedImage bomb6;
	private BufferedImage bomb7;
	private BufferedImage bomb8;
	private BufferedImage bomb9;

	private int timer = 0;// 计时器
	private int timer_bomb = 0;// 爆炸计时器
	private boolean isRemove = false;
	private boolean isDead = false;

	private int flag = 0;// 子弹种类标记

	public Bullet2(int x, int y, int flag) {
		try {
			bullet1 = ImageIO.read(new File("image\\素材\\野原广志\\袜子.png"));
			bomb1 = ImageIO.read(new File("image/子弹爆炸/bomb_00000.png"));
			bomb2 = ImageIO.read(new File("image/子弹爆炸/bomb_00001.png"));
			bomb3 = ImageIO.read(new File("image/子弹爆炸/bomb_00002.png"));
			bomb4 = ImageIO.read(new File("image/子弹爆炸/bomb_00003.png"));
			bomb5 = ImageIO.read(new File("image/子弹爆炸/bomb_00004.png"));
			bomb6 = ImageIO.read(new File("image/子弹爆炸/bomb_00005.png"));
			bomb7 = ImageIO.read(new File("image/子弹爆炸/bomb_00006.png"));
			bomb8 = ImageIO.read(new File("image/子弹爆炸/bomb_00007.png"));
			bomb9 = ImageIO.read(new File("image/子弹爆炸/bomb_00008.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.flag = flag;

		// 初始化默认值
		if (this.flag == 1) {
			bullet = bullet1;
		} else {
			bullet = bullet2;
			this.y += 45;
		}
	}

	public void step() {
		this.x += speed;
	}

	public void bomb() {
		this.x -= 3;
		this.y -= 15;
		int temp = timer_bomb++ % 9;
		if (temp == 0) {
			bullet = bomb1;
		}
		if (temp == 1) {
			bullet = bomb2;
		}
		if (temp == 2) {
			bullet = bomb3;
		}
		if (temp == 3) {
			bullet = bomb4;
		}
		if (temp == 4) {
			bullet = bomb5;
		}
		if (temp == 5) {
			bullet = bomb6;
		}
		if (temp == 6) {
			bullet = bomb7;
		}
		if (temp == 7) {
			bullet = bomb8;
		}
		if (temp == 8) {
			bullet = bomb9;
			isDead = true;
		}

	}

	public BufferedImage getImage1() {
		bullet = bullet1;
		if (isRemove) {
			bomb();

		}
		return bullet;
	}

	public BufferedImage getImage2() {
		int temp = timer++ % 3; // 0 1 2;
		if (temp == 0) {
			bullet = bullet2;
		}
		if (temp == 1) {
			bullet = bullet3;
		}
		if (temp == 2) {
			bullet = bullet4;
		}
		if (isRemove) {
			bomb();
		}

		return bullet;
	}

	public BufferedImage getImage() {
		if (flag == 1) {
			return getImage1();
		} else {
			return getImage2();
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, bullet.getWidth(), bullet.getHeight());
	}

	// 越界移除判断
	public boolean acrossBorder() {
		return this.x >= 1000;
	}

	public boolean isRemove() {
		return isRemove;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

}
