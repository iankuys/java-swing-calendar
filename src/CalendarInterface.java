import java.util.ArrayList;

public interface CalendarInterface {
	
    public void addEvent(Event newEvent);
    public void removeEvent(Event oldEvent);
    public void updateEvent(Event newEvent);
    public ArrayList<Event> getAllEvent();
    public void togglePublic();
    public void shareWith(User user);
    public void unshareWith(User user);

}
