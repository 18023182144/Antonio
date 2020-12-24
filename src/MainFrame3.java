import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MainFrame3 extends JFrame {

	private static final long serialVersionUID = 1L;

	private MyPanel myPanel;

	public MainFrame3() {
		myPanel = new MyPanel();
		add(myPanel);

		setSize(734, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		// 添加事件监听
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code == 32) {// 空格 起跳
					myPanel.getxiaobai().jump();
					myPanel.setState(MyPanel.RUNNING);
				}
			}

		});

		MouseAdapter m = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (myPanel.getState() == MyPanel.GAME_OVER) {
					myPanel.setState(MyPanel.START);
					myPanel.rebirth();

				}
			}
		};

		this.addMouseListener(m);
		this.addMouseMotionListener(m);

		new Thread(myPanel).start();
	}

	public MyPanel getMyPanel() {
		return myPanel;
	}
}
