package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import tools.MyToys;
import tools.Menu;

public class InjectionList {

    StudentList cage2 = new StudentList();
    ArrayList<Injection> injList = new ArrayList<Injection>();
    Scanner sc = new Scanner(System.in);

    public void createNewInj() {
        String injID;
        String firstPlace;
        String firstDate;
        String secondPlace = null;
        String secondDate = null;
        String sID;
        String vID;
        int pos;
        String check;
        long days = 0;
        do {
            do {
                injID = MyToys.getStrFormat("Input Injection ID(IDxxx): ", "Wrong format, Right format is: "
                        + "IDxxx(x is the number)", "^ID\\d{3}$").toUpperCase();
                pos = checkInjID(injID);
                if (pos >= 0) {
                    System.out.println("The ID Duplicated!!!");
                }
            } while (pos != -1);
            firstPlace = MyToys.getStr("Input first Injection Place: ", "Not empty!!!").toUpperCase();
            while (true) {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                firstDate = MyToys.getStr("Input 1st injection date (dd/MM/yyyy): ",
                        "Right format date is dd/MM/yyyy");
                df.setLenient(false);
                try {
                    df.parse(firstDate);
                    break;
                } catch (Exception e) {
                    System.out.println("INVALID DATE!!!");
                }
            }
            secondPlace = MyToys.getStr2("Input 2nd place, CAN BE BLANK: ");
            if (secondPlace == null) {
                secondDate = null;
            }
            if (secondPlace != null) {
                do {
                    System.out.println("Input second date(>4 week)!");
                    while (true) {
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        secondDate = MyToys.getStr("Input first date (Format: dd/MM/yyyy): ",
                                "The format date is dd/MM/yyyy");
                        df.setLenient(false);
                        try {
                            df.parse(secondDate);
                            break;
                        } catch (Exception e) {
                            System.out.println("INVALID DATE!!!");
                        }
                    }
                    days = checkValidDate(firstDate, secondDate);
                } while (days < 28 || days > 56);
            }
            do {
                sID = MyToys.getStrFormat("Input Student ID in List(STUxxx): ", "Wrong format, Right format is:"
                        + "STUxxx(x is the number)", "^STU\\d{3}$");
                if (cage2.isIDExist(sID)) {
                    System.out.println("The STUDENT ID NOT EXIST!!!");
                }
            } while (cage2.isIDExist(sID));
            vID = listVaccine();
            injList.add(new Injection(injID, firstPlace, secondPlace, firstDate, secondDate, sID, vID));
            check = MyToys.getStrFormat("Input 1 if you want to add more injection or 2 to return to the menu!!!",
                    "input 1/2!!!", "^1|2$").toUpperCase();
        } while (!check.equalsIgnoreCase("2"));
    }

    public void showInjectionList() {
        if (injList.isEmpty()) {
            System.out.println("The injection List is Empty!");
        } else {
            System.out.println("===THE INJECTION LIST===");
            String header = String.format("|%-12s|%-15s|%-15s|%-17s|%-17s|%-10s|%-10s|",
                    "INJECTION ID", "FIRST INJ PLACE", "FIRST INJ DATE",
                    "SECOND INJ PLACE", "SECOND INJ DATE",
                    "STUDENT ID", "VACCINCE ID");
            System.out.println(header);
            for (Injection o : injList) {
                o.printList();
            }
        }
    }

    public void delInjection() {
        String injID, check;
        int pos;
        injID = MyToys.getStrFormat("Input Injecttion ID: ", "Wrong format, Right format is: "
                + "IDxxx(x is the number)", "^ID\\d{3}$").toUpperCase();
        pos = checkInjID(injID);
        if (pos == -1) {
            System.out.println("The InjectionID NOT EXIST!!! Delete failled!!");
        } else {
            do {
                for (int i = 0; i < injList.size(); i++) {
                    if (injList.get(i).getInjID().equalsIgnoreCase(injID)) {
                        injList.get(i).display();
                    }
                }
                System.out.println("Do you really want to remove " + injID + " form the food list?");
                check = MyToys.getStrFormat("Input 1 if you want to continute remove injectionID or 2 return to the menu!!!",
                        "Input 1/2!!", "^1|2$");
                if (check.equalsIgnoreCase("1")) {
                    injList.remove(pos);
                    System.out.println("Remove sucessfully!!!");
                }
                if (check.equalsIgnoreCase("2")) {
                    System.out.println("Remove failed!!!");
                }
            } while (check.equalsIgnoreCase("1|2"));
        }
    }

