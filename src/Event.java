public class Event {
    private String title;
    private String date; // yyy-mm-dd
    private int startTime; // in minutes from midnight
    private int endTime; //ditto
    private int priority;

    public Event(String title, String date, int startTime, int endTime, int priority) {
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Event{" + //external
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", priority=" + priority +
                '}';
    }
}