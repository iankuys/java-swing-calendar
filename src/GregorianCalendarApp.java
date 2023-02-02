import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianCalendarApp extends GregorianCalendar implements CalendarInterface{

    private GregorianCalendar gcal;
    public String title;
    public User Owner;
    private ArrayList<Event> Events;
    private boolean isPublic;
    public ArrayList<User> SharedWith;
    
    GregorianCalendarApp(User owner, String title){
        TimeZone timezone = TimeZone.getTimeZone(owner.timezone);
        this.title = title;
        this.gcal = new GregorianCalendar(timezone);
        this.Events = new ArrayList<Event>();
        this.Owner = owner;
    }

    public void addEvent(Event newEvent){
        this.Events.add(newEvent);
    }
    public void removeEvent(){
        for (int i = 0; i < this.Events.size(); i++){
            this.Events.remove(i);
        }
    }
    public GregorianCalendar getCal(){
        return this.gcal;
    }

    public void updateEvent(Event newEvent){
    	if (Events.isEmpty() || !Events.contains(newEvent)) {
    		Events.add(newEvent);
    	}
    }
    
    public ArrayList<Event> getAllEvent(){
        return this.Events;
    }
    public void togglePublic(){
        this.isPublic = true;
    }
    public void shareWith(User user){
        if (!this.SharedWith.contains(user)){
            this.SharedWith.add(user);
        }
    }
    public void unshareWith(User user){
        if (this.SharedWith.contains(user)){
            this.SharedWith.remove(user);
        }
    }
    
    public void updateDate(int month, int year) {
    	System.out.println(month);
    	this.gcal.set(Calendar.MONTH, month);
    	this.gcal.set(Calendar.YEAR, year);
    	System.out.println(this.gcal.get(Calendar.MONTH));

    }
    
    @Override
    public String toString() {
        return this.title;
    }
}
