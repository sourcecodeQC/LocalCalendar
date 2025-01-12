import java.nio.*; // java.io.Serializable - suggested by ai; learned from external source https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html and https://www.geeksforgeeks.org/serializable-interface-in-java/
import java.io.*;
import java.util.*;

public class FileManagerIO {

    // Save events to a CSV file
    public static void saveEvents(List<Event> events, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write header
            writer.write("Title,Date,StartTime,EndTime,Priority");
            writer.newLine();
            // Write each event
            for (Event event : events) {
                writer.write(event.getTitle() + "," + event.getDate() + "," +
                        event.getStartTime() + "," + event.getEndTime() + "," +
                        event.getPriority());
                writer.newLine(); // Move to the next line for the next event
            }
            System.out.println("Events saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving events: " + e.getMessage());
        }
    }

    // Load events from a CSV file
    public static List<Event> loadEvents(String filename) {
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip header
            reader.readLine();
            // Read each line and create Event objects
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) { // Ensure there are 5 parts
                    String title = parts[0];
                    String date = parts[1];
                    int startTime = Integer.parseInt(parts[2]);
                    int endTime = Integer.parseInt(parts[3]);
                    int priority = Integer.parseInt(parts[4]);
                    events.add(new Event(title, date, startTime, endTime, priority));
                }
            }
            System.out.println("Events loaded from " + filename);
        } catch (IOException e) {
            System.err.println("Error loading events: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing event data: " + e.getMessage());
        }
        return events; // Return the list of events
    }

}


