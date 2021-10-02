package _05_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /* 
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons. 
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * 
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list. 
     */

	static HashMap<Integer, String> IDs = new HashMap<Integer, String>();
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton add = new JButton();
	static JButton search = new JButton();
	static JButton view = new JButton();
	static HashMap<Integer, String> studentRoster = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		_02_LogSearch l = new _02_LogSearch();
		l.setup();
	}

	public void setup() {
		panel.add(add);
		panel.add(search);
		panel.add(view);
		
		add.setText("Add a new entry");
		search.setText("Search for entries");
		view.setText("View Entries");
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		//frame.pack();
		
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			String I = JOptionPane.showInputDialog("Enter your ID");
			int ID = Integer.parseInt(I);
			String newName = JOptionPane.showInputDialog("Enter your name");
			studentRoster.put(ID, newName);
		}
		
		if(e.getSource()==search) {
			String searchId = JOptionPane.showInputDialog("Enter an ID");
			int searched = Integer.parseInt(searchId);
			
			if(studentRoster.get(searched) != null) {
					JOptionPane.showMessageDialog(null, "ID: " + searchId + " Name: " + studentRoster.get(searched));
				}
			else {
					JOptionPane.showMessageDialog(null, "That entry does not exist.");
				
			}
		}
		
		if(e.getSource()==view) {
			String s = "";
			for(int i: studentRoster.keySet()) {
				s+="ID: " + i + "Name: " + " " + studentRoster.get(i) + "\n";
			
			}
			
			JOptionPane.showMessageDialog(null,  s);
		}
	}
}
