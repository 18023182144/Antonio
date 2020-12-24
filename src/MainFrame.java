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
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Level1 myPanel;
	private static AtomicBoolean isHappened = new AtomicBoolean(false);
	static int on;

	public MainFrame() {
		myPanel = new Level1();

		add(myPanel);
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
					if (!myPanel.getDinosaur().isNbState()) {
						if (myPanel.getScore() >= 50) {// 50块钱一发
							myPanel.getDinosaur().skill1();
							myPanel.addBullet1();
							myPanel.setScore(myPanel.getScore() - 50);
						}
					}
				}

				if (code == 68) {// d 技能二 （变身后）
					if (myPanel.getDinosaur().isNbState()) {
						if (myPanel.getScore() >= 50) {// 50块钱一发
							myPanel.getDinosaur().skill2();
							myPanel.addBullet2();
							myPanel.setScore(myPanel.getScore() - 50);
						}
					}
				}

				if (code == 65) {// a 动感超人
					if (myPanel.getDinosaur().getNBtimer() >= 10) {// 第二关之后才可以变身
						myPanel.getDinosaur().superhero();
					}
				}

				if (code == 75) {// k 起跳
					myPanel.getDinosaur().jump(); // 改变跳跃标志位
					if (myPanel.getDinosaur().isNbState()) {
					} else {
					}
				}

				if (code == 87) {// w 小白
					if (!myPanel.getxiaobai().iscallState() && isHappened.compareAndSet(false, true)) {
						myPanel.addxiaobai();
						on = 1;
					}
				}

				if (code == 10) { // 回车 暂停
					if (myPanel.getState() == Level1.RUNNING) {
						myPanel.setState(Level1.PAUSE);
						return;
					}
				}

				if (code == 10) { // 回车 开始
					if (myPanel.getState() == Level1.PAUSE) {
						myPanel.setState(Level1.RUNNING);
						return;
					}
				}
			}

		});

		MouseAdapter m = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 开始游戏
				if (myPanel.getState() == Level1.START) {
					myPanel.setState(Level1.RUNNING);

					// AI
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							Random r = new Random();
							int random = r.nextInt(10);
							System.out.println(random);
							if (random == 1) {
								myPanel.addBullet12();
							}
						}
					}, 0L, 1000L);

				}
				if (myPanel.getState() == Level1.GAME_OVER) {
					myPanel.setState(Level1.START);
					// 死亡之后单机即可重生
					myPanel.rebirth();
					isHappened.compareAndSet(true, false);
				}
			}
		};

		this.addMouseListener(m);
		this.addMouseMotionListener(m);

		new Thread(myPanel).start();
	}

	public Level1 getMyPanel() {
		return myPanel;
	}

}
