import java.util.ArrayList;
import java.util.Calendar;

public class User {
	public String timezone;
	public String username;
	public ArrayList<GregorianCalendarApp> calendars;

	public User(String timezone, String username) {
		this.timezone = timezone;
		this.username = username;
		this.calendars = new ArrayList<GregorianCalendarApp>();
	}

	public void addCalendar(GregorianCalendarApp newCalendar) {

		this.calendars.add(newCalendar);
	}

	public void removeCalendar(GregorianCalendarApp exCalendar) {

		if (this.calendars.contains(exCalendar)) {
			exCalendar.calendarDeletion();
			this.calendars.remove(exCalendar);
		}
	}

	public void updateCalendar(GregorianCalendarApp currCalendar) {

		if (this.calendars.contains(currCalendar)) {
			this.calendars.remove(currCalendar);
			this.calendars.add(currCalendar);
		}
	}

	@Override
	public String toString() {
		return this.username;
	}
}