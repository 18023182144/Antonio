import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class lbxx {
	private int x; // ����С������
	private int y;
	private BufferedImage image; // ��ͼƬ
	// ����֮ǰ���ܵ�ͼ
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	
	// ����֮ǰ��Ծ��ͼ
	private BufferedImage image7;
	private BufferedImage image8;
	private BufferedImage image9;
	
	// ������̵�ͼ
	private BufferedImage image10;
	private BufferedImage image11;
	private BufferedImage image12;
	private BufferedImage image13;
	private BufferedImage image14;
	private BufferedImage image15;
	private BufferedImage image16;
	private BufferedImage image17;
	private BufferedImage image18;
	private BufferedImage image19;
	private BufferedImage image20;

	// ����֮����
	private BufferedImage image21;
	private BufferedImage image22;
	private BufferedImage image23;
	private BufferedImage image24;
	private BufferedImage image25;
	private BufferedImage image26;

	// ����֮����Ծ
	private BufferedImage image27;
	private BufferedImage image28;

	// ����֮ǰ���ܣ�����

	private BufferedImage image30;
	private BufferedImage image31;
	private BufferedImage image32;
	private BufferedImage image33;

	// ����֮���ܣ������ڣ�
	private BufferedImage image34;
	private BufferedImage image35;
	private BufferedImage image36;
	private BufferedImage image37;
	private BufferedImage image38;
	private BufferedImage image39;
	private BufferedImage image40;
	private BufferedImage image41;
	private BufferedImage image42;
	private BufferedImage image43;
	private BufferedImage image44;

	// ��������������ǰ��
	private BufferedImage image45;
	private BufferedImage image46;
	private BufferedImage image47;
	private BufferedImage image48;
	private BufferedImage image49;
	private BufferedImage image50;
	private BufferedImage image51;

	// ���������������
	private BufferedImage image52;
	private BufferedImage image53;
	private BufferedImage image54;
	private BufferedImage image55;
	private BufferedImage image56;
	private BufferedImage image57;
	private BufferedImage image58;
	private BufferedImage image59;

	// ������
	private BufferedImage image60;

	private int timer1 = 0;// С��1�ܲ���ʱ��
	private int timer2 = 0;// С��2�ܲ���ʱ��
	private int timer_jump1 = 0;// ����ʱ��1
	private int timer_jump2 = 0;// ����ʱ��2
	private int timer_hero = 0;// �����ʱ��
	private int timer_skill1 = 0;// ����1��ʱ��
	private int timer_skill2 = 0;// ����2��ʱ��
	private int timer_dead1 = 0;// ����1��ʱ��
	private int timer_dead2 = 0;// ����2��ʱ��
	private boolean jumpState = false;// ��Ծ��״̬
	public static final int LOWEST_Y = 255; // �����ص�����
	private int jumpHeight = 220; // ��Ծ�ĸ߶�
	private int jumpValue = 0;// ��Ծ��������

	private int removeCount = 0;

	private boolean superheroState = false;// �ж��Ƿ����
	private boolean nbState = false;// �����ı�־
	private boolean skill1State1 = false;// �ż���1�ı�־
	private boolean skill1State2 = false;// �ż���2�ı�־
	private boolean isRemove = false;
	private boolean isDead = false;

	private int NBtimer = 100;// ����ʱ��

	public lbxx() {
		try {
			this.image1 = ImageIO.read(new File("image/hero/����֮ǰ/����/jjan_run_0001.png"));
			this.image2 = ImageIO.read(new File("image/hero/����֮ǰ/����/jjan_run_0002.png"));
			this.image3 = ImageIO.read(new File("image/hero/����֮ǰ/����/jjan_run_0003.png"));
			this.image4 = ImageIO.read(new File("image/hero/����֮ǰ/����/jjan_run_0004.png"));
			this.image5 = ImageIO.read(new File("image/hero/����֮ǰ/����/jjan_run_0005.png"));
			this.image6 = ImageIO.read(new File("image/hero/����֮ǰ/����/jjan_run_0006.png"));

			this.image7 = ImageIO.read(new File("image/hero/����֮ǰ/��Ծ/jjan_skill_005_01.png"));
			this.image8 = ImageIO.read(new File("image/hero/����֮ǰ/��Ծ/jjan_skill_005_02.png"));
			this.image9 = ImageIO.read(new File("image/hero/����֮ǰ/��Ծ/jjan_skill_005_03.png"));

			this.image10 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0001.png"));
			this.image11 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0002.png"));
			this.image12 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0005.png"));
			this.image13 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0006.png"));
			this.image14 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0007.png"));
			this.image15 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0008.png"));
			this.image16 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0009.png"));
			this.image17 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0010.png"));
			this.image18 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0013.png"));
			this.image19 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0014.png"));
			this.image20 = ImageIO.read(new File("image/hero/�������/actionjjan_trans_0015.png"));

			this.image21 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_run_0001.png"));
			this.image22 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_run_0002.png"));
			this.image23 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_run_0003.png"));
			this.image24 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_run_0004.png"));
			this.image25 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_run_0005.png"));
			this.image26 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_run_0006.png"));

			this.image27 = ImageIO.read(new File("image/hero/����֮��/��/actionjjan_attack_0004.png"));
			this.image28 = ImageIO.read(new File("image/hero/����֮��/��/actionjjan_attack_0005.png"));

			this.image30 = ImageIO.read(new File("image/hero/����֮ǰ/skill1������/jjan_skill_010_02.png"));
			this.image31 = ImageIO.read(new File("image/hero/����֮ǰ/skill1������/jjan_skill_010_03.png"));
			this.image32 = ImageIO.read(new File("image/hero/����֮ǰ/skill1������/jjan_skill_010_04.png"));
			this.image33 = ImageIO.read(new File("image/hero/����֮ǰ/skill1������/jjan_skill_010_05.png"));

			this.image34 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0001.png"));
			this.image35 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0002.png"));
			this.image36 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0005.png"));
			this.image37 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0006.png"));
			this.image38 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0007.png"));
			this.image39 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0009.png"));
			this.image40 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0010.png"));
			this.image41 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0011.png"));
			this.image42 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0013.png"));
			this.image43 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0014.png"));
			this.image44 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_skill1_0015.png"));

			this.image45 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0001.png"));
			this.image46 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0002.png"));
			this.image47 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0003.png"));
			this.image48 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0004.png"));
			this.image49 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0005.png"));
			this.image50 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0006.png"));
			this.image51 = ImageIO.read(new File("image/hero/����֮ǰ\\����/jjan_death_0007.png"));

			this.image52 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_damage_0001.png"));
			this.image53 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_damage_0002.png"));
			this.image54 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_damage_0003.png"));
			this.image55 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_death_0004.png"));
			this.image56 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_death_0005.png"));
			this.image57 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_death_0006.png"));
			this.image58 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_death_0007.png"));
			this.image59 = ImageIO.read(new File("image/hero/����֮��/����/actionjjan_death_0008.png"));

			this.image60 = ImageIO.read(new File("image/������/����.png"));

			this.image = image1;

		} catch (IOException e) {
			e.printStackTrace();
		}

		x = 230;
		y = LOWEST_Y;
	}

	public void deadMove2() {
		y = LOWEST_Y;// ����λ�ö��ڵ���
		int temp = timer_dead2++ % 8;
		if (temp == 0) {
			image = image52;
		}
		if (temp == 1) {
			image = image53;
		}
		if (temp == 2) {
			image = image54;
		}
		if (temp == 3) {
			image = image55;
		}
		if (temp == 4) {
			image = image56;
		}
		if (temp == 5) {
			image = image57;
		}
		if (temp == 6) {
			image = image58;
		}
		if (temp == 7) {
			x -= 30;
			y = LOWEST_Y - 20;
			image = image59;
			isDead = true;

		}

	}

	// ��������չʾ ->�������������͸�˵��źţ����������������꣩
	public void deadMove1() {
		y = LOWEST_Y + 30;// ����λ�ö��ڵ���
		int temp = timer_dead1++ % 7;
		if (temp == 0) {
			image = image45;
		}
		if (temp == 1) {
			image = image46;
		}
		if (temp == 2) {
			image = image47;
		}
		if (temp == 3) {
			image = image48;
		}
		if (temp == 4) {
			image = image49;
		}
		if (temp == 5) {
			image = image50;
		}
		if (temp == 6) {
			image = image51;
			isDead = true;
		}

	}

	public void skillMove() {
		if (skill1State1 && !nbState) { // ����1���ܣ������ڲ����������ͷ�
			step_Skill1();
			if (image == image33) {// �����ͷ����
				skill1State1 = false;
			}
		}
		if (skill1State2 && nbState) {
			step_Skill2();
			if (image == image44) {// �����ͷ����
				skill1State2 = false;
			}
		}

	}

	// ����2
	private void step_Skill2() {
		int temp = timer_skill2++ % 11;
		if (temp == 10) {
			image = image34;
		}
		if (temp == 9) {
			image = image35;
		}
		if (temp == 8) {
			image = image36;
		}
		if (temp == 7) {
			image = image37;
		}
		if (temp == 6) {
			image = image38;
		}
		if (temp == 5) {
			image = image39;
		}
		if (temp == 4) {
			image = image40;
		}
		if (temp == 3) {
			image = image41;
		}
		if (temp == 2) {
			image = image42;
		}
		if (temp == 1) {
			image = image43;
		}
		if (temp == 10) {
			image = image44;
		}

	}

	// ����1
	private void step_Skill1() {
		int temp = timer_skill1++ % 4;
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
	}

	// ���ܵķ����ӵ�
	public Bullet shoot(int i) {

		return new Bullet(this.x - 23, this.y, i);

	}

	public void jumpMove() {
		// �ܲ�
		Stepping();

		// ��
		if (jumpState) {
			if (nbState) {
				// ����֮�����
				step_jump2();
			} else {
				// ����֮ǰ����
				step_jump1();
			}

			if (y >= LOWEST_Y) { // ���վ�ڵ�����
				jumpValue = -30;
			}
			if (y <= LOWEST_Y - jumpHeight) { // �����������ߵ�
				jumpValue = 30;
			}
			y += jumpValue;

			if (y >= LOWEST_Y) { // ��������y���󣬵��ٴε����ϵ�ʱ�򣬾Ͳ�������
				jumpState = false;
			}

		}

		// ����
		if (superheroState && image != image20 && NBtimer >= 0) {
			setp_hero();
			if (image == image20) {
				superheroState = false;
				nbState = true;
			}
		}

	}

	// ������ͼ
	private void setp_hero() {

		int temp = timer_hero++ % 11;//
		if (temp == 0) {
			image = image10;
		}
		if (temp == 1) {
			image = image11;
		}
		if (temp == 2) {
			image = image12;
		}
		if (temp == 3) {
			image = image13;
		}
		if (temp == 4) {
			image = image14;
		}
		if (temp == 5) {
			image = image15;
		}
		if (temp == 6) {
			image = image16;
		}
		if (temp == 7) {
			image = image17;
		}
		if (temp == 8) {
			image = image18;
		}
		if (temp == 9) {
			image = image19;
		}
		if (temp == 10) {
			image = image20;
		}

	}

	// ����ǰ��Ծ��ת��ͼ
	private void step_jump1() {
		int temp = timer_jump1++ % 3; // 0 1 2
		if (temp == 0) {
			image = image7;
		}
		if (temp == 1) {
			image = image8;
		}
		if (temp == 2) {
			image = image9;
		}
	}

	// �������Ծ��ת��ͼ
	private void step_jump2() {
		int temp = timer_jump2++ % 2;
		if (temp == 0) {
			image = image27;
		}
		if (temp == 1) {
			image = image28;
		}

	}

	// С��ԭ��̤��
	public void Stepping() {
		if (!nbState) {
			int temp = timer1++ % 6; // һ����%6 ֻ��õ� 0,1,2,3,4,5 �⼸�����
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
		} else {
			// ����ǳ���״̬��
			NBtimer--; // ����ʱ��ݼ�
			if (NBtimer <= 0) { // ������Ǿͱ��ԭ��
				nbState = false;
			}
			int temp = timer2++ % 6; // һ����%6 ֻ��õ� 0,1,2,3,4,5 �⼸�����
			if (temp == 0) {
				image = image21;
			}
			if (temp == 1) {
				image = image22;
			}
			if (temp == 2) {
				image = image23;
			}
			if (temp == 3) {
				image = image24;
			}
			if (temp == 4) {
				image = image25;
			}
			if (temp == 5) {
				image = image26;
			}
		}

	}

	public void jump() {
		this.jumpState = true;
	}

	public void skill1() {
		this.skill1State1 = true;
	}

	public void skill2() {
		this.skill1State2 = true;
	}

	public void superhero() {
		this.superheroState = true;
	}

	// ��������
	public Rectangle getBounds() {
		return new Rectangle(x, y, image.getWidth() - 20, image.getHeight() - 20); // ����ͷ������

	}

	// �ı�ÿ�λ�ȡͼƬ�Ĳ�ͬ��ʵ�ֿ�����ԭ��̤��
	public BufferedImage getImage() {
		return image;
	}

	// ��ӳ���ʱ��
	public void addNBTimer() {
		this.NBtimer += 100;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isNbState() {
		return nbState;
	}

	public boolean isSkill1State2() {
		return skill1State2;
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

	public BufferedImage getImage60() {
		return image60;
	}

	public void setNBtimer(int nBtimer) {
		NBtimer = nBtimer;
	}

	public int getNBtimer() {
		return NBtimer;
	}

}
