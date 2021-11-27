package _08_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Clocks implements ActionListener {

	Timer timer;
	ClockUtilities clockUtil;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();
	JButton add = new JButton();
	JTextArea textArea = new JTextArea();
	JTextArea clock2 = new JTextArea();
	JTextArea clock3 = new JTextArea();
	
	String city = "San Diego, US";
	String city2 = "New York, US";
	String city3 = "Overland Park, US";
	
	String dateStr;
	String dateStr2;
	String dateStr3;
	
    String timeStr;
    String timeStr2;
    String timeStr3;
    
    TimeZone timeZone;
    TimeZone timeZone2;
    TimeZone timeZone3;

	public void gui() {
		clockUtil = new ClockUtilities();
		timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
		timeZone2 = clockUtil.getTimeZoneFromCityName("New York, US");
		timeZone3 = clockUtil.getTimeZoneFromCityName("Overland Park, US");
		
		
		 Calendar calendar = Calendar.getInstance(timeZone);
	     String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	     String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
	     dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
		
		panel.add(text);
		panel.add(add);
		panel.add(textArea);
		panel.add(clock2);
		panel.add(clock3);
		add.setText("Add a new city");
		add.addActionListener(this);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		 timer = new Timer(1000, this);
	        timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Calendar c = Calendar.getInstance(timeZone);
	        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
	        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
	        timeStr = militaryTime + twelveHourTime;
	        
	        Calendar c2 = Calendar.getInstance(timeZone2);
	        String militaryTime2 = c2.get(Calendar.HOUR_OF_DAY) + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND);
	        String twelveHourTime2 = " [" + c2.get(Calendar.HOUR) + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND) + "]";
	        timeStr2 = militaryTime2 + twelveHourTime2;
	        
	        Calendar c3 = Calendar.getInstance(timeZone3);
	        String militaryTime3 = c3.get(Calendar.HOUR_OF_DAY) + ":" + c3.get(Calendar.MINUTE) + ":" + c3.get(Calendar.SECOND);
	        String twelveHourTime3 = " [" + c3.get(Calendar.HOUR) + ":" + c3.get(Calendar.MINUTE) + ":" + c3.get(Calendar.SECOND) + "]";
	        timeStr3 = militaryTime3 + twelveHourTime3;
	        
	        System.out.println(timeStr);
	        textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
	        clock2.setText(city2 + "\n" + dateStr + "\n" + timeStr2);
	        clock3.setText(city3 + "\n" + dateStr + "\n" + timeStr3);
	        frame.pack();
	}
	
}
