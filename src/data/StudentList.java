/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class StudentList {

    ArrayList<Student> studentList = new ArrayList<Student>();

    public void saveToStudent() {

        try {
            FileWriter fw = new FileWriter("studentList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            List<Student> list = new ArrayList<>();
            list.add(new Student("STU150", "Hoa Doan"));
            list.add(new Student("STU151", "Van A"));
            list.add(new Student("STU152", "Thi B"));
            list.add(new Student("STU153", "Hoang C"));
            list.add(new Student("STU154", "Tran D"));
            list.add(new Student("STU155", "Thuan"));
            for (Student o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadStudent() {
        try {
            FileReader f = new FileReader("studentList.txt");
            BufferedReader b = new BufferedReader(f);
            Scanner o = new Scanner(f);

            while (o.hasNextLine()) {
                String data = o.nextLine();
                String[] split = data.split(",");
                String stuID = split[0];
                String name = split[1];
                studentList.add(new Student(stuID, name));
            }
            b.close();
            f.close();
        } catch (Exception e) {
        }
    }

    public void printStuList() {
        System.out.println("-STUDEN LIST-");
        for (Student o : studentList) {
            o.display();
        }
    }
    public boolean isIDExist(String ID){
        return search(ID) != null;
    }
    public Student search(String ID) {
        for (Student x : studentList) {
            if (x.getStuID().equals(ID)) {
                return x;
            }
        }
        return null;
    }       
}
