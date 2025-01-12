import java.util.List;

public class PriorityCollisionHandler {
    public static boolean checkCollision(List<Event> events, String newDate, int newStartTime, int newEndTime, int priority){
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            String eventDate = event.getDate();


            if(eventDate != null && eventDate.equals(newDate) &&  //.equal why? https://www.w3schools.com/java/ref_string_equals.asp#:~:text=The%20equals()%20method%20compares,to%20compare%20two%20strings%20lexicographically.
                    newStartTime < event.getEndTime() &&
                    newEndTime > event.getStartTime()) {
                return true; // Collision detected
            }


        }
        return false; // No collision
    }
}
