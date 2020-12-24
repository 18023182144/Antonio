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

public class Level1 extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private Background background;
	private lbxx dinosaur;
	private Mom mom;
	private Coin coin;
	private Bone bone;
	private xiaobai xiaobai;
	private SchoolBus schoolbus;

	private CopyOnWriteArrayList<Bullet> bullets1; // 子弹
	private CopyOnWriteArrayList<Bullet> bullets2; // 子弹
	private CopyOnWriteArrayList<Bullet1> bullets3;// 子弹
	private CopyOnWriteArrayList<Coin> coin1;
	private CopyOnWriteArrayList<Bone> bone1;
	private CopyOnWriteArrayList<xiaobai> xiaobai1;
	private CopyOnWriteArrayList<Barrier> barrierlist;
	private CopyOnWriteArrayList<FireAward> awardlist;
	private CopyOnWriteArrayList<LifeAward> lifeAwardlist;

	public static final int FRESH = 100;
	private int barrierTimer = 0;
	private int coinTimer = 0;// 金币出生时间
	private int boneTimer = 0;// bone出生时间
	private int awardTimer1 = 0; // 添加奖励计时器
	private int awardTimer2 = 0; // 添加奖励计时器
	private int awardTimer3 = 0; // 添加奖励计时器
	private int scoreTimer = 0; // 分数计时器
	private int score = 0; // 得分

	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	public static final int WIN = 4;
	private int state = START;// 游戏标志
	private int leave = 0;// 背景图选择标志

	private int life = 3;// 命
	private int coinnum = 0;// 金币
	private int bonenum = 0;// bone

	private boolean protect = false;// 保护罩
	int bone12;

	public Level1() {
		background = new Background();
		dinosaur = new lbxx();
		mom = new Mom();
		coin = new Coin();
		bone = new Bone();
		schoolbus = new SchoolBus();
		xiaobai = new xiaobai();
		barrierlist = new CopyOnWriteArrayList<Barrier>();
		coin1 = new CopyOnWriteArrayList<Coin>();
		bone1 = new CopyOnWriteArrayList<Bone>();
		xiaobai1 = new CopyOnWriteArrayList<xiaobai>();
		bullets1 = new CopyOnWriteArrayList<Bullet>();
		bullets2 = new CopyOnWriteArrayList<Bullet>();
		bullets3 = new CopyOnWriteArrayList<Bullet1>();
		awardlist = new CopyOnWriteArrayList<FireAward>();
		lifeAwardlist = new CopyOnWriteArrayList<LifeAward>();
	}

	// 奖励掉落
	public void addAward() {

		if (awardTimer1 >= 10000) {// 每10秒添加超人徽章
			System.out.println("超人");

			awardlist.add(new FireAward());

			awardTimer1 = 0; // 计时器归零
		}
		if (awardTimer2 >= 30000) {// 每30秒添加命
			lifeAwardlist.add(new LifeAward());
			awardTimer2 = 0; // 计时器归零
			System.out.println("药");
		}

		if (awardTimer3 >= 30000 && !dinosaur.isNbState()) {// 30s一个保护罩(变身状态下不给)
			protect = true;
			awardTimer3 = 0;
		}

		if (MainFrame.on == 1 && !dinosaur.isNbState()) {// 召唤小白生成保护罩
			protect = true;
			MainFrame.on = 2;
		}

		awardTimer1 += FRESH; // 添加障碍计时器记时

		awardTimer2 += FRESH; // 添加障碍计时器记时

		if (!dinosaur.isNbState()) {// 普通状态下才随机生成保护罩
			awardTimer3 += FRESH; // 添加障碍计时器记时
		}

	}

	// 技能一
	public void addBullet1() {

		this.bullets1.add(dinosaur.shoot(1));

	}

	// 变身后技能
	public void addBullet2() {

		this.bullets2.add(dinosaur.shoot(2));
	}

	// 野原美伢技能
	public void addBullet12() {

		this.bullets3.add(mom.shoot(1));

	}

	// 添加障碍物
	public void addBarrier() {

		if (barrierTimer >= 2000) {// 每两秒添加一个障碍
			Random r = new Random();
			if ((r.nextInt(100)) > 40) { // 随机数每过两秒也可能不出现障碍
				this.barrierlist.add(new Barrier());
			}
			barrierTimer = 0; // 计时器归零
		}

		barrierTimer += FRESH; // 添加障碍计时器记时

	}

	// 金币
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

	// 小白
	public void addxiaobai() {

		this.xiaobai1.add(new xiaobai());

	}

	// 移动
	public void setpAction() {

		// 背景的滚动
		background.roll();

		// 障碍物移动
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

		// 金币移动
		for (Coin coin : coin1) {
			if (!coin.isRemove()) {
				coin.cactusMove();
			}
			int flag = coin.getFlag();
			if (flag == 1) {
				coin.move1();
			}
		}

		// bone移动
		for (Bone bone : bone1) {
			if (!bone.isRemove()) {
				bone.cactusMove();
			}
			int flag = bone.getFlag();
			if (flag == 1) {
				bone.move1();
			}
		}

		// 小白移动
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

		// 子弹1移动
		for (Bullet bullet : bullets1) {
			if (!bullet.isRemove()) {
				bullet.step();
			}
			if (bullet.isDead()) {
				bullets1.remove(bullet);
			}
		}
		// 子弹2移动
		for (Bullet bullet : bullets2) {
			if (!bullet.isRemove()) {
				bullet.step();
			}
			if (bullet.isDead()) {
				bullets2.remove(bullet);
			}

		}
		// 子弹3移动
		for (Bullet1 bullet : bullets3) {
			if (!bullet.isRemove()) {
				bullet.step();
			}
			if (bullet.isDead()) {
				bullets3.remove(bullet);
			}

		}

		// 移动和删除死亡的奖励
		for (FireAward award : awardlist) {
			if (!award.isRemove()) {
				award.step();
			}
			if (award.isDead()) {
				awardlist.remove(award);
			}
		}
		// 移动和删除死亡的奖励
		for (LifeAward lifeAward : lifeAwardlist) {
			if (!lifeAward.isRemove()) {
				lifeAward.step();
			}
			if (lifeAward.isDead()) {
				lifeAwardlist.remove(lifeAward);
			}
		}
	}

	// 碰撞检测
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
			} // 小白

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
		} // 未完善

		for (Coin coin : coin1) {
			if (dinosaur.getBounds().intersects(coin.getBounds())) {
				coin.setRemove(true);
				coinnum++;
			}
		} // 金币

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
			}
		}
		for (LifeAward lifeAward : lifeAwardlist) {
			if (lifeAward.getBounds().intersects(dinosaur.getBounds()) && !lifeAward.isRemove()) {
				lifeAward.setRemove(true);
				life += 1;
			}
		}

	}

	// 删除越界的障碍物和子弹和奖励
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

	// 得分
	public void score() {
		if (scoreTimer >= 500) {
			score += 10;
			scoreTimer = 0;
		}
		scoreTimer += FRESH;
	}

	// 游戏结束
	public void gameOver() {
		this.state = GAME_OVER;
		if (score > PropertiesUtil.readScore()) {
			PropertiesUtil.write(score);
		}
	}

	// 游戏通关
	public void win() {
		this.state = WIN;
		if (score > PropertiesUtil.readScore()) {
			PropertiesUtil.write(score);
		}
	}

	// 下一关
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

		} // 通关
	}

	@Override
	public void run() {

		while (true) {
			if (state == RUNNING) {

				setpAction();

				// 人物的移动
				dinosaur.jumpMove();
				mom.jumpMove();
				schoolbus.jumpMove();
				xiaobai.jumpMove();

				// 英雄死亡
				if (dinosaur.isRemove() && !dinosaur.isNbState()) {
					dinosaur.deadMove1();
				}
				if (dinosaur.isRemove() && dinosaur.isNbState()) {
					dinosaur.deadMove2();
				}

				if (dinosaur.isDead()) {
					gameOver();
				}
				// 添加奖励
				addAward();
				// 释放技能
				dinosaur.skillMove();
				// 添加障碍物
				addBarrier();
				// 添加金币
				addCoin();
				// 添加bone
				addbone();
				// 碰撞检测
				CollisionDetection();
				// 越界删除以免垃圾过多占用内存
				acrossBorderAction();
				// 得分判断
				score();
				// 关卡
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
		// 画主轮播背景图1
		g.drawImage(background.getImage1(), background.getX1(), background.getY(), null);
		// 画主轮播背景图2
		g.drawImage(background.getImage2(), background.getX2(), background.getY(), null);

		// 画蜡笔小新
		if (state == PAUSE) {
			try {
				g.drawImage(dinosaur.getImage(), dinosaur.getX(), dinosaur.getY(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			g.drawImage(dinosaur.getImage(), dinosaur.getX(), dinosaur.getY(), null);
		}
		// 野原美伢
		g.drawImage(mom.getImage(), mom.getX(), mom.getY(), null);

		// 校巴
		g.drawImage(schoolbus.getImage(), schoolbus.getX(), schoolbus.getY(), null);

		// 小白
		for (xiaobai xiaobai : xiaobai1) {
			g.drawImage(xiaobai.getImage(), xiaobai.getX(), xiaobai.getY(), null);
		}

		// 画金币
		for (Coin coin : coin1) {

			g.drawImage(coin.getImage(), coin.getX(), coin.getY(), null);
		}

		// 画bone
		for (Bone bone : bone1) {

			g.drawImage(bone.getImage(), bone.getX(), bone.getY(), null);
		}

		// 画障碍物
		for (Barrier barrier : barrierlist) {

			g.drawImage(barrier.getImage(), barrier.getX(), barrier.getY(), null);
		}
		// 画子弹1
		for (Bullet bullet : bullets1) {

			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}

		// 画子弹2
		for (Bullet bullet : bullets2) {
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}

		// 画子弹3
		for (Bullet1 bullet : bullets3) {
			g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}

		// 画奖励1
		for (FireAward award : awardlist) {
			g.drawImage(award.getImage(), award.getX(), award.getY(), null);
		}
		// 画奖励2
		for (LifeAward lifeAward : lifeAwardlist) {
			g.drawImage(lifeAward.getImage(), lifeAward.getX(), lifeAward.getY(), null);
		}
		// 画得分
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

		// 画保护罩
		if (protect && !dinosaur.isNbState()) {
			g.drawImage(dinosaur.getImage60(), dinosaur.getX() - 25, dinosaur.getY() - 18, 130, 130, null);
		}
		// 状态标志图
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

	public Mom getmom() {
		return mom;
	}

	public xiaobai getxiaobai() {
		return xiaobai;
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

	// 重生
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
