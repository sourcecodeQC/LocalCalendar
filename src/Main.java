import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CalendarManager calendarManager = new CalendarManager();
        Scanner scx = new Scanner(System.in);
        String command;

        System.out.println("Local Calendar Manager");
        System.out.println("Available commands: add, list, delete, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scx.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter event title: ");
                    String title = scx.nextLine();
                    System.out.print("Enter event date (e.g., 2023-12-01): ");
                    String date = scx.nextLine();
                    System.out.println("start time HHMM: ");
                    int startHMM = scx.nextInt();
                    System.out.println("end time HHMM: ");
                    int endHHMM = scx.nextInt();
                    System.out.println("with priority?: ");
                    int priority = scx.nextInt();
                    calendarManager.addEvent(title, date, startHMM, endHHMM, priority);
                    break;
                case "list":
                    calendarManager.listEvents();
                    break;
                case "delete":
                    System.out.print("Enter event title to delete: ");
                    String titleToDelete = scx.nextLine();
                    calendarManager.deleteEvent(titleToDelete);
                    break;
                case "exit":
                    System.out.println("Exiting the Calendar Manager.");
                    scx.close();
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}