    public void findInj() {
        String sID;
        if (injList.isEmpty()) {
            System.out.println("The List is empty!!!!");
            return;
        }
        sID = MyToys.getStrFormat("Input Student ID in list (STUxxx): ", "Wrong format, Right format is: "
                + "STUxxx(x is the number)", "^STU\\d{3}$").toUpperCase();
        boolean checkNExist = true;
        for (int i = 0; i < injList.size(); i++) {
            if (injList.get(i).getsID().equalsIgnoreCase(sID)) {
                injList.get(i).display();
                checkNExist = false;
            }
        }
        if (checkNExist) {
            System.out.println("The student does not exist");
        }

    }

    public void updateInj() {
        String injectionID, secondInjectionPlace, secondInjectionDate;
        int pos;
        do {
            injectionID = MyToys.getStrFormat("Input Injecttion ID: ", "Wrong format, Right format is: "
                    + "IDxxx(x is the number)", "^ID\\d{3}$").toUpperCase();
            pos = checkInjID(injectionID);
            if (pos != -1) {
                System.out.println("The ID Duplicated, Ready for update!!!");
            } else {
                System.out.println("THE ID NOT EXIST!!!");
            }
        } while (pos == -1);
        secondInjectionPlace = MyToys.getStr("Input second Injection place: ", "Not empty").toUpperCase();
        while (true) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            secondInjectionDate = MyToys.getStr("Input day of expired date(Format: dd/MM/yyyy): ",
                    "The format of expired date is dd/MM/yyyy!!");
            df.setLenient(false);
            try {
                df.parse(secondInjectionDate);
                break;
            } catch (ParseException e) {
                System.out.println("INVALID DATE!!!");
            }
        }

        for (Injection o : injList) {
            if (o.getInjID().equalsIgnoreCase(injectionID)) {
                String date1 = o.getFirstInjDate();
                System.out.println(date1);
                if (checkValidDate(date1, secondInjectionDate) > 28) {
                    o.setSecondInjPlace(secondInjectionPlace);
                    o.setSecondInjDate(secondInjectionDate);
                    System.out.println("Update Successfully!");
                } else {
                    System.out.println("Not enough 4 weeks or exceed 8 weeks. Update failed!!!");
                }
            }
        }
    }

    public void writeToInj() {
        try {
            FileWriter fw = new FileWriter("injectionList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Injection o : injList) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadFromInj() {
        try {
            FileReader f = new FileReader("injectionList.txt");
            BufferedReader b = new BufferedReader(f);
            Scanner o = new Scanner(f);
            while (o.hasNextLine()) {
                String data = o.nextLine();
                String[] split = data.split(",");
                String injectionId = split[0];
                String firstInjPlace = split[1];
                String secondInjPlace = split[2];
                String firstInjDate = split[3];
                String secondInjDate = split[4];
                String studentId = split[5];;
                String vaccineId = split[6];;
                injList.add(new Injection(injectionId, firstInjPlace, secondInjPlace,
                        firstInjDate, secondInjDate, studentId, vaccineId));
            }
            b.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int checkInjID(String ID) {
        for (int i = 0; i < injList.size(); i++) {
            if (injList.get(i).getInjID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public String listVaccine() {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Choice vaccine: ");
        System.out.println("1. AstraZeneca");
        System.out.println("2. SPUTNIK V");
        System.out.println("3. Vero Cell");
        System.out.println("4. Pfizer");
        System.out.println("5. Moderna");
        choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                return "Covid-V001";
            case 2:
                return "Covid-V002";
            case 3:
                return "Covid-V003";
            case 4:
                return "Covid-V004";
            case 5:
                return "Covid-V005";

        }
        return null;
    }

    public long checkValidDate(String date1, String date2) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        long days = 0;
        try {
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            long getTime = d2.getTime() - d1.getTime();
            days = getTime / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        return days;
    }

}
