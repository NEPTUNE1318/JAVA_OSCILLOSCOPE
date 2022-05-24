package javaSim;

import java.awt.*;
import javax.swing.*;

public class SimMain extends JFrame {
	Container cp;
	SimDisp sdisp;
	SimCtrl sctrl;
	
	public SimMain() {
		super("Simulator Main");
		
		cp = this.getContentPane();
		cp.setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sdisp = new SimDisp(this);
		sctrl = new SimCtrl(this);
		sdisp.setBounds(0, 0, 500, 500);
		sctrl.setBounds(500, 0, 300, 500);
		
		cp.add(sdisp);
		cp.add(sctrl);
		
		setSize(810, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		SimMain sm = new SimMain();
	}
}
