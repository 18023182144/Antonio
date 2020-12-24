import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicMenuItemUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Frame;

public class online extends JFrame {

	private static final long serialVersionUID = 1L;

	int xOld = 0;
	int yOld = 0;

	private JPanel contentPane;
	int bone;
	int Callingtime;
	Login login;

	public online() {
		login = new Login();

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
				online.this.setLocation(xx, yy);
			}
		});

		setSize(680, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		String url = "image\\素材\\sword.png";
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon(url).getImage();
		Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
		contentPane.setCursor(cursor);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		panel.setPreferredSize(new Dimension(680, 40));
		contentPane.add(panel);

		JLabel time = new JLabel("");
		time.setPreferredSize(new Dimension(595, 40));
		panel.add(time);

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH");
		String str = df.format(date);
		int a = Integer.parseInt(str);
		if (a >= 6 && a <= 17) {
			time.setIcon(new ImageIcon("image\\素材\\太阳.png"));
		}
		if (a >= 18 && a <= 24) {
			time.setIcon(new ImageIcon("image\\素材\\猫头鹰.png"));
		}

		JButton minimizeButton = new JButton("—");
		minimizeButton.setPreferredSize(new Dimension(40, 40));
		minimizeButton.setFont(new Font("Dialog", Font.PLAIN, 11));
		minimizeButton.setBackground(new Color(243, 243, 243));
		minimizeButton.setBorder(null);
		minimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				minimizeButton.setText("_");
				minimizeButton.setFont(new Font("幼圆", Font.PLAIN, 21));
				minimizeButton.setForeground(new Color(6, 167, 255));
				minimizeButton.setBackground(new Color(229, 229, 229));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				minimizeButton.setText("—");
				minimizeButton.setFont(new Font("Dialog", Font.PLAIN, 11));
				minimizeButton.setForeground(Color.black);
				minimizeButton.setBackground(new Color(243, 243, 243));
			}

		});

		minimizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		panel.add(minimizeButton);

		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon("image\\素材\\关闭2.png"));
		closeButton.setPreferredSize(new Dimension(40, 40));
		closeButton.setBackground(new Color(243, 243, 243));
		closeButton.setBorder(null);
		panel.add(closeButton);

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				String url = "image\\素材\\Pickaxe.png";
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image image = new ImageIcon(url).getImage();
				Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
				contentPane.setCursor(cursor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				String url = "image\\素材\\sword.png";
				Toolkit tk = Toolkit.getDefaultToolkit();
				Image image = new ImageIcon(url).getImage();
				Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
				contentPane.setCursor(cursor);
			}

		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_1.setPreferredSize(new Dimension(680, 330));
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
		panel_2.setPreferredSize(new Dimension(680, 40));
		panel_1.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("🦴");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		lblNewLabel_1.setPreferredSize(new Dimension(40, 40));
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		// lblNewLabel_2.setText(Integer.toString(bone));
		try {
			String abc = Login.account;
			String sql = "select * from user where account ='" + abc + "'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			while (rs.next()) {
				bone = Integer.parseInt(rs.getString(3));
			}
			if (login.getstate() == 1) {
				// lblNewLabel_2.setText(Integer.toString(bone));
				lblNewLabel_2.setText(Integer.toString(bone));
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		lblNewLabel_2.setPreferredSize(new Dimension(40, 40));
		panel_2.add(lblNewLabel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
		panel_4.setPreferredSize(new Dimension(340, 330));
		panel_1.add(panel_4);

		JButton btnNewButton_1 = new JButton("<html><body>"
				+ "<span style='font-size:30px;'><font color=#f97b28>P</font><font color=#e76a62>R</font><font color=#27e2ee>E</font><font color=#f8dd64>S</font><font color=#993ae0>S</font></span>"
				+ "<br>"
				+ "<span style='font-size:30px;'><font color=#39d349>S</font><font color=#993ae0>T</font><font color=#f97b28>A</font><font color=#f8dd64>R</font><font color=#27e2ee>T</font></span>"
				+ "</body></html>");
		btnNewButton_1.setPreferredSize(new Dimension(140, 210));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Agency FB", Font.BOLD, 25));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(null);
		panel_4.add(btnNewButton_1);

		JPopupMenu popupMenu_1 = new JPopupMenu();
		popupMenu_1.setPreferredSize(new Dimension(160, 330));
		popupMenu_1.setBackground(new Color(243, 243, 243));
		popupMenu_1.setBorderPainted(false);

		JMenuItem Level1 = new JMenuItem("");
		Level1.setPreferredSize(new Dimension(250, 40));
		Level1.setBackground(new Color(243, 243, 243));
		Level1.setIcon(new ImageIcon("image\\素材\\关卡\\1.png"));
		Level1.setUI(new MyMenuItemUI(new Color(229, 229, 229)));
		Level1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 21));
		Level1.setBorder(null);
		Level1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame frame = new MainFrame();
				frame.setVisible(true);
			}

		});

		JMenuItem Level2 = new JMenuItem("");
		Level2.setPreferredSize(new Dimension(250, 30));
		Level2.setBackground(new Color(243, 243, 243));
		Level2.setIcon(new ImageIcon("image\\素材\\关卡\\2.png"));
		Level2.setUI(new MyMenuItemUI(new Color(229, 229, 229)));
		Level2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 21));
		Level2.setBorder(null);
		Level2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame frame = new MainFrame1();
				frame.setVisible(true);
			}

		});

		JMenuItem Level3 = new JMenuItem("");
		Level3.setPreferredSize(new Dimension(250, 40));
		Level3.setBackground(new Color(243, 243, 243));
		Level3.setIcon(new ImageIcon("image\\素材\\关卡\\3.png"));
		Level3.setUI(new MyMenuItemUI(new Color(229, 229, 229)));
		Level3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 21));
		Level3.setBorder(null);
		Level3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame frame = new MainFrame2();
				frame.setVisible(true);
			}

		});

		popupMenu_1.add(Level1);
		popupMenu_1.add(Level2);
		popupMenu_1.add(Level3);

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			boolean flag = false;

			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e) && !flag) {// e.getSource() == btnNewButton && !flag
					flag = true;
					popupMenu_1.show(e.getComponent(), Math.round(btnNewButton_1.getAlignmentX() + 145),
							Math.round(btnNewButton_1.getAlignmentY() - 35));
				} else
					flag = false;
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					// popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panel_5.setPreferredSize(new Dimension(340, 330));
		panel_1.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_6.setPreferredSize(new Dimension(140, 330));
		panel_5.add(panel_6);

		JButton btnNewButton = new JButton("");
		btnNewButton.setPreferredSize(new Dimension(140, 210));
		btnNewButton.setIcon(new ImageIcon("image\\115829er7xlsfqxlfjxjvl.gif"));
		btnNewButton.setBorder(null);
		panel_6.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame3 frame = new MainFrame3();
				frame.setVisible(true);
			}

		});

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
		panel_7.setPreferredSize(new Dimension(200, 330));
		panel_5.add(panel_7);

		JLabel lblNewLabel_3 = new JLabel("宠物属性");
		lblNewLabel_3.setPreferredSize(new Dimension(200, 40));
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 18));
		panel_7.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("清屏时间：");
		lblNewLabel_5.setFont(new Font("黑体", Font.PLAIN, 16));
		panel_7.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel();
		// lblNewLabel_6.setText(Integer.toString(attributes));
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_7.add(lblNewLabel_6);
		try {
			String sql = "select * from user where account ='" + Login.account + "'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			while (rs.next()) {
				Callingtime = Integer.parseInt(rs.getString(4));
			}
			if (login.getstate() == 1) {
				lblNewLabel_6.setText(Integer.toString(Callingtime));
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("image\\加号 (1).png"));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setContentAreaFilled(false);// 透明
		panel_7.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (bone >= 100) {
					bone = bone - 100;
					Callingtime++;
					try {
						String sql = "update user set bone='" + bone + "',Callingtime='" + Callingtime
								+ "'where account='" + Login.account + "'";
						Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://127.0.0.1:3306/antonio";
						String name = "root";
						String pw = "0000";
						Connection conn = DriverManager.getConnection(url, name, pw);
						Statement statement = conn.createStatement();
						statement.executeUpdate(sql);
						lblNewLabel_2.setText(Integer.toString(bone));//更新显示
						lblNewLabel_6.setText(Integer.toString(Callingtime));

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		panel_3.setPreferredSize(new Dimension(680, 30));
		contentPane.add(panel_3);

		JLabel lblNewLabel = new JLabel("<html><body>" + "<span style='color :black; font-size:12px;'>💪 </span>"
				+ "<span style='color :#06EB00; font-size:12px;'>online</span>" + "</body></html>");
		lblNewLabel.setPreferredSize(new Dimension(80, 30));
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		panel_3.add(lblNewLabel);
	}

	public static void main(String[] args) {
		online frame = new online();
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	class MyMenuItemUI extends BasicMenuItemUI {
		public MyMenuItemUI(Color bgColor) {
			super.selectionBackground = bgColor;

		}
	}

}
