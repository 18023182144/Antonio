
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	int xOld = 0;
	int yOld = 0;

	private JPanel contentPane;

	//private JTextField textField;
	static JTextField textField;
	private JPasswordField passwordField;

	static final String INFO_1 = "Account";
	static final String INFO_2 = "Password";
	static char defaultChar;
	
	private int state;
	static String account;

	public Login() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();
				yOld = e.getY();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				Login.this.setLocation(xx, yy);
			}
		});

		setSize(250, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		contentPane.setBackground(new Color(246, 248, 250));

		String url = "C:\\Users\\Unicorn\\Desktop\\素材\\sword.png";
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon(url).getImage();
		Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
		contentPane.setCursor(cursor);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 30));
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		panel.setBackground(new Color(246, 248, 250));
		contentPane.add(panel);

		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon("C:\\Users\\Unicorn\\Desktop\\素材\\关闭2.png"));
		closeButton.setPreferredSize(new Dimension(30, 30));
		// closeButton.setBackground(new Color(243, 243, 243));
		closeButton.setBorder(null);
		closeButton.setContentAreaFilled(false);
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				String url = "C:\\Users\\Unicorn\\Desktop\\素材\\Pickaxe.png";
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image image = new ImageIcon(url).getImage();
				Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
				contentPane.setCursor(cursor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				String url = "C:\\Users\\Unicorn\\Desktop\\素材\\sword.png";
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image image = new ImageIcon(url).getImage();
				Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
				contentPane.setCursor(cursor);
			}

		});
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.exit(0);
				dispose();
			}
		});
		panel.add(closeButton);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 40));
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField.setText(INFO_1);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBorder(BorderFactory.createLineBorder(new Color(225, 228, 232), 1));
		contentPane.add(textField);

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {// 失去焦点的时候
				if (textField.getText().trim().equals("")) {// 如果没有任何输入 ,就提示用户输入
					textField.setText(INFO_1);
					textField.setForeground(Color.LIGHT_GRAY);
					textField.setBorder(new MatteBorder(1, 1, 1, 1, new Color(192, 192, 192)));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {// 获得焦点的时候
				if (textField.getText().trim().equals(INFO_1)) {// 如果是提示文字 ,就清空提示文字
					textField.setText("");
					textField.setForeground(Color.BLACK);
					textField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(192, 192, 192)));
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_1.setPreferredSize(new Dimension(200, 40));
		panel_1.setBorder(BorderFactory.createLineBorder(new Color(225, 228, 232), 1));
		contentPane.add(panel_1);

		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(159, 38));
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		defaultChar = passwordField.getEchoChar();
		passwordField.setEchoChar('\0');
		passwordField.setText(INFO_2);
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setBorder(null);
		panel_1.add(passwordField);

		passwordField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {// 失去焦点的时候
				String pswd = new String(passwordField.getPassword()).trim();
				if (pswd.equals("")) {// 如果没有输入密码. 就用明文 提示用户输入密码
					passwordField.setEchoChar('\0');
					passwordField.setText(INFO_2);
					passwordField.setForeground(Color.LIGHT_GRAY);
					panel_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(192, 192, 192)));
				}
			}

			@Override
			public void focusGained(FocusEvent e) {// 获得焦点的时候
				String pswd = new String(passwordField.getPassword()).trim();
				if (pswd.equals(INFO_2)) {// 如果是密码提示文字 ,那么就清空文字, 并设置密文显示
					passwordField.setText("");
					passwordField.setEchoChar(defaultChar);
					passwordField.setForeground(Color.BLACK);
					panel_1.setBorder(new MatteBorder(0, 0, 1, 0, new Color(192, 192, 192)));
				}
			}

		});

		JButton button = new JButton("👁");
		button.setPreferredSize(new Dimension(39, 38));
		button.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		button.setForeground(Color.GRAY);
		button.setBackground(new Color(255, 255, 255));
		button.setBorder(null);
		button.setFocusPainted(false);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			boolean flag = false;

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button && flag == false) {
					flag = true;
					passwordField.setEchoChar('\0');
				} else if (flag == true) {
					passwordField.setEchoChar(defaultChar);
					flag = false;
				}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			boolean flag = false;

			public void mousePressed(MouseEvent e) {
				if (e.getSource() == button && !flag) {
					flag = true;
					button.setForeground(Color.BLACK);
				} else
					flag = false;

			}

			public void mouseReleased(MouseEvent e) {
				if (e.getSource() == button && !flag) {
					button.setForeground(Color.GRAY);
				}
			}
		});

		button login = new button();
		login.setPreferredSize(new Dimension(96, 40));
		login.setText("🎮 Sign in");
		login.setBackground(new Color(46, 164, 79));
		login.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		login.setForeground(Color.WHITE);
		login.setFocusPainted(false);
		login.setBorder(null);
		contentPane.add(login);
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				
				try {
					Client c = new Client();
					account = textField.getText();
					String password = passwordField.getText();
					boolean b = c.login(account, password);
					if (b) {
						JOptionPane.showMessageDialog(null, "登录成功");
						online frame = new online();
						frame.setUndecorated(true);
						frame.setVisible(true);
						setVisible(false);
					} else
						JOptionPane.showMessageDialog(null, "登陆失败");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		state=1;

		button register = new button();
		register.setPreferredSize(new Dimension(96, 40));
		register.setText("🖊 register");
		register.setBackground(Color.WHITE);
		register.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		register.setForeground(Color.BLACK);
		register.setFocusPainted(false);
		register.setBorder(null);
		contentPane.add(register);

		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Client c = new Client();
					String account = textField.getText();
					String password = passwordField.getText();
					String b = c.register(account, password);
					JOptionPane.showMessageDialog(null, b);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		button offline = new button();
		offline.setPreferredSize(new Dimension(200, 35));
		offline.setText(
				"<html><body><span style='color :black; font-size:12px;'>🦾 </span><span style='color :gray; font-size:12px;'>offline</span></body></html>");
		offline.setBackground(Color.WHITE);
		offline.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 17));
		offline.setForeground(Color.BLACK);
		offline.setFocusPainted(false);
		offline.setBorder(null);
		contentPane.add(offline);
		offline.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				offline frame = new offline();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}

		});
	}
	
	public int getstate() {
		return state;
	}

	public static void main(String[] args) {
		Login frame = new Login();
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

}
