import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Barrier {
	private int x;
	private int y;

	private BufferedImage image;// Ö÷Í¼

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage image8;
	private BufferedImage image9;
	private BufferedImage image10;

	private BufferedImage enemy1;
	private BufferedImage enemy2;
	private BufferedImage enemy3;
	private BufferedImage enemy4;

	private BufferedImage enemy6;
	private BufferedImage enemy7;
	private BufferedImage enemy8;
	private BufferedImage enemy9;
	private BufferedImage enemy10;
	private BufferedImage enemy11;
	private BufferedImage enemy12;
	private BufferedImage enemy13;
	private BufferedImage enemy14;
	private BufferedImage enemy15;
	private BufferedImage enemy16;
	private BufferedImage enemy17;
	private BufferedImage enemy18;
	private BufferedImage enemy19;
	private BufferedImage enemy20;

	private BufferedImage enemy21;
	private BufferedImage enemy22;
	private BufferedImage enemy23;
	private BufferedImage enemy24;
	private BufferedImage enemy25;
	private BufferedImage enemy26;

	private BufferedImage enemy27;
	private BufferedImage enemy28;
	private BufferedImage enemy29;
	private BufferedImage enemy30;

	private BufferedImage enemy31;
	private BufferedImage enemy32;
	private BufferedImage enemy33;
	private BufferedImage enemy34;
	private BufferedImage enemy35;
	private BufferedImage enemy36;

	private BufferedImage enemy37;
	private BufferedImage enemy38;
	private BufferedImage enemy39;
	private BufferedImage enemy40;

	private BufferedImage enemy41;
//	private BufferedImage enemy42;
//	private BufferedImage enemy43;
//	private BufferedImage enemy44;

	private BufferedImage enemy45;
	private BufferedImage enemy46;
	private BufferedImage enemy47;
	private BufferedImage enemy48;

	private BufferedImage enemy49;
	private BufferedImage enemy50;
	private BufferedImage enemy51;
	private BufferedImage enemy52;
	private BufferedImage enemy53;
	private BufferedImage enemy54;

	// ËÀÍö»­Ãæ1
	private BufferedImage enemy55;
	private BufferedImage enemy56;
	private BufferedImage enemy57;
	private BufferedImage enemy58;
	private BufferedImage enemy59;

	// ËÀÍö»­Ãæ2
	private BufferedImage enemy60;
	private BufferedImage enemy61;
	private BufferedImage enemy62;
	private BufferedImage enemy63;
	private BufferedImage enemy64;
	private BufferedImage enemy65;
	private BufferedImage enemy66;
	private BufferedImage enemy67;
	private BufferedImage enemy68;
	private BufferedImage enemy69;

	// ËÀÍö»­Ãæ3
	private BufferedImage enemy70;
	private BufferedImage enemy71;
	private BufferedImage enemy72;
	private BufferedImage enemy73;
	private BufferedImage enemy74;
	private BufferedImage enemy75;

	// ËÀÍö»­Ãæ4
	private BufferedImage enemy76;
	private BufferedImage enemy77;
	private BufferedImage enemy78;
	private BufferedImage enemy79;
	private BufferedImage enemy80;

	// ËÀÍö»­Ãæ5
	private BufferedImage enemy81;
	private BufferedImage enemy82;
	private BufferedImage enemy83;
	private BufferedImage enemy84;

	// ËÀÍö»­Ãæ6
	private BufferedImage enemy85;
	private BufferedImage enemy86;
	private BufferedImage enemy87;
	private BufferedImage enemy88;
	private BufferedImage enemy89;

	// ËÀÍö»­Ãæ7
	private BufferedImage enemy90;
	private BufferedImage enemy91;
	private BufferedImage enemy92;
	private BufferedImage enemy93;

	// ËÀÍö»­Ãæ8
	private BufferedImage enemy94;
	private BufferedImage enemy95;
	private BufferedImage enemy96;
	private BufferedImage enemy97;

	// ËÀÍö»­Ãæ9
	private BufferedImage enemy98;
	private BufferedImage enemy99;
	private BufferedImage enemy100;

	private int speed = Background.SPEED1;

	private int timer1 = 0; // ¼ÆÊ±Æ÷1
	private int timer2 = 0; // ¼ÆÊ±Æ÷2
	private int timer3 = 0; // ¼ÆÊ±Æ÷3
	private int timer4 = 0; // ¼ÆÊ±Æ÷4
	private int timer5 = 0; // ¼ÆÊ±Æ÷5
	private int timer6 = 0; // ¼ÆÊ±Æ÷6
	private int timer7 = 0; // ¼ÆÊ±Æ÷7
	// private int timer8 = 0; // ¼ÆÊ±Æ÷8
	private int timer9 = 0; // ¼ÆÊ±Æ÷9
	private int timer10 = 0; // ¼ÆÊ±Æ÷10

	private int flag = 0; // 1 2 3 4 5 6 7 8 9 ²»Í¬ÖÖµĞÈË

	private boolean isRemove = false;// ÒÆ³ı±ê¼Ç
	private int removeCount = 0;
	private boolean isDead = false;// ËÀÍö±ê¼Ç
	private int timer1_dead = 0; // ËÀÍö¼ÆÊ±Æ÷1
	private int timer2_dead = 0; // ËÀÍö¼ÆÊ±Æ÷2
	private int timer3_dead = 0; // ËÀÍö¼ÆÊ±Æ÷3
	private int timer4_dead = 0; // ËÀÍö¼ÆÊ±Æ÷4
	private int timer5_dead = 0; // ËÀÍö¼ÆÊ±Æ÷5
	private int timer6_dead = 0; // ËÀÍö¼ÆÊ±Æ÷6
	private int timer7_dead = 0; // ËÀÍö¼ÆÊ±Æ÷7
	// private int timer8_dead = 0; // ËÀÍö¼ÆÊ±Æ÷8
	private int timer9_dead = 0; // ËÀÍö¼ÆÊ±Æ÷9
	private int timer10_dead = 0; // ËÀÍö¼ÆÊ±Æ÷10

	public Barrier() {
		// ¶ÁÈ¡Í¼Æ¬
		try {
			enemy1 = ImageIO.read(new File("image/enemy/1/bomb_mini_stand_0001.png"));// Õ¨µ¯ÈË
			enemy2 = ImageIO.read(new File("image/enemy/1/bomb_mini_stand_0002.png"));
			enemy3 = ImageIO.read(new File("image/enemy/1/bomb_mini_stand_0003.png"));
			enemy4 = ImageIO.read(new File("image/enemy/1/bomb_mini_stand_0004.png"));

			enemy6 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0001.png"));// ±¬Öñ
			enemy7 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0002.png"));
			enemy8 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0005.png"));
			enemy9 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0006.png"));
			enemy10 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0008.png"));
			enemy11 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0009.png"));
			enemy12 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0010.png"));
			enemy13 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0012.png"));
			enemy14 = ImageIO.read(new File("image/enemy/2/boxboy_attack_center_0013.png"));

			enemy15 = ImageIO.read(new File("image/enemy/3/buriburi_run_center_0001.png"));// Öí
			enemy16 = ImageIO.read(new File("image/enemy/3/buriburi_run_center_0002.png"));
			enemy17 = ImageIO.read(new File("image/enemy/3/buriburi_run_center_0003.png"));
			enemy18 = ImageIO.read(new File("image/enemy/3/buriburi_run_center_0004.png"));
			enemy19 = ImageIO.read(new File("image/enemy/3/buriburi_run_center_0005.png"));
			enemy20 = ImageIO.read(new File("image/enemy/3/buriburi_run_center_0006.png"));

			enemy21 = ImageIO.read(new File("image/enemy/4/chocobee_walking_center_0001.png"));// ¿ÖÁú
			enemy22 = ImageIO.read(new File("image/enemy/4/chocobee_walking_center_0002.png"));
			enemy23 = ImageIO.read(new File("image/enemy/4/chocobee_walking_center_0003.png"));
			enemy24 = ImageIO.read(new File("image/enemy/4/chocobee_walking_center_0004.png"));
			enemy25 = ImageIO.read(new File("image/enemy/4/chocobee_walking_center_0005.png"));
			enemy26 = ImageIO.read(new File("image/enemy/4/chocobee_walking_center_0006.png"));

			enemy31 = ImageIO.read(new File("image/enemy/6/hip_walk_center_0001.png"));// ¿ÖÁú
			enemy32 = ImageIO.read(new File("image/enemy/6/hip_walk_center_0002.png"));
			enemy33 = ImageIO.read(new File("image/enemy/6/hip_walk_center_0003.png"));
			enemy34 = ImageIO.read(new File("image/enemy/6/hip_walk_center_0004.png"));
			enemy35 = ImageIO.read(new File("image/enemy/6/hip_walk_center_0005.png"));
			enemy36 = ImageIO.read(new File("image/enemy/6/hip_walk_center_0006.png"));

			enemy37 = ImageIO.read(new File("image/enemy/7/mimi_walking_center_0001.png"));// ·É»úÅ®
			enemy38 = ImageIO.read(new File("image/enemy/7/mimi_walking_center_0002.png"));
			enemy39 = ImageIO.read(new File("image/enemy/7/mimi_walking_center_0003.png"));
			enemy40 = ImageIO.read(new File("image/enemy/7/mimi_walking_center_0004.png"));

			enemy45 = ImageIO.read(new File("image/enemy/9/rocket_mini_walk_center_0001.png"));// ·ÉÌìÄĞ
			enemy46 = ImageIO.read(new File("image/enemy/9/rocket_mini_walk_center_0002.png"));
			enemy47 = ImageIO.read(new File("image/enemy/9/rocket_mini_walk_center_0003.png"));
			enemy48 = ImageIO.read(new File("image/enemy/9/rocket_mini_walk_center_0004.png"));

			enemy55 = ImageIO.read(new File("image/enemy/1/ËÀÍö/minipanty_death_0001.png"));
			enemy56 = ImageIO.read(new File("image/enemy/1/ËÀÍö/minipanty_death_0003.png"));
			enemy57 = ImageIO.read(new File("image/enemy/1/ËÀÍö/minipanty_death_0004.png"));
			enemy58 = ImageIO.read(new File("image/enemy/1/ËÀÍö/minipanty_death_0005.png"));
			enemy59 = ImageIO.read(new File("image/enemy/1/ËÀÍö/minipanty_death_0006.png"));

			enemy60 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_damage_center_0002.png"));
			enemy61 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_damage_center_0003.png"));
			enemy62 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_damage_center_0004.png"));
			enemy63 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_damage_center_0005.png"));
			enemy64 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_death_center_0001.png"));
			enemy65 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_death_center_0002.png"));
			enemy66 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_death_center_0003.png"));
			enemy67 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_death_center_0005.png"));
			enemy68 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_death_center_0006.png"));
			enemy69 = ImageIO.read(new File("image/enemy/2/ËÀÍö/boxboy_death_center_0008.png"));

			enemy70 = ImageIO.read(new File("image/enemy/3/ËÀÍö/buriburi_damage_center_0001.png"));
			enemy71 = ImageIO.read(new File("image/enemy/3/ËÀÍö/buriburi_damage_center_0002.png"));
			enemy72 = ImageIO.read(new File("image/enemy/3/ËÀÍö/buriburi_damage_center_0003.png"));
			enemy73 = ImageIO.read(new File("image/enemy/3/ËÀÍö/buriburi_death_center_0001.png"));
			enemy74 = ImageIO.read(new File("image/enemy/3/ËÀÍö/buriburi_death_center_0002.png"));
			enemy75 = ImageIO.read(new File("image/enemy/3/ËÀÍö/buriburi_death_center_0003.png"));

			enemy76 = ImageIO.read(new File("image/enemy/4/ËÀÍö/chocobee_stun_center_0001.png"));
			enemy77 = ImageIO.read(new File("image/enemy/4/ËÀÍö/chocobee_stun_center_0002.png"));
			enemy78 = ImageIO.read(new File("image/enemy/4/ËÀÍö/chocobee_stun_center_0003.png"));
			enemy79 = ImageIO.read(new File("image/enemy/4/ËÀÍö/chocobee_stun_center_0004.png"));
			enemy80 = ImageIO.read(new File("image/enemy/4/ËÀÍö/chocobee_stun_center_0005.png"));

			enemy85 = ImageIO.read(new File("image/enemy/6/ËÀÍö/hip_death_center_0001.png"));
			enemy86 = ImageIO.read(new File("image/enemy/6/ËÀÍö/hip_death_center_0002.png"));
			enemy87 = ImageIO.read(new File("image/enemy/6/ËÀÍö/hip_death_center_0003.png"));
			enemy88 = ImageIO.read(new File("image/enemy/6/ËÀÍö/hip_death_center_0004.png"));
			enemy89 = ImageIO.read(new File("image/enemy/6/ËÀÍö/hip_death_center_0005.png"));

			enemy90 = ImageIO.read(new File("image/enemy/7/ËÀÍö/mimi_damage_center_0001.png"));
			enemy91 = ImageIO.read(new File("image/enemy/7/ËÀÍö/mimi_damage_center_0002.png"));
			enemy92 = ImageIO.read(new File("image/enemy/7/ËÀÍö/mimi_damage_center_0003.png"));
			enemy93 = ImageIO.read(new File("image/enemy/7/ËÀÍö/mimi_damage_center_0004.png"));

			enemy94 = ImageIO.read(new File("image/enemy/9/ËÀÍö/rocket_panty_damage_center_0001.png"));
			enemy95 = ImageIO.read(new File("image/enemy/9/ËÀÍö/rocket_panty_damage_center_0002.png"));
			enemy96 = ImageIO.read(new File("image/enemy/9/ËÀÍö/rocket_panty_damage_center_0003.png"));
			enemy97 = ImageIO.read(new File("image/enemy/9/ËÀÍö/rocket_panty_damage_center_0004.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 983;
		y = 225;

		// Ä¬ÈÏ
		image = image1;
		flag = 1;

		image1 = enemy1;
		image2 = enemy6;
		image3 = enemy15;
		image4 = enemy21;
		image5 = enemy27;
		image6 = enemy31;
		image7 = enemy37;
		image8 = enemy41;
		image9 = enemy45;
		image10 = enemy49;

		int temp = new Random().nextInt(11); // 0 1 2 3 4 5 6 7 8 9

		if (temp == 0) { // ÃÉÃæÈË
			image = image1;
			flag = 1;

		}
		if (temp == 1) {// ÀÃºĞ×Ó

			image = image2;
			flag = 2;
			y = 275;
		}
		if (temp == 2) {// Öí

			image = image3;
			flag = 3;
			y = 260;
		}
		if (temp == 3) {// À¬»øÁú
			image = image4;
			flag = 4;
			y = 270;
		}
		if (temp == 5) {// Ğ¡¹ÖÊŞ

			image = image6;
			flag = 6;
			y = 255;
		}
		if (temp == 6) {// ·ÉÌìÅ®

			image = image7;
			flag = 7;
			y = 80;

		}

		if (temp == 8) {// ·ÉÌìÄĞ

			image = image9;
			flag = 9;
			y = 80;

		}

	}

	// ¹ö¶¯
	public void cactusMove() {
		x -= (speed + 10);
	}

	public void move1() {

		if (isRemove) {
			this.y += 20;
			int temp = timer1_dead++ % 5;
			if (temp == 0) {
				image1 = enemy55;
			}
			if (temp == 1) {
				image1 = enemy56;
			}
			if (temp == 2) {
				image1 = enemy57;
			}
			if (temp == 3) {
				image1 = enemy58;
			}
			if (temp == 4) {
				image1 = enemy59;
				isDead = true;
			}
		} else {
			int temp = timer1++ % 4;
			if (temp == 0) {
				image1 = enemy1;
			}
			if (temp == 1) {
				image1 = enemy2;
			}
			if (temp == 2) {
				image1 = enemy3;
			}
			if (temp == 3) {
				image1 = enemy4;
			}
		}

	}

	public void move2() {

		if (isRemove) {
			this.y -= 10;
			int temp = timer2_dead++ % 10;
			if (temp == 0) {
				image2 = enemy60;
			}
			if (temp == 1) {
				image2 = enemy61;
			}
			if (temp == 2) {
				image2 = enemy62;
			}
			if (temp == 3) {
				image2 = enemy63;
			}
			if (temp == 4) {
				image2 = enemy64;
			}
			if (temp == 5) {
				image2 = enemy65;
			}
			if (temp == 6) {
				image2 = enemy66;
			}
			if (temp == 7) {
				image2 = enemy67;
			}
			if (temp == 8) {
				image2 = enemy68;
			}
			if (temp == 9) {
				image2 = enemy69;
				isDead = true;
			}
		} else {
			int temp = timer2++ % 9;
			if (temp == 0) {
				image2 = enemy6;
			}
			if (temp == 1) {
				image2 = enemy7;
			}
			if (temp == 2) {
				image2 = enemy8;
			}
			if (temp == 3) {
				image2 = enemy9;
			}
			if (temp == 4) {
				image2 = enemy10;
			}
			if (temp == 5) {
				image2 = enemy11;
			}
			if (temp == 6) {
				image2 = enemy12;
			}
			if (temp == 7) {
				image2 = enemy13;
			}
			if (temp == 8) {
				image2 = enemy14;
			}
		}

	}

	public void move3() {

		if (isRemove) {
			this.x += 20;
			int temp = timer3_dead++ % 6;
			if (temp == 0) {
				image3 = enemy70;
			}
			if (temp == 1) {
				image3 = enemy71;
			}
			if (temp == 2) {
				image3 = enemy72;
			}
			if (temp == 3) {
				image3 = enemy73;
			}
			if (temp == 4) {
				image3 = enemy74;
			}
			if (temp == 5) {
				image3 = enemy75;
				isDead = true;
			}
		} else {
			int temp = timer3++ % 6;
			if (temp == 0) {
				image3 = enemy15;
			}
			if (temp == 1) {
				image3 = enemy16;
			}
			if (temp == 2) {
				image3 = enemy17;
			}
			if (temp == 3) {
				image3 = enemy18;
			}
			if (temp == 4) {
				image3 = enemy19;
			}
			if (temp == 5) {
				image3 = enemy20;
			}
		}

	}

	public void move4() {
		if (isRemove) {
			this.x += 15;
			int temp = timer4_dead++ % 5;
			if (temp == 0) {
				image4 = enemy76;
			}
			if (temp == 1) {
				image4 = enemy77;
			}
			if (temp == 2) {
				image4 = enemy78;
			}
			if (temp == 3) {
				image4 = enemy79;
			}
			if (temp == 4) {
				image4 = enemy80;
				isDead = true;
			}
		} else {
			int temp = timer4++ % 6;
			if (temp == 0) {
				image4 = enemy21;
			}
			if (temp == 1) {
				image4 = enemy22;
			}
			if (temp == 2) {
				image4 = enemy23;
			}
			if (temp == 3) {
				image4 = enemy24;
			}
			if (temp == 4) {
				image4 = enemy25;
			}
			if (temp == 5) {
				image4 = enemy26;
			}
		}
	}

	public void move5() {
		if (isRemove) {
			this.x -= 5;
			int temp = timer5_dead++ % 4;
			if (temp == 0) {
				image5 = enemy81;
			}
			if (temp == 1) {
				image5 = enemy82;
			}
			if (temp == 2) {
				image5 = enemy83;
			}
			if (temp == 3) {
				image5 = enemy84;
				isDead = true;
			}
		} else {
			int temp = timer5++ % 4;
			if (temp == 0) {
				image5 = enemy27;
			}
			if (temp == 1) {
				image5 = enemy28;
			}
			if (temp == 2) {
				image5 = enemy29;
			}
			if (temp == 3) {
				image5 = enemy30;
			}
		}
	}

	public void move6() {
		if (isRemove) {
			this.y += 10;
			int temp = timer6_dead++ % 5;
			if (temp == 0) {
				image6 = enemy85;
			}
			if (temp == 1) {
				image6 = enemy86;
			}
			if (temp == 2) {
				image6 = enemy87;
			}
			if (temp == 3) {
				image6 = enemy88;
			}
			if (temp == 4) {
				image6 = enemy89;
				isDead = true;
			}

		} else {
			int temp = timer6++ % 6;
			if (temp == 0) {
				image6 = enemy31;
			}
			if (temp == 1) {
				image6 = enemy32;
			}
			if (temp == 2) {
				image6 = enemy33;
			}
			if (temp == 3) {
				image6 = enemy34;
			}
			if (temp == 4) {
				image6 = enemy35;
			}
			if (temp == 5) {
				image6 = enemy36;
			}
		}
	}

	public void move7() {
		if (isRemove) {
			this.y += 10;
			int temp = timer7_dead++ % 4;
			if (temp == 0) {
				image7 = enemy90;
			}
			if (temp == 1) {
				image7 = enemy91;
			}
			if (temp == 2) {
				image7 = enemy92;
			}
			if (temp == 3) {
				image7 = enemy93;
				isDead = true;
			}
		} else {
			int temp = timer7++ % 4;
			if (temp == 0) {
				image7 = enemy37;
			}
			if (temp == 1) {
				image7 = enemy38;
			}
			if (temp == 2) {
				image7 = enemy39;
			}
			if (temp == 3) {
				image7 = enemy40;
			}
		}

	}

	public void move9() {
		if (isRemove) {
			this.y += 10;
			int temp = timer9_dead++ % 4;
			if (temp == 0) {
				image9 = enemy94;
			}
			if (temp == 1) {
				image9 = enemy95;
			}
			if (temp == 2) {
				image9 = enemy96;
			}
			if (temp == 3) {
				image9 = enemy97;
				isDead = true;
			}
		} else {
			int temp = timer9++ % 4;
			if (temp == 0) {
				image9 = enemy45;
			}
			if (temp == 1) {
				image9 = enemy46;
			}
			if (temp == 2) {
				image9 = enemy47;
			}
			if (temp == 3) {
				image9 = enemy48;
			}
		}

	}

	public void move10() {
		if (isRemove) {
			int temp = timer10_dead++ % 3;
			if (temp == 0) {
				image10 = enemy98;
			}
			if (temp == 1) {
				image10 = enemy99;
			}
			if (temp == 2) {
				image10 = enemy100;
				isDead = true;
			}

		} else {
			int temp = timer10++ % 6;
			if (temp == 0) {
				image10 = enemy49;
			}
			if (temp == 1) {
				image10 = enemy50;
			}
			if (temp == 2) {
				image10 = enemy51;
			}
			if (temp == 3) {
				image10 = enemy52;
			}
			if (temp == 4) {
				image10 = enemy53;
			}
			if (temp == 5) {
				image10 = enemy54;
			}
		}
	}

	// »ñÈ¡ËÀÍöÇøÓò
	public Rectangle getBounds() {
		return new Rectangle(x, y, getImage().getWidth(), getImage().getHeight());
	}

	// Ô½½çÒÆ³ıÅĞ¶Ï
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
		if (flag == 6) {
			image = image6;
		}
		if (flag == 7) {
			image = image7;
		}
		if (flag == 8) {
			image = image8;
		}
		if (flag == 9) {
			image = image9;
		}
		if (flag == 10) {
			image = image10;
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

	public void setRemove(int i) {
		this.removeCount += i;
		if (removeCount >= 2) {
			this.isRemove = true;
		}
	}

	public boolean isDead() {
		return isDead;
	}

	public boolean isRemove() {
		return isRemove;
	}

}
