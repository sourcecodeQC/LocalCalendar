import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    private List<Event> events;

    public CalendarManager() {
        events = new ArrayList<>();
    }

    public void addEvent(String title, String date) {
        events.add(new Event(title, date));
        System.out.println("Event added: " + title);
    }

    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Events:");
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public void deleteEvent(String title) {
        boolean removed = events.removeIf(event -> event.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Event deleted: " + title);
        } else {
            System.out.println("Event not found: " + title);
        }
    }
}