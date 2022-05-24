package javaSim;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;

public class SimCtrl extends JPanel {
	SimMain smain;
	JButton btn1, btn2, btn3, btn4, btn5;
	JButton btn6, btn7, btn8, btn9, btn10, btn11;
	JSlider slider1, slider2;
	
	public SimCtrl(SimMain sm) {
		setLayout(null);
		smain = sm;
		btn1 = new JButton("Run");
		btn2 = new JButton("Stop");
		btn3 = new JButton("Measure");
		btn4 = new JButton("AutoSet");
		btn5 = new JButton("Channel 1");
		btn6 = new JButton("Channel 2");
		btn7 = new JButton("Freq. Up");
		btn8 = new JButton("Freq. Down");
		btn9 = new JButton("Position");
		btn10 = new JButton("Scale");
		btn11 = new JButton("");
		slider1 = new JSlider(1, 5, 3);
		slider2 = new JSlider(4, 10, 5);
		btn11.setBackground(Color.green);
		btn1.setBounds(0, 0, 150, 50);
		btn2.setBounds(150, 0, 150, 50);
		btn3.setBounds(0, 50, 150, 50);
		btn4.setBounds(150, 50, 150, 50);
		btn5.setBounds(0, 100, 150, 50);
		btn6.setBounds(150, 100, 150, 50);
		btn7.setBounds(0, 150, 300, 50);
		btn8.setBounds(0, 250, 300, 50);
		btn9.setBounds(0, 300, 150, 50);
		btn10.setBounds(150, 300, 150, 50);
		btn11.setBounds(0, 400, 300, 100);
		slider1.setBounds(0, 200, 300, 50);
		slider2.setBounds(0, 350, 300, 50);
		
		btn5.addActionListener(new Btn5Handler());
		btn5.addActionListener(new Btn6Handler());
		slider1.addChangeListener(new Slider1Handler());
		slider2.addChangeListener(new Slider2Handler());
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btn9);
		add(btn10);
		add(btn11);
		add(slider1);
		add(slider2);
	}
	
	class Btn5Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			smain.sdisp.changeChannel(1);
		}
	}
	
	class Btn6Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			smain.sdisp.changeChannel(1);
		}
	}
	
	class Slider1Handler implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			smain.sdisp.moveGraph(slider1.getValue());
			btn11.setText(slider1.getValue() + " ");
		}
	}
	
	class Slider2Handler implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			smain.sdisp.moveGraph(slider2.getValue());
			btn11.setText(slider1.getValue() + " ");
		}
	}
	
	
}


