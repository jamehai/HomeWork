package Student_ver2;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class StudentList {
    ArrayList<Students>Students = new  ArrayList<>();
    public StudentList(){
        this.Students = new ArrayList<>();
    }
    public ArrayList<Students> getStudents(){
        return Students;
    }
    public void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap So Luong Sinh Vien Can Them:");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++){
            System.out.println("Nhap thong tin sinh vien "+(i + 1) + ":");
            Students student = new Students() {
                @Override
                public void setDateofbirth(String dateofbirth) {

                }
            };
            student.addStudent();
            student.addStudent();
        }
    }
    public void updateStudentByID(){
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Nhap Id sinh vien can update:");
        String id = scanner.nextLine();
        for (int i = 0; i< Students.size();i++){
            if (Students.get(i).getId().equals(id)){
                System.out.println("Cap nhat thong tin sinh vien:");
                Student_ver2.Students updateStudent = Students.get(i);
                System.out.println("Nhap ten moi:");
                updateStudent.setname(scanner.nextLine());
                System.out.println("Nhap nganh moi:");
                updateStudent.setGPA(Float.parseFloat(scanner.nextLine()));
                System.out.println("Nhap ngay sinh moi:");
                String dobStr = scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    updateStudent.setDateofbirth(sdf.parse(dobStr));
                } catch (Exception e){
                    System.out.println("Wrong Format!");
                }
                Students.set(i,updateStudent);
                System.out.println("cap nhat thanh cong!");
                return;
            }
        }
    }
    public void deleteStudentById(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Id sinh vien can xoa:");
        String id = scanner.nextLine();
        for (int i = 0; i< Students.size();i++){
            if (Students.get(i).getId().equals(id)){
                Students.remove(i);
                System.out.println("sinh vien moi ID:"+id+"da bi xoa.");
                return;
            }
        }
    }
    public void displayAllStudent(){
        for (int i = 0; i<Students.size();i++){
            Students.get(i).displayInfo();
            System.out.println();
        }
    }
    public void findTopStudent(){
        Students topStudent = Students.get(0);
        for (int i =1;i<Students.size();i++){
            if (Students.get(i).getGPA()>topStudent.getGPA()){
                topStudent =  Students.get(i);
            }
        }
        System.out.println("Sinh vien co GPA cao nhat:");
        topStudent.displayInfo();
    }
    public void findscholarshipStudent(){
        for (int i=0;i<Students.size();i++){
            if (Students.get(i).getScholarship()){
                Students.get(i).displayInfo();
            }
        }
    }
    public double calculatetuitionofAllStudent(){
        double totaltuition = 0;
        for (int i = 0; i<Students.size();i++){
            totaltuition+= Students.get(i).getTuition();
        }
        return totaltuition;
    }
}
