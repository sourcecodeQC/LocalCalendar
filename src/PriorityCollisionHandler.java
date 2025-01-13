import java.util.List;
import java.util.Scanner;

public class PriorityCollisionHandler {
    public static final Scanner scx = new Scanner(System.in); // Declare scanner globally

    public static boolean checkCollision(List<Event> events, Event newEvent) {
        for (Event existingEvent : events) {
            if (existingEvent.getDate().equals(newEvent.getDate()) && isOverlapping(existingEvent, newEvent)) {
                // Collision detected
                return handleCollision(existingEvent, newEvent);
            }
        }
        return false; // No collision detected, event can be added
    }

    private static boolean isOverlapping(Event existingEvent, Event newEvent) {
        return newEvent.getStartTime() < existingEvent.getEndTime() &&
                newEvent.getEndTime() > existingEvent.getStartTime();
    }

    private static boolean handleCollision(Event existingEvent, Event newEvent) {
        if (existingEvent.getPriority() < newEvent.getPriority()) { // Existing event has higher priority
            System.out.println("Conflicting event: " + existingEvent);
            System.out.println("New event has lower priority! Override? Y/N: ");
            String override = scx.nextLine();
            if (override.equalsIgnoreCase("Y")) {
                moveEvent(existingEvent, newEvent);
            }
            else {
                System.out.println("New Event Aborted");
                return true; // Collision detected, event not added
            }
        }

        else if (existingEvent.getPriority() > newEvent.getPriority()) { // New event has higher priority
            System.out.println("Conflicting event: " + existingEvent);
            System.out.println("New event has higher priority! Override? Y/N: ");
            String override = scx.nextLine();
            if (override.equalsIgnoreCase("Y")) {
                moveEvent(newEvent, existingEvent);
            }
            else {
                System.out.println("New Event Aborted");
                return true; // Collision detected, event not added
            }
        }

        else {
            // Both events have the same priority
            System.out.println("Conflicting event: " + existingEvent);
            System.out.println("Both events have the same priority! Override? Y/N: ");
            String override = scx.nextLine();
            if (override.equalsIgnoreCase("Y")) {
                moveEvent(newEvent, existingEvent);
            }

            else {
                System.out.println("New Event Aborted");
                return true; // Collision detected, event not added
            }
        }
        return false; // No collision detected, event can be added
    }

    private static void moveEvent(Event existingEvent, Event newEvent) {
        // Move the existing event to create a gap of 15 minutes
        int newStartTime = newEvent.getEndTime() + 15; // 15 minutes after the new event
        existingEvent.setStartTime(newStartTime); // Update the start time using setter
        existingEvent.setEndTime(newStartTime + (existingEvent.getEndTime() - existingEvent.getStartTime())); // Adjust end time using setter
        System.out.println("Existing event moved to: " + existingEvent);
    }
}