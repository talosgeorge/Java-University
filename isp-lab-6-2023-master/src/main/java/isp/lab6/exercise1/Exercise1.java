package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        StudentInfo student1 = new StudentInfo("Andi Popescu", 1);
        student1.addGrade("Mathematics", 10.00F);
        student1.addGrade("Mathematics", 9.00F);
        student1.addGrade("Mathematics", 8.00F);

        StudentInfo student2 = new StudentInfo("Marcel Gandal", 2);
        student2.addGrade("Romanian", 5.00F);
        student2.addGrade("Romanian", 9.00F);
        student2.addGrade("Mathematics", 1.00F);
        student2.addGrade("Mathematics", 10.00F);

        StudentInfo student3 = new StudentInfo("Ioni", 3);
        student3.addGrade("Romanian", 5.00F);

        StudentGradeManagementSystem studentGradeManagementSystem = new StudentGradeManagementSystem();
        studentGradeManagementSystem.addStudent("Andi Popesu", 1);
        studentGradeManagementSystem.addStudent("Marcel Gandal", 2);
        studentGradeManagementSystem.addStudent("Ioni", 3);

        studentGradeManagementSystem.displayStudents();
        System.out.println(studentGradeManagementSystem.calculateAverageGrades(2));
        studentGradeManagementSystem.removeStudent(3);
        //studentGradeManagementSystem.updateStudent(1,"Andi Popescu");


    }
}
