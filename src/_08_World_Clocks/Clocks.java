package _08_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Clocks implements ActionListener {

	Timer timer;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();
	JButton add = new JButton();

	public void gui() {
		panel.add(text);
		panel.add(add);
		add.setText("Add a new city");
		add.addActionListener(this);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
