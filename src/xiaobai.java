import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class xiaobai {
	private int x; // 小白坐标
	private int y;

	private BufferedImage image; // 主图片

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;

	private int speed = Background.SPEED1;
	private int timer = 0;
	private boolean callState = false;// 召唤后的标志
	private boolean isRemove = false;
	private boolean isDead = false;
	int on;

	private int Callingtime;

	public xiaobai() {
		try {
			this.image1 = ImageIO.read(new File("image\\素材\\野原小白\\1.png"));
			this.image2 = ImageIO.read(new File("image\\素材\\野原小白\\2.png"));
			this.image3 = ImageIO.read(new File("image\\素材\\野原小白\\3.png"));
			this.image4 = ImageIO.read(new File("image\\素材\\野原小白\\4.png"));
			this.image5 = ImageIO.read(new File("image\\素材\\野原小白\\5.png"));
			this.image6 = ImageIO.read(new File("image\\素材\\野原小白\\6.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 260;
		y = 283;

		try {
			String sql = "select * from user where account ='123'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			while (rs.next()) {
				Callingtime = Integer.parseInt(rs.getString(4));
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void jumpMove() {
		// 跑步
		Stepping();

	}

	public void Stepping() {
		int temp = timer++ % 6;
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
		} else {
			Callingtime--;
			// attributes--;
			if (Callingtime <= 0) {
				callState = false;
				on = 1;
			}
		}
	}

	// 滚动
	public void cactusMove() {
		x += (speed + 1);
	}

	// 死亡区域
	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth() - 20, image.getHeight() - 20); // 恐龙头部区域

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

	public boolean iscallState() {
		return callState;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean isRemove() {
		return isRemove;
	}

	public void setRemove(boolean isRemove) {
		this.isRemove = isRemove;
	}

}
