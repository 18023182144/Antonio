

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class LifeAward {
	private int x;
	private int y;
	private int speedX = 18;
	private int speedY = 10;
	private int RandomNum = new Random().nextInt(2);
	

	private BufferedImage image;

	private BufferedImage image1;
	private BufferedImage image2;
	
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	
	
	
	private int timer1 = 0;
	private int timer2 = 0;
	
	private boolean isRemove;
	private boolean isDead;

	public LifeAward() {
		try {
			image1 = ImageIO.read(new File("image\\保护罩\\action_cap_01.png"));
			image2 = ImageIO.read(new File("image\\保护罩\\action_cap_02.png"));
			
			image3 = ImageIO.read(new File("image\\保护罩\\maeng_s_attack_object2_0001.png"));
			image4 = ImageIO.read(new File("image\\保护罩\\maeng_s_attack_object2_0002.png"));
			image5 = ImageIO.read(new File("image\\保护罩\\maeng_s_attack_object2_0003.png"));
			image6 = ImageIO.read(new File("image\\保护罩\\maeng_s_attack_object2_0004.png"));
			
			image = image1;
			x = 983;
			y = new Random().nextInt(70) + 30;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void step() {
		x -= speedX;
		if (RandomNum == 0) {
			y += speedY;
		} else if (RandomNum == 1) {
			y -= speedY;
		}

		if (this.y <= 0 || this.y >= 140) {
			speedY *= -1;
		}
	}

	public BufferedImage getImage() {
		if(isRemove) {
			this.x-=10;
			int temp = timer2++ %4;
			if(temp == 0) {
				image = image3;
			}
			if(temp == 1) {
				image = image4;
			}
			if(temp == 2) {
				image = image5;
			}
			if(temp == 3) {
				image = image6;
				isDead = true;
			}
			return image;
		} else {
			int temp = timer1++ %2;
			if(temp == 0) {
				image = image1;
			}
			if(temp == 1) {
				image = image2;
			}
			return image;
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	public boolean acrossBorder() {
		return this.speedX <=0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
