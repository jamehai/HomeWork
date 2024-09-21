package Student_ver3;

import java.util.ArrayList;
import java.util.Scanner;

public class PerSonList {
    private ArrayList<PerSon> p = new ArrayList<>();

    public PerSonList() {
    }

    public ArrayList<PerSon> getP() {
        return p;
    }

    public void setP(ArrayList<PerSon> p) {
        this.p = p;
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien can them: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Nhap Thong Tin Sinh Vien " + (i + 1) + ":");
            Student student = new Student();
            student.addStudent();
            p.add(student);
        }
    }

    public void addTeacher() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong giang vien can them: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Nhap Thong Tin Giang Vien " + (i + 1) + ":");
            Teacher teacher = new Teacher();
            teacher.addTeacher();
            p.add(teacher);
        }
    }

    public void updatePerson(String id) {
        Scanner sc = new Scanner(System.in);
        PerSon person = findPersonById(id);
        if (person instanceof Student) {
            Student student = (Student) person;
            student.updateStudent(id);
        } else if (person instanceof Teacher) {
            Teacher teacher = (Teacher) person;
            teacher.updateTeacher(id);
        }
    }

    public void displayEveryone() {
        for (int i = 0; i < p.size(); i++) {
            p.get(i).displayInfo();
            System.out.println();
        }
    }

    public PerSon findPersonById(String id) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getId().equals(id)) {
                return p.get(i);
            }
        }
        return null;
    }

    public void deletePersonById(String id) {
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getId().equals(id)) {
                p.remove(i);
                System.out.println("Nguoi voi ID: " + id + " da bi xoa.");
            }
        }
    }

    public Student findTopStudent() {
        Student topStudent = null;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) instanceof Student) {
                Student student = (Student) p.get(i);
                if (topStudent == null || student.getGPA() > topStudent.getGPA()) {
                    topStudent = student;
                    System.out.println("Top Student:");
                    topStudent.displayInfo();
                }
            }
        }
        return topStudent;
    }

    public Teacher findTeacherByDepartment(String department) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) instanceof Teacher) {
                Teacher teacher = (Teacher) p.get(i);
                if (teacher.getDepartment().equals(department)) {
                    System.out.println("Teacher found in department " + department + ":");
                    teacher.displayInfo();
                    return teacher;
                }
            }
        }
        return null;
    }
}
