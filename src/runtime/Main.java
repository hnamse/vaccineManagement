package runtime;

import data.InjectionList;
import data.StudentList;
import data.VaccineList;
import tools.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu("-FOOD MANAGEMENT-");
        menu.addNewOption("1. Show information all students have been injected.");
        menu.addNewOption("2. Add student's information to vaccine injection.");
        menu.addNewOption("3. Updating information of students' vaccine injection");
        menu.addNewOption("4. Delete student vaccine injection information");
        menu.addNewOption("5. Search for injection information by studentID");
        menu.addNewOption("6. Save and Quit!!!");

        System.out.println("Welcome to Vaccine Management - @2021 by <THUAN LE>");
        InjectionList cage1 = new InjectionList();
        StudentList cage2 = new StudentList();
        VaccineList cage3 = new VaccineList();
        
        int choice;
        cage2.saveToStudent();
        cage2.loadStudent();
        cage3.loadVaccine();
        cage1.loadFromInj();
        cage2.printStuList();
        cage3.printVaccineList();
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    cage1.showInjectionList();
                    break;
                }
                case 2: {
                    cage1.createNewInj();
                    break;
                }
                case 3: {
                    cage1.updateInj();
                    break;
                }
                case 4: {
                    cage1.delInjection();
                    break;
                }
                case 5: {
                    cage1.findInj();
                    break;
                }
                case 6: {
                    cage1.writeToInj();
                    System.out.println("BYE!!!");
                }
            }
        } while (choice != 6);
    }
}
