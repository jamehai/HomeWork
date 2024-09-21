package Student_ver2;
import java.util.Date;
public abstract class PerSon implements IPerSon {
    String id;
    String name;
    Date dateofbirth;
    public PerSon(){
    }
    public PerSon(String id, String name , Date dateofbirth){
        this.id=id;
        this.dateofbirth=dateofbirth;
        this.name=name;
    }
    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Date getdateofbirth(){
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public abstract void setDateofbirth(String dateofbirth);

    public abstract void displayInfo();
}
