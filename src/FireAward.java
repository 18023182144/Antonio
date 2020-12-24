

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class FireAward {
	private int x;
	private int y;
	private int speedX = 25;
	private int speedY = 10;
	private int RandomNum = new Random().nextInt(2); // ³õÊ¼×óÓÒ·½ÏòµÄËæ»úÖµ
	

	private BufferedImage image;

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	
	
	private int timer = 0;
	
	private boolean isRemove;
	private boolean isDead;

	public FireAward() {
		try {
			image1 = ImageIO.read(new File("image/½±Àø/achieve_016.png"));
			image2 = ImageIO.read(new File("image/½±Àø/jj_beam_bomb01.png"));
			image3 = ImageIO.read(new File("image/½±Àø/jj_beam_bomb02.png"));
			image4 = ImageIO.read(new File("image/½±Àø/jj_beam_bomb04.png"));
			image5 = ImageIO.read(new File("image/½±Àø/jj_beam_bomb05.png"));

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
			int temp = timer++ %4;
			if(temp == 0) {
				image = image2;
			}
			if(temp == 1) {
				image = image3;
			}
			if(temp == 2) {
				image = image4;
			}
			if(temp == 3) {
				image = image5;
				isDead = true;
			}
			return image;
		} else {
			return this.image;
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
