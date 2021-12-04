package _08_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class NewClocks implements ActionListener {

	Clocks Cobj = new Clocks();
	
	JTextArea newClock = new JTextArea();
	
	Timer timer;
	ClockUtilities clockUtil;
	
	String dateStr;
    String timeStr;
    TimeZone timeZone;
  
    static String newCity;
	
	public void AddClock() {
		newCity = JOptionPane.showInputDialog("What city? (Format: (City, Country))");
		
		clockUtil = new ClockUtilities();
		timeZone = clockUtil.getTimeZoneFromCityName(newCity);
		
		Calendar calendar = Calendar.getInstance(timeZone);
	    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	    String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
	    dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
		
		timer = new Timer(1000, Cobj);
        timer.start();
        
        Cobj.panel.add(newClock);
	}
	
	public void actionPerformed(ActionEvent e) {
		Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
        System.out.println(timeStr);
        newClock.setText(newCity + "\n" + dateStr + "\n" + timeStr);
        Cobj.frame.pack();
        
	}
	}
	

