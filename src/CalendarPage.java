import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class CalendarPage extends JFrame{
	
    private JComboBox<GregorianCalendarApp> calendarDropdown;
    private JTextField nameField;
	private ArrayList<GregorianCalendarApp> calendars;
	private JPanel mainPanel;
	private User owner;
	
	private void getExistingCalendars() {
		
		calendarDropdown.removeAllItems();
		for (int i = 0; i < owner.calendars.size(); i++) {
			System.out.println(owner.calendars.get(i));
			calendars.add(owner.calendars.get(i));
			calendarDropdown.addItem(owner.calendars.get(i));
		}
	}
	
	public void deleteCalendar(GregorianCalendarApp calendarToDelete) {
		
		this.owner.removeCalendar(calendarToDelete);
//		this.calendarDropdown.removeItem(calendarToDelete);
	}
	
	// refresh frame
	private void refresh() {
		this.calendarDropdown.revalidate();
		this.calendarDropdown.repaint();
	}
    
    public CalendarPage(User owner) {
    	
    	calendars = new ArrayList<GregorianCalendarApp>();
    	this.owner = owner;
    	
        setTitle("User Page");
        setSize(400, 200);

        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,3,0,0));
        
        JLabel calendarLabel = new JLabel("Enter Calendar Name:");
        mainPanel.add(calendarLabel);
        
        JPanel namePanel_1 = new JPanel();
        mainPanel.add(namePanel_1);
        
        nameField = new JTextField(15);
        namePanel_1.add(nameField);
        
        JButton newCalendarBtn = new JButton("New Calendar");
        
        newCalendarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String calendarName = nameField.getText();
                GregorianCalendarApp newCalendar = new GregorianCalendarApp(owner, calendarName);
                owner.addCalendar(newCalendar);

                calendarDropdown.addItem(newCalendar);
                
                if (!calendars.contains(newCalendar)) {
                	
                	calendars.add(newCalendar);
                }
            }
        });
        namePanel_1.add(newCalendarBtn);

        JLabel userListLabel = new JLabel("Select a calendar: ");
        mainPanel.add(userListLabel);
        
        JPanel userPanel = new JPanel();
        mainPanel.add(userPanel);
        
        calendarDropdown = new JComboBox<>();
        this.getExistingCalendars();
        userPanel.setLayout(new GridLayout(0, 2, 0, 0));
        userPanel.add(calendarDropdown);
        
        JButton existingCalendarBtn = new JButton("Choose");
        
        existingCalendarBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GregorianCalendarApp selectedCalendar = (GregorianCalendarApp) calendarDropdown.getSelectedItem();
                
        		// start calendar GUI
                CalendarGUI calendarGUI = new CalendarGUI(selectedCalendar, owner);
                calendarGUI.setVisible(true);
        	}
        });
        
        userPanel.add(existingCalendarBtn);
        
        JLabel label = new JLabel("");
        userPanel.add(label);
        
        JButton deleteCalendarButton = new JButton("Delete");
        
        deleteCalendarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GregorianCalendarApp selectedCalendar = (GregorianCalendarApp) calendarDropdown.getSelectedItem();
        		System.out.print("1st");
        		deleteCalendar(selectedCalendar);
        		getExistingCalendars();
        		refresh();
        	}
        });
        
        userPanel.add(deleteCalendarButton);

        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        UserPage userPage = new UserPage();
        userPage.setVisible(true);
    }
}
