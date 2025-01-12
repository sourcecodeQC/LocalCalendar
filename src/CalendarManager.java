import java.util.ArrayList; //suggested by ai; learned from external source
import java.util.List; //suggested by ai; learned from external source

public class CalendarManager {
    private List<Event> events;

    public CalendarManager() {
        events = new ArrayList<>(); //https://www.w3schools.com/java/java_arraylist.asp
    }

    public void addEvent(String title, String date, int startHHMM, int endHHMM, int priority) {
        // Suggestion of teacher; compute on minutes from midnight, allow input as hhmm
        int startTime = HourToMin.convertToMin(startHHMM);
        int endTime = HourToMin.convertToMin(endHHMM);

        //Collision test
        if(PriorityCollisionHandler.checkCollision(events, date, startTime, endTime, priority)){
            System.out.println("Event may not be added, due to a collision with an existing event");
            return;
        }

        events.add(new Event(title, date, startTime, endTime, priority));
        System.out.println("Event added: " + title + " ;from: " + startHHMM + " ;to: " + endHHMM + " ;with priority: " + priority);
    }

    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Events:");
            for (Event event : events) { //for (int i = 0; i < events.size(); i++) https://www.w3schools.com/java/java_foreach_loop.asp
                System.out.println(event);
            }
        }
    }

    public void deleteEvent(String title) {
        boolean removed = events.removeIf(event -> event.getTitle().equalsIgnoreCase(title)); // lambda expr (->) suggested by ai; learned from https://www.w3schools.com/java/java_lambda.asp
        if (removed) {
            System.out.println("Event deleted: " + title);
        } else {
            System.out.println("Event not found: " + title);
        }
    }
}