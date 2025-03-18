package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class StudentGradeManagementSystem {
    private List<StudentInfo> students;

    public StudentGradeManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int id) {
        students.add(new StudentInfo(name, id));
    }

    public void removeStudent(int id) {
        StudentInfo toRemove = null;
        for (StudentInfo student : students) {
            if (student.getId() == id) {
                toRemove = student;
                System.out.println("Student with id " + id + " was removed.");
                break;
            }
        }
    }

    public void updateStudent(int id, String name) {
        for (StudentInfo student : students) {
            if (student.getId() == id) {
                student.setName(name);
                return;
            }
        }
        System.out.println("Student with id " + id + "not found.");
    }

    public double calculateAverageGrades(int id) {
        for (StudentInfo student : students) {
            if (student.getId() == id) {
                return student.averageGrades();
            }
        }
        System.out.println("Student with id " + id + "not found.");
        return -1;
    }

    public void displayStudents() {
        for (StudentInfo student : students) {
            System.out.println(student.getName());
        }
    }
}
