package Student_ver2;
import java.util.Scanner;
public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("MeNu:");
            System.out.println("1. Them sinh vien:");
            System.out.println("2. Cap nhat sinh vien theo ID:");
            System.out.println("3. Xoa sinh vien theo ID:");
            System.out.println("4. Hien thi tat ca cac sinh vien:");
            System.out.println("5. Tim sinh vien co GPA cai nhat:");
            System.out.println("6. Sinh vien co hoc bong:");
            System.out.println("7. Hien tong hoc phi:");
            System.out.println("0. Exit");
            System.out.print("Nhap lua chon:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    studentList.addStudent();
                    break;
                case 2:
                    studentList.updateStudentByID();
                    break;
                case 3:
                    studentList.deleteStudentById();
                    break;
                case 4:
                    studentList.displayAllStudent();
                    break;
                case 5:
                    studentList.findTopStudent();
                    break;
                case 6:
                    studentList.findscholarshipStudent();
                    break;
                case 7:
                    double totaltuition = studentList.calculatetuitionofAllStudent();
                    break;
                case 0:
                    System.out.println("thoat chuong trinh.");
                    break;
                default:
                    System.out.println("lua chon khong hop le. chon lai.");
            }
            System.out.println();
        } while (choice !=0);
        scanner.close();
    }
}
