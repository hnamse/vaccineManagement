package data;

public class Student{

    private String stuID;
    private String name;

    public Student() {
    }

    public Student(String stuID, String name) {
        this.stuID = stuID;
        this.name = name;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return stuID + "," + name;
    }
    public void display(){
        System.out.println(stuID + "," + name);
    }

}
