import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianCalendarApp extends GregorianCalendar implements CalendarInterface {

	private GregorianCalendar gcal;
	public String title;
	public User Owner;
	private ArrayList<Event> events;
	private boolean isPublic;
	public ArrayList<User> SharedWith;

	GregorianCalendarApp(User owner, String title) {
		TimeZone timezone = TimeZone.getTimeZone(owner.timezone);
		this.title = title;
		this.gcal = new GregorianCalendar(timezone);
		this.events = new ArrayList<Event>();
		this.Owner = owner;
	}

	public void addEvent(Event newEvent) {
		this.events.add(newEvent);
	}

	public void removeEvent(Event event) {
		events.remove(event);
	}

	public GregorianCalendar getCal() {
		return this.gcal;
	}

	public void updateEvent(Event newEvent) {
		if (events.isEmpty() || !events.contains(newEvent)) {
			events.add(newEvent);
		}
	}

	public ArrayList<Event> getAllEvent() {
		return this.events;
	}

	public void togglePublic() {
		this.isPublic = true;
	}

	public void shareWith(User user) {
		if (!this.SharedWith.contains(user)) {
			this.SharedWith.add(user);
		}
	}

	public void unshareWith(User user) {
		if (this.SharedWith.contains(user)) {
			this.SharedWith.remove(user);
		}
	}

	public void updateDate(int month, int year) {
		System.out.println(month);
		this.gcal.set(Calendar.MONTH, month);
		this.gcal.set(Calendar.YEAR, year);
		System.out.println(this.gcal.get(Calendar.MONTH));

	}

	public void deleteEvent(String title) {
		for (int i = 0; i < events.size(); i++) {

			if (events.get(i).title.equals(title)) {
				events.remove(i);
			}
		}
	}

	public void updateEvent(String title, LocalDateTime newStartDT, LocalDateTime newEndDT) {

		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).title.equals(title)) {
				events.get(i).update(newStartDT, newEndDT);
			}
		}
	}

	public void calendarDeletion() {

		ArrayList<Event> eventsFound = this.getAllEvent();

		for (int i = 0; i < eventsFound.size(); i++) {
			this.removeEvent(eventsFound.get(i));
		}
	}

	@Override
	public String toString() {
		return this.title;
	}
}
