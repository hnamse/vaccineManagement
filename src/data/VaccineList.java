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
public class VaccineList {

    private ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();

    public void saveToVaccine() {
        try {
            FileWriter fw = new FileWriter("vaccineList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            List<Vaccine> list = new ArrayList<>();
            list.add(new Vaccine("COVID-V001", "AstraZeneca"));
            list.add(new Vaccine("COVID-V002", "SPUTNIK V"));
            list.add(new Vaccine("COVID-V003", "Vero Cell"));
            list.add(new Vaccine("COVID-V004", "Pfizer"));
            list.add(new Vaccine("COVID-V005", "Moderna"));
            for (Vaccine o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadVaccine() {
        try {
            FileReader f = new FileReader("vaccineList.txt");
            BufferedReader br = new BufferedReader(f);
            Scanner o = new Scanner(f);
            while (o.hasNextLine()) {
                String data = o.nextLine();
                String[] split = data.split(",");
                String vacID = split[0];
                String name = split[1];
                vaccineList.add(new Vaccine(vacID, name));
            }
            br.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printVaccineList() {
        System.out.println("-VACCINE LIST-");
        for (Vaccine o : vaccineList) {
            o.display();
        }
    }
}
