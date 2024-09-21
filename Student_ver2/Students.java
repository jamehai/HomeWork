package Student_ver2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Students extends PerSon{
    float GPA;
    String major;
    double tuition = 10000000;
    Boolean scholarship;

    public Students(){
    }
    public Students(float GPA, String major, double tuition, Boolean scholarship){
        this.GPA=GPA;
        this.major=major;
        this.tuition=tuition;
        this.scholarship=scholarship;
    }
    public Students(float GPA, String major, double tuition, boolean scholarship, String name, String id, Date dateofbitrh){
        super(id , name, dateofbitrh);
        this.GPA=GPA;
        this.major=major;
        this.tuition=tuition;
        this.scholarship=GPA>=9;
    }
    public float getGPA(){
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
        this.scholarship=GPA>=9;
    }
    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major=major;
    }

    public double getTuition() {
        return scholarship ? tuition * 0.5 : tuition;
    }
    public Boolean getScholarship(){
        return scholarship;
    }
    public String getid(){
        return id;
    }
    public void setid(String id){
        this.id=id;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public Date getdateofbirth(){
        return dateofbirth;
    }

    @Override
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth=dateofbirth;
    }
    public void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID:");
        String id = scanner.nextLine();
        setid(id);
        System.out.print("Name:");
        String name = scanner.nextLine();
        setname(name);
        System.out.print("major:");
        String major = scanner.nextLine();
        setMajor(major);
        System.out.print("GPA:");
        float GPA = Float.parseFloat(scanner.nextLine());
        setGPA(GPA);
        System.out.print("Date of birth:");
        String dateofbirthString = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateofbirth = simpleDateFormat.parse(dateofbirthString);
            setDateofbirth(dateofbirth);
        } catch (Exception e) {
            System.out.println("Wrong Format!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("ID:" + getid());
        System.out.println("Name:" + getname());
        System.out.println("major:" + getMajor());
        System.out.println("GPA:" + getGPA());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy:");
        System.out.println("Date of birth:" + simpleDateFormat.format(dateofbirth));
        System.out.println("Tuition:" + getTuition());
        System.out.println("scholarship:" + getScholarship());
    }
}
