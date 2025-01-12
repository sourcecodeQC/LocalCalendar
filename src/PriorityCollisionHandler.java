import java.util.List;
import java.util.Scanner;

public class PriorityCollisionHandler {
    public static boolean checkCollision(List<Event> events, Event newEvent){
        for(Event existingEvent : events){
            if(existingEvent.getDate().equals(newEvent.getDate()) && isOverlapping(existingEvent, newEvent)) {//.equal why? https://www.w3schools.com/java/ref_string_equals.asp#:~:text=The%20equals()%20method%20compares,to%20compare%20two%20strings%20lexicographically.
                // Collision = true
                return
            }
        }
    }

    private static boolean isOverlapping(Event existingEvent, Event newEvent){
        return newEvent.getStartTime() < existingEvent.getEndTime() &&
                newEvent.getEndTime() > existingEvent.getStartTime();

    }

    private static boolean handleCollision(Event existingEvent, Event newEvent){
        if(existingEvent.getPriority() < newEvent.getPriority()){


        } else if (existingEvent.getPriority() > newEvent.getPriority()) {
            
        } else {
            //both events have same priority
        }

    }


}

