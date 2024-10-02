package exercise_2;
import java.util.Scanner;

import java.util.*;

public class VirtualClassroomApp {
    private static Map<String, VirtualClassroom> classrooms = new HashMap<>();
    private static Map<String, Student> students = new HashMap<>();
    private static List<Assignment> assignments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;

        while (true) {
            command = sc.nextLine().trim();
            if (command.startsWith("add_classroom")) {
                String className = command.split(" ")[1];
                addClassroom(className);
            } else if (command.startsWith("add_student")) {
                String[] parts = command.split(" ");
                String studentId = parts[1];
                String className = parts[2];
                addStudent(studentId, className);
            } else if (command.startsWith("schedule_assignment")) {
                String[] parts = command.split(" ", 3);
                String className = parts[1];
                String details = parts[2];
                scheduleAssignment(className, details);
            } else if (command.startsWith("submit_assignment")) {
                String[] parts = command.split(" ", 4);
                String studentId = parts[1];
                String className = parts[2];
                String details = parts[3];
                submitAssignment(studentId, className, details);
            }
        }
    }

    private static void addClassroom(String className) {
        VirtualClassroom classroom = new VirtualClassroom(className);
        classrooms.put(className, classroom);
        System.out.println("Classroom " + className + " has been created.");
    }

    private static void addStudent(String studentId, String className) {
        VirtualClassroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Class " + className + " not found.");
            return;
        }
        Student student = new Student(studentId, classroom);
        students.put(studentId, student);
        System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
    }

    private static void scheduleAssignment(String className, String details) {
        VirtualClassroom classroom = classrooms.get(className);
        if (classroom == null) {
            System.out.println("Class " + className + " not found.");
            return;
        }
        Assignment assignment = new Assignment(details, classroom);
        assignments.add(assignment);
        System.out.println("Assignment for " + className + " has been scheduled.");
    }

    private static void submitAssignment(String studentId, String className, String details) {
        Student student = students.get(studentId);
        if (student == null || !student.getClassroom().getClassName().equals(className)) {
            System.out.println("Invalid student or class.");
            return;
        }
        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
    }
}

