import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.io.*;
import java.util.Date;

import javax.swing.SwingConstants;

public class CalendarGUI extends JFrame {

	private JPanel contentPane;
	private GregorianCalendarApp calendar;
	private User owner;
	private int month;
	private int year;
	private PanelDate panelDate;
	private EventPanel eventField;
	private JPanel eventPanel;
	private JPanel monthYearPanel;
	private JLabel monthYearField;
	private JButton nextBtn;
	private JButton prevBtn;
	private JPanel createEventPanel;
	private JTextArea eventDateLabel;
	private EventPanel eventCreationPanel;
	private JButton createEventBtn;
	private JPanel editEventsPanel;
	private JTextArea storedEventsTextField;
	private JPanel btnPanel;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JPanel panel;
	private JScrollPane scrollPane;
	
	private class CellActionListeners implements ActionListener {

		public void actionPerformed(ActionEvent e) {
	        // your handle button click code
			Cell o = (Cell)e.getSource();
			String name = o.getName();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			if (!o.isTitle()) {
				Date date = (Date) o.getDate();
				LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				String dateTimeString = localDateTime.format(formatter);
				eventDateLabel.setText(dateTimeString);

			}
	    }
	}

	/**
	 * Shortcut to test the calendar application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User testUser = new User("utc","doggo");
					CalendarGUI frame = new CalendarGUI(new GregorianCalendarApp(testUser, "testCalendar"), testUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void thisMonth() {
		this.month = calendar.getCal().get(Calendar.MONTH) + 1;
		this.year = calendar.getCal().get(Calendar.YEAR);
		System.out.println(this.month);
	}

	private void showMonthYear() {
		SimpleDateFormat df = new SimpleDateFormat("MMMM-yyyy");
		this.monthYearField.setText(df.format(calendar.getCal().getTime()));

	}
	
	// refresh frame
	private void refresh() {
		this.contentPane.revalidate();
		this.contentPane.repaint();
	}
	
	public void displayEvents() {
		
		ArrayList<Event> storedEvents = this.calendar.getAllEvent();
		String textToOutput = "1.";
		if (!storedEvents.isEmpty()) {
			
			for (int i = 0; i < storedEvents.size(); i++) {
	            textToOutput = textToOutput + storedEvents.get(i).title + "\n" + 
			storedEvents.get(i).getStartTime() + " " + storedEvents.get(i).getDurationInHours() + "\n";
	        }		
			}
		storedEventsTextField.setText("Your events:\n" + textToOutput);
		refresh();
	}

	public void addListenersToCells() {
		
		CellActionListeners cellListener = new CellActionListeners();
		for (Component com : this.panelDate.getContentPane().getComponents()) {
			System.out.println("hey");
	    	if (com instanceof JButton) {
	    		Cell cell = (Cell) com;
	    		if (!cell.isTitle()) {
	    			cell.addActionListener(cellListener);
	    			}
	    		}        	
		}	
	}
	/**
	 * Create the frame.
	 */
	public CalendarGUI(GregorianCalendarApp calendar, User owner) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Initializing Calendar
		this.owner = owner;
		this.calendar = calendar;
		this.thisMonth();
		
		// JPanel stuff
		setBounds(100*2, 100*2, 700, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		eventPanel = new JPanel();
		eventPanel.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(eventPanel);

		monthYearPanel = new JPanel();
		monthYearPanel.setLayout(new GridLayout(1, 3, 0, 0));
		eventPanel.add(monthYearPanel);
		
		prevBtn = new JButton("<");
		prevBtn.setPreferredSize(new Dimension(40, 40));
		
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panelDate);
				if (month == 1) {
					month = 12; // month starts from 0-11 in java calendar
					year--;
				} else {
					month--;
				}
				panelDate = new PanelDate(month, year, owner, calendar);
				addListenersToCells();
				contentPane.add(panelDate);
				calendar.updateDate(month-1, year);

				showMonthYear();
				refresh();
			}
		});
		monthYearPanel.add(prevBtn);

		monthYearField = new JLabel();
		monthYearPanel.add(monthYearField);
		
		nextBtn = new JButton(">");
		nextBtn.setPreferredSize(new Dimension(20, 20));
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panelDate);
				if (month == 12) {
					month = 1; // month starts from 0-11 in java calendar
					year++;
				} else {
					month++;
				}
				panelDate = new PanelDate(month, year, owner, calendar);
				addListenersToCells();
				contentPane.add(panelDate);
				calendar.updateDate(month-1, year);

				showMonthYear();
				refresh();
			}
		});
		monthYearPanel.add(nextBtn);
		
		createEventPanel = new JPanel();
		createEventPanel.setLayout(new GridLayout(1, 3, 0, 0));
		eventPanel.add(createEventPanel);
		
		eventDateLabel = new JTextArea("You selected:");
		eventDateLabel.setEditable(false);
		createEventPanel.add(eventDateLabel);
		
		eventCreationPanel = new EventPanel();
		createEventPanel.add(eventCreationPanel);
		
		createEventBtn = new JButton("Create");
		
		createEventBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         String title = eventCreationPanel.getTitle();
		         String startTime = eventCreationPanel.getStartTime();
		         String endTime = eventCreationPanel.getEndTime();
		         String buffer = eventDateLabel.getText();
		        
		         System.out.println(startTime);
		         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		         LocalDateTime startDT = LocalDateTime.parse(buffer + " " + startTime, formatter);
		         LocalDateTime endDT = LocalDateTime.parse(buffer + " " + endTime, formatter);
		         Event newEvent = new Event(owner, title, startDT, endDT);
		         System.out.println(startDT);
		         calendar.updateEvent(newEvent);
		         displayEvents();
			}
		});
		
		createEventPanel.add(createEventBtn);
		
		editEventsPanel = new JPanel();
		editEventsPanel.setLayout(new GridLayout(1, 3, 0, 0));
		eventPanel.add(editEventsPanel);
		
		scrollPane = new JScrollPane();
		editEventsPanel.add(scrollPane);
		
		storedEventsTextField = new JTextArea();
		scrollPane.setViewportView(storedEventsTextField);
		storedEventsTextField.setEditable(false);
		storedEventsTextField.setText("Your events:");
		
		panel = new JPanel();
		editEventsPanel.add(panel);
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(3, 1, 0, 0));
		editEventsPanel.add(btnPanel);
		
		deleteBtn = new JButton("Delete");
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnPanel.add(deleteBtn);
		
		updateBtn = new JButton("Update");
		btnPanel.add(updateBtn);
		
		this.panelDate = new PanelDate(this.month, this.year, this.owner, this.calendar);
		
		// add cell listeners
		this.addListenersToCells();
		contentPane.add(panelDate);
		
		CellActionListeners cellListener = new CellActionListeners();
		for (Component com : this.panelDate.getContentPane().getComponents()) {
			System.out.println("hey");
	    	if (com instanceof JButton) {
	    		Cell cell = (Cell) com;
	    		if (!cell.isTitle()) {
	    			cell.addActionListener(cellListener);
	    			}
	    		}        	
		}		
		this.calendar = panelDate.calendar;
		
		//showing the label for month and year
		this.showMonthYear();
		
	}

}
