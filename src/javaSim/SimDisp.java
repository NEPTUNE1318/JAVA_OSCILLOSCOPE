package javaSim;

import java.awt.*;
import javax.swing.*;

public class SimDisp extends JPanel {
	SimMain smain;
	int arr1[] = new int[502];
	int arr2[] = new int[502];
	int freq1 = 100;
	int freq2 = 100;
	int channel = 1;
	int baseY1 = 3;
	int baseY2 = 4;
	int scaleY1 = 8;
	int scaleY2 = 8;
	Thread t;
	
	
	public SimDisp(SimMain sm) {
		smain = sm;
		t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g) {
		int y1, y2;
		g.setColor(Color.green);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.black);
		g.drawLine(0, 250, 500, 250);
		g.drawLine(250, 0, 250, 500);
		g.setColor(Color.red);
		
		for(int i = 0; i < 499; ++i) {
			y1 = baseY1 * 100 - (int)(arr1[i+2]/ scaleY1);
			y2 = baseY1 * 100 - (int)(arr1[i+3]/ scaleY1);
			g.drawLine(i, y1, i+1, y2);
		}
		
		for(int i = 0; i < 499; ++i) {
			y1 = baseY1 * 100 - (int)(arr2[i+2]/ scaleY1);
			y2 = baseY2 * 100 - (int)(arr2[i+3]/ scaleY1);
			g.drawLine(i, y1, i+1, y2);
		}
		
		g.setColor(Color.black);
		g.drawString("Channel 1 ", 10, 10);
		g.drawString("Freq. : ", 10, 10);
	}
	
	public void drawFunc(String str) {
		repaint();
	}
	
	public void moveGraph(int value) {
		if(channel == 1) {
			
		}
	}
}
