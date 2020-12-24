
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class button extends JButton {

	private static final long serialVersionUID = 1L;

	public button() {
		setOpaque(false);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		super.setBounds(x, y, width, height);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 12, 12);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// ‘≤Ω«øπæ‚≥›
		//g2d.setColor(new Color(122, 138, 153));// …Ë÷√∞¥≈•±ﬂøÚ—’…´
		g2d.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 12, 12);
	}
}