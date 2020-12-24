import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;

//主窗体
public class MainFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;

	private Level2 level2;
	private static AtomicBoolean isHappened = new AtomicBoolean(false);
	static int on;

	public MainFrame1() {
		level2 = new Level2();

		add(level2);
		setSize(983, 420);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		// 事件监听
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == 83) {// s 技能一 （变身前）
					if (!level2.getDinosaur().isNbState()) {
						if (level2.getScore() >= 50) {// 50块钱一发
							level2.getDinosaur().skill1();
							level2.addBullet1();
							level2.setScore(level2.getScore() - 50);
						}
					}
				}

				if (code == 68) {// d 技能二 （变身后）
					if (level2.getDinosaur().isNbState()) {
						if (level2.getScore() >= 50) {// 50块钱一发
							level2.getDinosaur().skill2();
							level2.addBullet2();
							level2.setScore(level2.getScore() - 50);
						}
					}
				}

				if (code == 65) {// a 动感超人
					if (level2.getDinosaur().getNBtimer() >= 10) {
						level2.getDinosaur().superhero();
					}
				}

				if (code == 75) {// k 起跳
					level2.getDinosaur().jump(); // 改变跳跃标志位
					if (level2.getDinosaur().isNbState()) {
					} else {
					}
				}

				if (code == 87) {// w 小白
					if (!level2.getxiaobai().iscallState() && isHappened.compareAndSet(false, true)) {
						level2.addxiaobai();
						on = 1;
					}
				}

				if (code == 10) { // 回车 暂停
					if (level2.getState() == Level1.RUNNING) {
						level2.setState(Level1.PAUSE);
						return;
					}
				}

				if (code == 10) { // 回车 开始
					if (level2.getState() == Level1.PAUSE) {
						level2.setState(Level1.RUNNING);
						return;
					}
				}
			}

		});

		MouseAdapter m = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 开始游戏
				if (level2.getState() == Level1.START) {
					level2.setState(Level1.RUNNING);

					// AI
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							Random r = new Random();
							int random = r.nextInt(10);
							System.out.println(random);
							if (random == 3) {
								level2.addrabbit();
							}
						}
					}, 0L, 1000L);

				}
				if (level2.getState() == Level1.GAME_OVER) {
					level2.setState(Level1.START);
					// 死亡之后单机即可重生
					level2.rebirth();
					isHappened.compareAndSet(true, false);
				}
			}
		};

		this.addMouseListener(m);
		this.addMouseMotionListener(m);

		new Thread(level2).start();
	}

	public Level2 getLevel2() {
		return level2;
	}

}
