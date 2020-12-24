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
	private Background1 background;// ��������
	private xiaobai1 xiaobai;// ����

	private CopyOnWriteArrayList<Barrier1> barrierlist;

	public static final int FRESH = 100; // ˢ��ʱ�䣬��λ ����
	private int barrierTimer = 0; // ����ϰ���ʱ��
	private int awardTimer1 = 0; // ��ӽ�����ʱ��
	private int awardTimer2 = 0; // ��ӽ�����ʱ��
	private int awardTimer3 = 0; // ��ӽ�����ʱ��
	private int scoreTimer = 0; // ������ʱ��
	private int score = 0; // �÷�

	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;// ��Ϸ��־
	private int leave = 0;// ����ͼѡ���־
	int bone12;

	public MyPanel() {
		background = new Background1();
		xiaobai = new xiaobai1();
		barrierlist = new CopyOnWriteArrayList<Barrier1>();
	}

	// ����ϰ���
	public void addBarrier() {

		if (barrierTimer >= 2000) {// ÿ�������һ���ϰ�
			Random r = new Random();
			if ((r.nextInt(100)) > 40) { // ÿ�ζ����������һ���ϰ� ̫�̶��������������ÿ������Ҳ���ܲ������ϰ�
				this.barrierlist.add(new Barrier1());
			}
			barrierTimer = 0; // ��ʱ������
		}

		barrierTimer += FRESH; // ����ϰ���ʱ����ʱ

	}

	// �ƶ�
	public void setpAction() {

		// �����Ĺ���
		background.roll();
		// �ϰ����ƶ�
		for (Barrier1 barrier : barrierlist) {

				barrier.cactusMove();// ǰ��

			// 6�ֵ����ϰ��Լ��Ķ����л�
			int flag = barrier.getFlag();// �л�ˢ�µ�ǰ����ͼƬ����
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

	// ��ײ���
	public void CollisionDetection() {

		for (Barrier1 barrier : barrierlist) {

			if (barrier.getBounds().intersects(xiaobai.getBounds())) {// Ӣ�ۺ͵���ײ
				// ײ��������δɾ��״̬->��Ϊɾ��״̬�����ﲻ��ֱ�ӽ�����Ϸ����ΪӢ�۵�����������û�в��ţ�

				gameOver();// Ӣ�۸�Ϊɾ��״̬

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
	}

	// �÷��߼�
	public void score() {
		// ���� 500��10��
		if (scoreTimer >= 500) {
			score += 10;
			scoreTimer = 0;

		}

		// 500��һ����ʱ
		if (score >= 500 && score <= 1000) {
			leave = 2;
		}

		if (score > 1000 && score < 2000) {
			leave = 4;
		}

		// ˢ�µ÷ּ�ʱ��
		scoreTimer += FRESH;
	}

	// ��Ϸ����
	public void gameOver() {
		this.state = GAME_OVER;
//		if (score > PropertiesUtil.readScore()) { // �ж���ߵ÷�
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

				// �������ƶ�
				xiaobai.jumpMove();

				if (xiaobai.isDead()) {// ���ϱ�ǣ���ʾ�������������棬������Ϸ��
					gameOver();
				}

				// ����ϰ���
				addBarrier();
				// ��ײ���
				CollisionDetection();
				// Խ��ɾ��������������ռ���ڴ�
				acrossBorderAction();
				// �÷��ж�
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
		// �����ֲ�����ͼ1
		g.drawImage(background.getImage1(), background.getX1(), background.getY(), null);
		// �����ֲ�����ͼ2
		g.drawImage(background.getImage2(), background.getX2(), background.getY(), null);
//		// ������ͼ�ϵ��Ʋ�1
//		g.drawImage(background.getImage_yun1(), background.getX_yun1(), background.getY_yun1(), null);
//		// ������ͼ�ϵ��Ʋ�2
//		g.drawImage(background.getImage_yun2(), background.getX_yun2(), background.getY_yun2(), null);

		// ������
		if (state == PAUSE) {
			try {// ��������ͣ�Ŀ���
				g.drawImage(xiaobai.getImage(), xiaobai.getX(), xiaobai.getY(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			g.drawImage(xiaobai.getImage(), xiaobai.getX(), xiaobai.getY(), null);// �������
		}

		// ���ϰ���
		for (Barrier1 barrier : barrierlist) {

			g.drawImage(barrier.getImage(), barrier.getX(), barrier.getY(), null);
		}

		// ���÷�
		g.setColor(Color.GRAY);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 15));// ������������һ�� �Ӵ�"
		g.drawString("HI", 600, 35);
		// g.drawString(String.format("%05d", +PropertiesUtil.readScore()), 780, 35);//
		// %05d ��λ����û����λǰ�油0
		g.drawString(String.format("%05d", score), 640, 35);

		// ״̬��־ͼ
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

	// ����
	public void rebirth() {
		background = new Background1();
		xiaobai = new xiaobai1();
		barrierlist = new CopyOnWriteArrayList<Barrier1>();
		score = 0;
		leave = 0;
	}

}
