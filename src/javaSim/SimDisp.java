package javaSim;

import java.awt.*;
import javax.swing.*;

public class SimDisp extends JPanel {
	SimMain smain;
	String msg = "";
	Color c = Color.yellow;
	
	public SimDisp(SimMain sm) {
		smain = sm;
	}
	
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.black);
		g.drawString(msg, 25, 50);
	}
	
	public void drawFunc(String str) {
		msg = str;
		repaint();
	}
}
