package exercise_2;

public class Assignment {
    private String details;
    private VirtualClassroom classroom;

    public Assignment(String details, VirtualClassroom classroom) {
        this.details = details;
        this.classroom = classroom;
    }

    public String getDetails() {
        return details;
    }

    public VirtualClassroom getClassroom() {
        return classroom;
    }
}
