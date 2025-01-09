import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CalendarManager calendarManager = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Local Calendar Manager!");
        System.out.println("Available commands: add, list, delete, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter event title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter event date (e.g., 2023-10-01): ");
                    String date = scanner.nextLine();
                    calendarManager.addEvent(title, date);
                    break;
                case "list":
                    calendarManager.listEvents();
                    break;
                case "delete":
                    System.out.print("Enter event title to delete: ");
                    String titleToDelete = scanner.nextLine();
                    calendarManager.deleteEvent(titleToDelete);
                    break;
                case "exit":
                    System.out.println("Exiting the Calendar Manager.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}