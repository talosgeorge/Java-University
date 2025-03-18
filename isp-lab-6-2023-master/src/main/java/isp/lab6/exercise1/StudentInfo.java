package isp.lab6.exercise1;

import java.util.HashMap;

public class StudentInfo {
    private String name;
    private int id;
    private HashMap<String, Float> grades;

    public StudentInfo(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Float> getGrades() {
        return grades;
    }

    public void addGrade(String subject, Float grade) {
        grades.put(subject, grade);
    }

    public double averageGrades() {
        double sum = 0.0;
        for (Float grade : grades.values()) {
            sum += grade;
        }
        return grades.isEmpty() ? 0 : sum / grades.size();
    }
}
