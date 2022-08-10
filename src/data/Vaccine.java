package data;

public class Vaccine{

    private String vacID;
    private String name;

    public Vaccine() {
    }

    public Vaccine(String vacID, String name) {
        this.vacID = vacID;
        this.name = name;
    }

    public String getVacID() {
        return vacID;
    }

    public void setVacID(String vacID) {
        this.vacID = vacID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return vacID + "," + name;
    }
    
    public void display(){
        System.out.println(vacID + "," + name);
    }

}
