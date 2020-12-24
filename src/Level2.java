import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JPanel;

public class Level2 extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private Background background;
	private lbxx dinosaur;
	private Coin coin;
	private Bone bone;
	private fjc fjc;
	private ytnn ytnn;
	private xiaobai xiaobai;
	private rabbit rabbit;

	private CopyOnWriteArrayList<Bullet> bullets1; // �ӵ�
	private CopyOnWriteArrayList<Bullet> bullets2; // �ӵ�
	private CopyOnWriteArrayList<Bullet1> bullets3;// �ӵ�
	private CopyOnWriteArrayList<Coin> coin1;
	private CopyOnWriteArrayList<Bone> bone1;
	private CopyOnWriteArrayList<xiaobai> xiaobai1;
	private CopyOnWriteArrayList<rabbit> rabbit1;
	private CopyOnWriteArrayList<Barrier> barrierlist;
	private CopyOnWriteArrayList<FireAward> awardlist;
	private CopyOnWriteArrayList<LifeAward> lifeAwardlist;

	public static final int FRESH = 100;
	private int barrierTimer = 0;
	private int coinTimer = 0;// ��ҳ���ʱ��
	private int boneTimer = 0;// bone����ʱ��
	private int awardTimer1 = 0; // ��ӽ�����ʱ��
	private int awardTimer2 = 0; // ��ӽ�����ʱ��
	private int awardTimer3 = 0; // ��ӽ�����ʱ��
	private int scoreTimer = 0; // ������ʱ��
	private int score = 0; // �÷�

	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	public static final int WIN = 4;
	private int state = START;// ��Ϸ��־
	private int leave = 0;// ����ͼѡ���־

	private int life = 3;// ��
	private int coinnum = 0;// ���
	private int bonenum = 0;// bone

	private boolean protect = false;// ������
	int bone12;

	public Level2() {
		background = new Background();
		dinosaur = new lbxx();
		ytnn = new ytnn();
		fjc = new fjc();
		coin = new Coin();
		bone = new Bone();
		xiaobai = new xiaobai();
		rabbit = new rabbit();
		barrierlist = new CopyOnWriteArrayList<Barrier>();
		coin1 = new CopyOnWriteArrayList<Coin>();
		bone1 = new CopyOnWriteArrayList<Bone>();
		xiaobai1 = new CopyOnWriteArrayList<xiaobai>();
		rabbit1 = new CopyOnWriteArrayList<rabbit>();
		bullets1 = new CopyOnWriteArrayList<Bullet>();
		bullets2 = new CopyOnWriteArrayList<Bullet>();
		bullets3 = new CopyOnWriteArrayList<Bullet1>();
		awardlist = new CopyOnWriteArrayList<FireAward>();
		lifeAwardlist = new CopyOnWriteArrayList<LifeAward>();
	}

	// ��������
	public void addAward() {

		if (awardTimer1 >= 10000) {
			System.out.println("����");

			awardlist.add(new FireAward());

			awardTimer1 = 0;
		}
		if (awardTimer2 >= 30000) {
			lifeAwardlist.add(new LifeAward());
			awardTimer2 = 0;
			System.out.println("ҩ");
		}

		if (awardTimer3 >= 30000 && !dinosaur.isNbState()) {
			protect = true;
			awardTimer3 = 0;
		}

		if (MainFrame1.on == 1 && !dinosaur.isNbState()) {
			protect = true;
			MainFrame1.on = 2;
		}

		awardTimer1 += FRESH;

		awardTimer2 += FRESH;

		if (!dinosaur.isNbState()) {
			awardTimer3 += FRESH;
		}

	}

	// ����һ
	public void addBullet1() {

		this.bullets1.add(dinosaur.shoot(1));

	}

	// ���ܶ�
	public void addBullet2() {

		this.bullets2.add(dinosaur.shoot(2));

	}

	// ����ϰ���
	public void addBarrier() {

		if (barrierTimer >= 2000) {
			Random r = new Random();
			if ((r.nextInt(100)) > 40) {
				this.barrierlist.add(new Barrier());
			}
			barrierTimer = 0;
		}

		barrierTimer += FRESH;

	}

	// ���
	public void addCoin() {

		if (coinTimer >= 5000) {
			this.coin1.add(new Coin());
			coinTimer = 0;
		}
		coinTimer += FRESH;

	}

	// bone
	public void addbone() {

		if (boneTimer >= 8000) {
			this.bone1.add(new Bone());
			boneTimer = 0;
		}
		boneTimer += FRESH;

	}

	// С��
	public void addxiaobai() {

		this.xiaobai1.add(new xiaobai());

	}

	// ����
	public void addrabbit() {

		this.rabbit1.add(new rabbit());
	}

	// �ƶ�
	public void setpAction() {

		// �����Ĺ���
		background.roll();

		// �ϰ����ƶ�
		for (Barrier barrier : barrierlist) {
			if (!barrier.isRemove()) {
				barrier.cactusMove();
			}
			int flag = barrier.getFlag();
			if (flag == 1) {
				barrier.move1();
			}
			if (flag == 2) {
				barrier.move2();
			}
			if (flag == 3) {
				barrier.move3();
			}
			if (flag == 4) {
				barrier.move4();
			}
			if (flag == 5) {
				barrier.move5();
			}
			if (flag == 6) {
				barrier.move6();
			}
			if (flag == 7) {
				barrier.move7();
			}
			if (flag == 9) {
				barrier.move9();
			}
			if (flag == 10) {
				barrier.move10();
			}

			if (barrier.isDead()) {
				barrierlist.remove(barrier);
			}

		}

		// ����ƶ�
		for (Coin coin : coin1) {
			if (!coin.isRemove()) {
				coin.cactusMove();
			}
			int flag = coin.getFlag();
			if (flag == 1) {
				coin.move1();
			}
		}

		// bone�ƶ�
		for (Bone bone : bone1) {
			if (!bone.isRemove()) {
				bone.cactusMove();
			}
			int flag = bone.getFlag();
			if (flag == 1) {
				bone.move1();
			}
		}

		// С���ƶ�
		for (xiaobai xiaobai : xiaobai1) {
			if (xiaobai.getX() < 440) {
				xiaobai.cactusMove();
				xiaobai.Stepping();
			} else {
				xiaobai.Stepping();
			}
			if (xiaobai.on == 1) {
				xiaobai1.remove(xiaobai);
			}
		}
		// �����ƶ�
		for (rabbit rabbit : rabbit1) {
			rabbit.cactusMove();
			rabbit.Stepping();
		}

		// �ӵ�1�ƶ�
		for (Bullet bullet : bullets1) {
			if (!bullet.isRemove()) {
				bullet.step();
			}
			if (bullet.isDead()) {
				bullets1.remove(bullet);
			}
		}
		// �ӵ�2�ƶ�
		for (Bullet bullet : bullets2) {
			if (!bullet.isRemove()) {
				bullet.step();
			}
			if (bullet.isDead()) {
				bullets2.remove(bullet);
			}

		}
		// �ӵ�3�ƶ�
		for (Bullet1 bullet : bullets3) {
			if (!bullet.isRemove()) {
				bullet.step();
			}
			if (bullet.isDead()) {
				bullets3.remove(bullet);
			}

		}

		// �ƶ���ɾ�������Ľ���
		for (FireAward award : awardlist) {
			if (!award.isRemove()) {
				award.step();
			}
			if (award.isDead()) {
				awardlist.remove(award);
			}
		}
		// �ƶ���ɾ�������Ľ���
		for (LifeAward lifeAward : lifeAwardlist) {
			if (!lifeAward.isRemove()) {
				lifeAward.step();
			}
			if (lifeAward.isDead()) {
				lifeAwardlist.remove(lifeAward);
			}
		}
	}

	// ��ײ���
	public void CollisionDetection() {

		for (Barrier barrier : barrierlist) {

			if (barrier.getBounds().intersects(dinosaur.getBounds()) && !dinosaur.isRemove() && !barrier.isRemove()) {
				if (protect && !dinosaur.isNbState()) {
					protect = false;
				} else {
					life--;
					if (dinosaur.isNbState()) {
						dinosaur.setNBtimer(0);
					}
				}
				if (life <= 0) {
					dinosaur.setRemove(true);
				}
				barrier.setRemove(2);
			}

			for (xiaobai xiaobai : xiaobai1) {
				if (barrier.getBounds().intersects(xiaobai.getBounds())) {
					barrier.setRemove(2);
				}
			} // С��

			for (rabbit rabbit : rabbit1) {
				if (dinosaur.getBounds().intersects(rabbit.getBounds())) {
					if (protect && !dinosaur.isNbState()) {
						protect = false;
					} else {
						coinnum--;
						if (dinosaur.isNbState()) {
							dinosaur.setNBtimer(0);
						}
					}
				}
			} // ����

			for (Bullet bullet : bullets1) {
				if (barrier.getBounds().intersects(bullet.getBounds()) && !bullet.isRemove() && !barrier.isRemove()) {
					bullet.setRemove(true);
					barrier.setRemove(1);
				}
			}
			for (Bullet bullet : bullets2) {
				if (barrier.getBounds().intersects(bullet.getBounds()) && !bullet.isRemove() && !barrier.isRemove()) {
					bullet.setRemove(true);
					barrier.setRemove(2);
				}
			}
		}

		for (Bullet1 bullet : bullets3) {
			if (dinosaur.getBounds().intersects(bullet.getBounds())) {
				if (protect && !dinosaur.isNbState()) {
					protect = false;
				} else {
					coinnum--;
					if (dinosaur.isNbState()) {
						dinosaur.setNBtimer(0);
					}
				}
				bullet.setRemove(true);

			}
		} // δ����

		for (Coin coin : coin1) {
			if (dinosaur.getBounds().intersects(coin.getBounds())) {
				coin.setRemove(true);
				coinnum++;
			}
		} // ���

		for (Bone bone : bone1) {
			if (dinosaur.getBounds().intersects(bone.getBounds())) {
				bone.setRemove(true);
				bonenum++;
			}
		} // bone

		for (FireAward award : awardlist) {
			if (award.getBounds().intersects(dinosaur.getBounds()) && !award.isRemove()) {
				award.setRemove(true);
				dinosaur.addNBTimer();
				// new Thread(new AudioPlayer(new File("music/��Ч/����ʰȡ2.mp3"), 1)).start();
			}
		}
		for (LifeAward lifeAward : lifeAwardlist) {
			if (lifeAward.getBounds().intersects(dinosaur.getBounds()) && !lifeAward.isRemove()) {
				lifeAward.setRemove(true);
				life += 1;
				// new Thread(new AudioPlayer(new File("music/��Ч/����ʰȡ2.mp3"), 1)).start();
			}
		}

	}

	// ɾ��Խ����ϰ�����ӵ��ͽ���
	public void acrossBorderAction() {
		barrierlist.forEach((barrier) -> {
			if (barrier.acrossBorder()) {
				barrierlist.remove(barrier);
			}
		});
		bullets1.forEach((bullet) -> {
			if (bullet.acrossBorder()) {
				barrierlist.remove(bullet);
			}
		});
		bullets2.forEach((bullet) -> {
			if (bullet.acrossBorder()) {
				barrierlist.remove(bullet);
			}
		});
		awardlist.forEach((award) -> {
			if (award.acrossBorder()) {
				barrierlist.remove(award);
			}
		});
		lifeAwardlist.forEach((award) -> {
			if (award.acrossBorder()) {
				barrierlist.remove(award);
			}
		});

	}

	// �÷��߼�
	public void score() {
		if (scoreTimer >= 500) {
			score += 10;
			scoreTimer = 0;

		}
		scoreTimer += FRESH;
	}

	// ��Ϸ����
	public void gameOver() {
		this.state = GAME_OVER;
		if (score > PropertiesUtil.readScore()) {
			PropertiesUtil.write(score);
		}
	}

	// ��Ϸͨ��
	public void win() {
		this.state = WIN;
		if (score > PropertiesUtil.readScore()) {
			PropertiesUtil.write(score);
		}
	}

	// ��һ��
	public void nextGame() {

		if (coinnum == 30) {
			win();
			try {
				String sql1 = "select * from user where account ='" + Login.account + "'";
				ResultSet rs = DataConnection.getStat().executeQuery(sql1);
				while (rs.next()) {
					bone12 = Integer.parseInt(rs.getString(3));
				}
				bone12 = bone12 + bonenum;

				String sql = "update user set bone='" + bone12 + "'where account ='" + Login.account + "'";
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1:3306/antonio";
				String name = "root";
				String pw = "0000";
				Connection conn = DriverManager.getConnection(url, name, pw);
				Statement statement = conn.createStatement();
				statement.executeUpdate(sql);

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} // ͨ��
	}

	@Override
	public void run() {

		while (true) {
			if (state == RUNNING) {

				setpAction();

				// ������ƶ�
				dinosaur.jumpMove();
				ytnn.jumpMove();
				fjc.jumpMove();
				xiaobai.jumpMove();
				rabbit.jumpMove();

				// Ӣ������
				if (dinosaur.isRemove() && !dinosaur.isNbState()) {
					dinosaur.deadMove1();
				}
				if (dinosaur.isRemove() && dinosaur.isNbState()) {
					dinosaur.deadMove2();
				}

				if (dinosaur.isDead()) {
					gameOver();
				}
				// ��ӽ���
				addAward();
				// �ͷż���
				dinosaur.skillMove();
				// ����ϰ���
				addBarrier();
				// ��ӽ��
				addCoin();
				// ���bone
				addbone();
				// ��ײ���
				CollisionDetection();
				// Խ��ɾ��������������ռ���ڴ�
				acrossBorderAction();
				// �÷��ж�
				score();
				// �ؿ�
				nextGame();
			}

			try {
				Thread.sleep(FRESH);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}

	}

	@Override
	public void paint(Graphics g) {
		// �����ֲ�����ͼ1
		g.drawImage(background.getImage1(), background.getX1(), background.getY(), null);
		// �����ֲ�����ͼ2
		g.drawImage(background.getImage2(), background.getX2(), background.getY(), null);

		// ����С��
		if (state == PAUSE) {
			try {
				g.drawImage(dinosaur.getImage(), dinosaur.getX(), dinosaur.getY(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			g.drawImage(dinosaur.getImage(), dinosaur.getX(), dinosaur.getY(), null);
		}

		// ӣ������
		g.drawImage(ytnn.getImage(), ytnn.getX(), ytnn.getY(), null);

		// ��䳹
		g.drawImage(fjc.getImage(), fjc.getX(), fjc.getY(), null);

		// С��
		for (xiaobai xiaobai : xiaobai1) {
			g.drawImage(xiaobai.getImage(), xiaobai.getX(), xiaobai.getY(), null);
		}

		// ����
		for (rabbit rabbit : rabbit1) {
			g.drawImage(rabbit.getImage(), rabbit.getX(), rabbit.getY(), null);
		}

		// �����
		for (Coin coin : coin1) {

			g.drawImage(coin.getImage(), coin.getX(), coin.getY(), null);
		}

		// ��bone
		for (Bone bone : bone1) {

			g.drawImage(bone.getImage(), bone.getX(), bone.getY(), null);
		}

		// ���ϰ���
		for (Barrier barrier : barrierlist) {

			g.drawImage(barrier.getImage(), barrier.getX(), barrier.getY(), null);
		}
		// ���ӵ�1
		for (Bullet bullet : bullets1) {

			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}

		// ���ӵ�2
		for (Bullet bullet : bullets2) {
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}

		// ���ӵ�3
		for (Bullet1 bullet : bullets3) {
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}

		// ������1
		for (FireAward award : awardlist) {
			g.drawImage(award.getImage(), award.getX(), award.getY(), null);
		}
		// ������2
		for (LifeAward lifeAward : lifeAwardlist) {
			g.drawImage(lifeAward.getImage(), lifeAward.getX(), lifeAward.getY(), null);
		}
		// ���÷�
		g.setColor(Color.GRAY);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		g.drawString("HI", 750, 35);
		g.drawString("LIFE", 750, 55);
		g.drawString("COIN", 840, 55);
		g.drawString("BONE", 750, 75);
		g.drawString(String.format("%05d", +PropertiesUtil.readScore()), 780, 35);
		g.drawString(String.format("%05d", score), 840, 35);
		g.drawString(life + "", 800, 55);
		g.drawString(coinnum + "", 890, 55);
		g.drawString(bonenum + "", 800, 75);

		// ��������
		if (protect && !dinosaur.isNbState()) {
			g.drawImage(dinosaur.getImage60(), dinosaur.getX() - 25, dinosaur.getY() - 18, 130, 130, null);
		}
		// ״̬��־ͼ
		try {
			switch (state) {
			case START: {

				g.drawImage(background.getImage_start(), 367, 90, 248, 150, null);

				break;
			}
			case PAUSE: {
				g.drawImage(background.getImage_pause(), 400, 80, 160, 160, null);
				break;
			}
			case GAME_OVER: {
				g.drawImage(background.getImage_over(), 380, 100, null);
				break;
			}
			case WIN: {
				g.drawImage(background.getImage_win(), 380, 100, null);
				break;
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public lbxx getDinosaur() {
		return dinosaur;
	}

	public xiaobai getxiaobai() {
		return xiaobai;
	}

	public ytnn getytnn() {
		return ytnn;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLeave() {
		return leave;
	}

	// ����
	public void rebirth() {
		background = new Background();
		dinosaur = new lbxx();
		barrierlist = new CopyOnWriteArrayList<Barrier>();
		bullets1 = new CopyOnWriteArrayList<Bullet>();
		bullets2 = new CopyOnWriteArrayList<Bullet>();
		score = 0;
		leave = 0;
		awardlist = new CopyOnWriteArrayList<FireAward>();
		lifeAwardlist = new CopyOnWriteArrayList<LifeAward>();
		life = 3;
		coinnum = 0;
		bonenum = 0;
		protect = false;
	}

}
