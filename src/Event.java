import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Event {

	public String title;
	private LocalDateTime start;
	private LocalDateTime end;
	private Duration duration;
	public User owner;
	private boolean isPublic;
	public User[] sharedWith;

	Event(User owner, String title, LocalDateTime start, LocalDateTime end) {

		this.owner = owner;
		this.title = title;
		this.start = start;
		this.end = end;
		this.findDuration();

	}

	public void findDuration() {
		this.duration = Duration.between(start, end);
	}

	public void update(LocalDateTime start, LocalDateTime end) {

		this.start = start;
		this.end = end;
		this.duration = Duration.between(start, end);
	}

	public void remove() {
		
	}

	public void shareWith(User user) {

	}

	public void unshareWith(User user) {

	}

	public void togglePublic() {

	}

	public String getStartTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = start.format(formatter);

		return (formatDateTime);
	}

	public String getDurationInHours() {
		return ("[" + Long.toString(duration.toHours()) + " hours" + "]");
	}
}