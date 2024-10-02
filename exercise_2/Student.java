package exercise_2;

public class Student {
    private String studentId;
    private VirtualClassroom classroom;

    public Student(String studentId, VirtualClassroom classroom) {
        this.studentId = studentId;
        this.classroom = classroom;
    }

    public String getStudentId() {
        return studentId;
    }

    public VirtualClassroom getClassroom() {
        return classroom;
    }
}
