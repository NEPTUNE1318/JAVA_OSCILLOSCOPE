package javaSim;

import java.awt.*;
import javax.swing.*;

public class SimDisp extends JPanel implements Runnable {
	SimMain smain;
	int arr1[] = new int[502];
	int arr2[] = new int[502];
	int freq1 = 1000;
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
			y1 = baseY2 * 100 - (int)(arr2[i+2]/ scaleY2);
			y2 = baseY2 * 100 - (int)(arr2[i+3]/ scaleY2);
			g.drawLine(i, y1, i+1, y2);
		}
		
		g.setColor(Color.black);
		g.drawString("Channel 1 ", 10, 10);
		g.drawString("Freq. : " + freq1 + "Hz", 10, 30);
		g.drawString("Channel 2", 10, 50);
		g.drawString("Freq. : " + freq2 + "Hz", 10, 70);
	}
	
	 public void run() {
		 while(true) {
			 try {
				 arr1[0] = 1;
				 arr1[1] = freq1;
				 arr2[0] = 2;
				 arr2[1] = freq2;
				 int cnt1 = 0;
				 int cnt2 = 0;
				 boolean sw1 = false;
				 boolean sw2 = false;
				 for (int i = 0; i < 500; i++) {
					 cnt1++;
					 cnt2++;
					 if (cnt1 >= 50) {
						 sw1 = !sw1;
						 cnt1 = 0;
					 }
					 if (cnt2 >= 30) {
						 sw2 = !sw2;
						 cnt2 = 0;
					 }
					 if (sw1 == false) {
						 arr1[i+2] = 0;
					 } else {
						 arr1[i+2] = 1023;
					 }
					 if (sw2 == false) {
						 arr2[i+2] = 0;
					 } else {
						 arr2[i+2] = 1023;
					 }
				 }
				 repaint();
				 Thread.sleep(33);
			 } catch (Exception e) {
				 System.out.println(e.toString());
			 }
		 }
	 }
	
	 public void moveGraph(int value) {
		 if (channel == 1) {
			 baseY1 = value;
		 } else {
			 baseY2 = value;
		 }
		 	repaint();
	 }
	 
	 public void scaleGraph(int value) {
		 if (channel == 1) {
			 scaleY1 = value;
		 } else {
			 scaleY2 = value;
		 }
		 repaint();
	 }
		 
	 public void changeChannel(int value) {
		 channel = value;
	 }
}
