public class Event {
    private String title;
    private String date; // yyy-mm-dd
    private int startTime; // in minutes from midnight
    private int endTime; //ditto

    public Event(String title, String date, int startTime, int endTime) {
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "Event{" + //external
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}