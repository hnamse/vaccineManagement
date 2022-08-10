/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ASUS
 */
public class Injection {

    private String injID;
    private String firstInjPlace;
    private String secondInjPlace;
    private String firstInjDate;
    private String secondInjDate;
    private String sID;
    private String vID;

    public Injection() {
    }
    public Injection(String injID, String firstInjPlace, String secondInjPlace, String firstInjDate, String secondInjDate, String sID, String vID) {
        this.injID = injID;
        this.firstInjPlace = firstInjPlace;
        this.secondInjPlace = secondInjPlace;
        this.firstInjDate = firstInjDate;
        this.secondInjDate = secondInjDate;
        this.sID = sID;
        this.vID = vID;
    }

    public String getInjID() {
        return injID;
    }

    public void setInjID(String injID) {
        this.injID = injID;
    }

    public String getFirstInjPlace() {
        return firstInjPlace;
    }

    public void setFirstInjPlace(String firstInjPlace) {
        this.firstInjPlace = firstInjPlace;
    }

    public String getSecondInjPlace() {
        return secondInjPlace;
    }

    public void setSecondInjPlace(String secondInjPlace) {
        this.secondInjPlace = secondInjPlace;
    }

    public String getFirstInjDate() {
        return firstInjDate;
    }

    public void setFirstInjDate(String firstInjDate) {
        this.firstInjDate = firstInjDate;
    }

    public String getSecondInjDate() {
        return secondInjDate;
    }

    public void setSecondInjDate(String secondInjDate) {
        this.secondInjDate = secondInjDate;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getvID() {
        return vID;
    }

    public void setvID(String vID) {
        this.vID = vID;
    }

    @Override
    public String toString() {
        return injID + ","
                + firstInjPlace + "," + secondInjPlace
                + "," + firstInjDate + ","
                + secondInjDate + "," + sID + "," + vID;
    }

    public void display() {
        System.out.println("Injection ID: " + injID + "|1st Injection Place: " + firstInjPlace
                + "|1st Injection Date: " + firstInjDate + "|2nd Injection Place: " + secondInjPlace
                + "|2nd Injection Date: " + secondInjDate
                + "|Student ID: " + sID + "|Vaccine ID: " + vID);
    }
    
    public void printList(){
        System.out.printf("|%-12s|%-15s|%-15s|%-17s|%-17s|%-10s|%-10s|\n", 
                injID, firstInjPlace, 
                firstInjDate, secondInjPlace, 
                secondInjDate, sID,vID);
    }
}
