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

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements Runnable {
	private Background1 background;// 背景对象
	private xiaobai1 xiaobai;// 对象

	private CopyOnWriteArrayList<Barrier1> barrierlist;

	public static final int FRESH = 100; // 刷新时间，单位 毫秒
	private int barrierTimer = 0; // 添加障碍计时器
	private int awardTimer1 = 0; // 添加奖励计时器
	private int awardTimer2 = 0; // 添加奖励计时器
	private int awardTimer3 = 0; // 添加奖励计时器
	private int scoreTimer = 0; // 分数计时器
	private int score = 0; // 得分

	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;// 游戏标志
	private int leave = 0;// 背景图选择标志
	int bone12;

	public MyPanel() {
		background = new Background1();
		xiaobai = new xiaobai1();
		barrierlist = new CopyOnWriteArrayList<Barrier1>();
	}

	// 添加障碍物
	public void addBarrier() {

		if (barrierTimer >= 2000) {// 每两秒添加一个障碍
			Random r = new Random();
			if ((r.nextInt(100)) > 40) { // 每次都是两秒出现一次障碍 太固定，来个随机数让每过两秒也可能不出现障碍
				this.barrierlist.add(new Barrier1());
			}
			barrierTimer = 0; // 计时器归零
		}

		barrierTimer += FRESH; // 添加障碍计时器记时

	}

	// 移动
	public void setpAction() {

		// 背景的滚动
		background.roll();
		// 障碍物移动
		for (Barrier1 barrier : barrierlist) {

				barrier.cactusMove();// 前进

			// 6种敌人障碍自己的动作切换
			int flag = barrier.getFlag();// 切换刷新当前所需图片即可
			if (flag == 1) {
				// barrier.move1();
			}
			if (flag == 2) {
				// barrier.move2();
			}
			if (flag == 3) {
				// barrier.move3();
			}
			if (flag == 4) {
				barrier.move1();
			}
			if (flag == 5) {
				barrier.move2();
			}
		}
	}

	// 碰撞检测
	public void CollisionDetection() {

		for (Barrier1 barrier : barrierlist) {

			if (barrier.getBounds().intersects(xiaobai.getBounds())) {// 英雄和敌人撞
				// 撞到并且是未删除状态->改为删除状态（这里不能直接结束游戏，因为英雄的死亡动画还没有播放）

				gameOver();// 英雄改为删除状态

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
	}

	// 得分逻辑
	public void score() {
		// 分数 500得10分
		if (scoreTimer >= 500) {
			score += 10;
			scoreTimer = 0;

		}

		// 500分一关暂时
		if (score >= 500 && score <= 1000) {
			leave = 2;
		}

		if (score > 1000 && score < 2000) {
			leave = 4;
		}

		// 刷新得分计时器
		scoreTimer += FRESH;
	}

	// 游戏结束
	public void gameOver() {
		this.state = GAME_OVER;
//		if (score > PropertiesUtil.readScore()) { // 判断最高得分
//			PropertiesUtil.write(score);
//		}
		try {
			String sql1 = "select * from user where account ='" + Login.account + "'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql1);
			while (rs.next()) {
				bone12 = Integer.parseInt(rs.getString(3));
			}
			bone12 = bone12 + score / 100;

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
	}

	@Override
	public void run() {

		while (true) {
			if (state == RUNNING) {

				setpAction();

				// 恐龙的移动
				xiaobai.jumpMove();

				if (xiaobai.isDead()) {// 符合标记（表示播放完死亡画面，结束游戏）
					gameOver();
				}

				// 添加障碍物
				addBarrier();
				// 碰撞检测
				CollisionDetection();
				// 越界删除以免垃圾过多占用内存
				acrossBorderAction();
				// 得分判断
				score();

			}
			repaint();
			try {
				Thread.sleep(FRESH);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 画主轮播背景图1
		g.drawImage(background.getImage1(), background.getX1(), background.getY(), null);
		// 画主轮播背景图2
		g.drawImage(background.getImage2(), background.getX2(), background.getY(), null);
//		// 画背景图上的云彩1
//		g.drawImage(background.getImage_yun1(), background.getX_yun1(), background.getY_yun1(), null);
//		// 画背景图上的云彩2
//		g.drawImage(background.getImage_yun2(), background.getX_yun2(), background.getY_yun2(), null);

		// 画恐龙
		if (state == PAUSE) {
			try {// 画呆呆暂停的恐龙
				g.drawImage(xiaobai.getImage(), xiaobai.getX(), xiaobai.getY(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			g.drawImage(xiaobai.getImage(), xiaobai.getX(), xiaobai.getY(), null);// 画活恐龙
		}

		// 画障碍物
		for (Barrier1 barrier : barrierlist) {

			g.drawImage(barrier.getImage(), barrier.getX(), barrier.getY(), null);
		}

		// 画得分
		g.setColor(Color.GRAY);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));// 字体随意找了一个 加粗"
		g.drawString("HI", 600, 35);
		// g.drawString(String.format("%05d", +PropertiesUtil.readScore()), 780, 35);//
		// %05d 五位数，没有五位前面补0
		g.drawString(String.format("%05d", score), 640, 35);

		// 状态标志图
		try {
			switch (state) {
			case GAME_OVER: {
				g.drawImage(background.getImage_over(), 250, 70, null);
				break;
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public xiaobai1 getxiaobai() {
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
		background = new Background1();
		xiaobai = new xiaobai1();
		barrierlist = new CopyOnWriteArrayList<Barrier1>();
		score = 0;
		leave = 0;
	}

}
