import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimeZone;
import java.util.Calendar;

import javax.swing.border.EmptyBorder;

public class PanelDate extends JPanel {

	private int month;
	private int year;
	private JPanel contentPane;
	private Cell sun;
	private Cell mon;
	private Cell tue;
	private Cell wed;
	private Cell thu;
	private Cell fri;
	private Cell sat;
	public Cell cell_7;
	public Cell cell_8;
	public Cell cell_9;
	public Cell cell_10;
	public Cell cell_11;
	public Cell cell_12;
	public Cell cell_13;
	public Cell cell_14;
	public Cell cell_15;
	public Cell cell_16;
	public Cell cell_17;
	public Cell cell_18;
	public Cell cell_19;
	public Cell cell_20;
	public Cell cell_21;
	public Cell cell_22;
	public Cell cell_23;
	public Cell cell_24;
	public Cell cell_25;
	public Cell cell_26;
	public Cell cell_27;
	public Cell cell_28;
	public Cell cell_29;
	public Cell cell_30;
	public Cell cell_31;
	public Cell cell_32;
	public Cell cell_33;
	public Cell cell_34;
	public Cell cell_35;
	public Cell cell_36;
	public Cell cell_37;
	public Cell cell_38;
	public Cell cell_39;
	public Cell cell_40;
	public Cell cell_41;
	public Cell cell_42;
	public Cell cell_43;
	public Cell cell_44;
	public Cell cell_45;
	public Cell cell_46;	
	public Cell cell_47;
	public Cell cell_48;
    public GregorianCalendarApp calendar;
    private User user;

	/**
	 * Create the panel.
	 */
	
	public PanelDate(int month, int year, User user, GregorianCalendarApp calendar) {
		this.user = user;
        this.calendar = calendar;
		initComponents();
		init();
		this.month = month;
		this.year = year;
		setDate();
	}
	
    public void thisMonth(){
        this.month = this.calendar.get(Calendar.MONTH);
        this.year = this.calendar.get(Calendar.YEAR);
    }
	
	public void init() {
		sun.asTitle();
		mon.asTitle();
		tue.asTitle();
		wed.asTitle();
		thu.asTitle();
		fri.asTitle();
		sat.asTitle();

	}
	
	public void setDate(){
        this.calendar.set(Calendar.YEAR, year);
        this.calendar.set(Calendar.MONTH, month-1);
        this.calendar.set(Calendar.DATE, 1);
        int startDay = this.calendar.get(Calendar.DAY_OF_WEEK) - 1;
        calendar.add(Calendar.DATE, -startDay);
        
        for (Component com : this.contentPane.getComponents()) {
        	if (com instanceof JButton) {
        		Cell cell = (Cell) com;
        		if (!cell.isTitle()) {
        			cell.setText(this.calendar.get(Calendar.DATE) + "");
        			cell.setDate(this.calendar.getTime());
        			cell.currentMonth(this.calendar.get(Calendar.MONTH) == month - 1);
        			this.calendar.add(Calendar.DATE, 1); // up 1 day?
        		}
        	}        	
        }
    }
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	
	public void initComponents() {

		setLayout(new GridLayout(1, 0, 0, 0));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);
		contentPane.setLayout(new GridLayout(7, 7, 0, 0));
		
		sun = new Cell((String) "Sun");
//		sun.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		}
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
        calendar.set(Calendar.DATE, 1);
		contentPane.add(sun);
		
		mon = new Cell((String) "Mon");
		contentPane.add(mon);
		
		tue = new Cell((String) "Tue");
		contentPane.add(tue);
		
		wed = new Cell((String) "Wed");
		contentPane.add(wed);
		
		thu = new Cell((String) "Thu");
		contentPane.add(thu);
		
		fri = new Cell((String) "Fri");
		contentPane.add(fri);
		
		sat = new Cell((String) "Sat");
		contentPane.add(sat);
		
		cell_7 = new Cell((String) null);
		contentPane.add(cell_7);
		
		cell_8 = new Cell((String) null);
		contentPane.add(cell_8);
		
		cell_9 = new Cell((String) null);
		contentPane.add(cell_9);
		
		cell_10 = new Cell((String) null);
		contentPane.add(cell_10);
		
		cell_11 = new Cell((String) null);
		contentPane.add(cell_11);
		
		cell_12 = new Cell((String) null);
		contentPane.add(cell_12);
		
		cell_13 = new Cell((String) null);
		contentPane.add(cell_13);
		
		cell_14 = new Cell((String) null);
		contentPane.add(cell_14);
		
		cell_15 = new Cell((String) null);
		contentPane.add(cell_15);
		
		cell_16 = new Cell((String) null);
		contentPane.add(cell_16);
		
		cell_17 = new Cell((String) null);
		contentPane.add(cell_17);
		
		cell_18 = new Cell((String) null);
		contentPane.add(cell_18);
		
		cell_19 = new Cell((String) null);
		contentPane.add(cell_19);
		
		cell_20 = new Cell((String) null);
		contentPane.add(cell_20);
		
		cell_21 = new Cell((String) null);
		contentPane.add(cell_21);
		
		cell_22 = new Cell((String) null);
		contentPane.add(cell_22);
		
		cell_23 = new Cell((String) null);
		contentPane.add(cell_23);
		
		cell_24 = new Cell((String) null);
		contentPane.add(cell_24);
		
		cell_25 = new Cell((String) null);
		contentPane.add(cell_25);
		
		cell_26 = new Cell((String) null);
		contentPane.add(cell_26);
		
		cell_27 = new Cell((String) null);
		contentPane.add(cell_27);
		
		cell_28 = new Cell((String) null);
		contentPane.add(cell_28);
		
		cell_29 = new Cell((String) null);
		contentPane.add(cell_29);
		
		cell_30 = new Cell((String) null);
		contentPane.add(cell_30);
		
		cell_31 = new Cell((String) null);
		contentPane.add(cell_31);
		
		cell_32 = new Cell((String) null);
		contentPane.add(cell_32);
		
		cell_33 = new Cell((String) null);
		contentPane.add(cell_33);
		
		cell_34 = new Cell((String) null);
		contentPane.add(cell_34);
		
		cell_35 = new Cell((String) null);
		contentPane.add(cell_35);
		
		cell_36 = new Cell((String) null);
		contentPane.add(cell_36);
		
		cell_37 = new Cell((String) null);
		contentPane.add(cell_37);
		
		cell_38 = new Cell((String) null);
		contentPane.add(cell_38);
		
		cell_39 = new Cell((String) null);
		contentPane.add(cell_39);
		
		cell_40 = new Cell((String) null);
		contentPane.add(cell_40);
		
		cell_41 = new Cell((String) null);
		contentPane.add(cell_41);
		
		cell_42 = new Cell((String) null);
		contentPane.add(cell_42);
		
		cell_43 = new Cell((String) null);
		contentPane.add(cell_43);
		
		cell_44 = new Cell((String) null);
		contentPane.add(cell_44);
		
		cell_45 = new Cell((String) null);
		contentPane.add(cell_45);
		
		cell_46 = new Cell((String) null);
		contentPane.add(cell_46);
		
		cell_47 = new Cell((String) null);
		contentPane.add(cell_47);
		
		cell_48 = new Cell((String) null);
		contentPane.add(cell_48);
	}


}

