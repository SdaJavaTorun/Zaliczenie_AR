package com.sda.erp.controller;

import com.sda.erp.model.IntPersonModel;
import com.sda.erp.model.PersonModel;
import com.sda.erp.model.SalaryModel;
import com.sda.erp.view.PersonView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonController implements IntPersonModel, Serializable {

    //private PersonView personV;

    private PersonModel personM = new PersonModel();
    private EditPersonMenu ePersonM = new EditPersonMenu();
    PersonView personV;
    private SalaryModel salaryM = new SalaryModel();
    private UserInput userInput = new UserInput();
    private Scanner in = new Scanner(System.in);

    private List<PersonController> modelList = new ArrayList<>();

    public PersonController () {}

    public PersonController (PersonModel personM,
                             PersonView personV,
                             EditPersonMenu ePersonM,
                             SalaryModel salaryM) {
        this.personM = personM;
        this.personV = personV;
        this.ePersonM = ePersonM;
        this.salaryM = salaryM;
    }

    public void exportToTXTFile() throws Exception {
        System.out.println("Export: Podaj nazwę pliku");
        String fileName = in.nextLine();
        ReadWriteObjectToFile.writeToTXTFile(fileName, modelList);
    }

    public void countPeopleWithHiSalary (float s) {
        int counter = 0;
        for (PersonController pc: modelList) {
            if (pc.getSalary() >= s) counter++;
        }
        System.out.println(
                "Liczba pracowników z pensją nie niższą niż " + s + " wynosi: " + counter);
    }

    public void addPerson () {
        modelList.add(userInput.populatePerson());
    }

    public void setPersonId() { personM.setId(); }
    public int getPersonId () { return personM.getId(); }

    public void setPersonFirstName (String name) {
        personM.setFirstName(name);
    }
    public void setPersonLastName (String lastName) {
        personM.setLastName(lastName);
    }

    public String getPersonFirstName () {
        return personM.getFirstName();
    }
    public String getPersonLastName () {
        return personM.getLastName();
    }

    public void setPersonAge (int age) { personM.setAge(age); }
    public int getPersonAge () {
        return personM.getAge();
    }

    public void setPersonKids (int age) {
        personM.setKids(age);
    }
    public int getPersonKids () {
        return personM.getKids();
    }

    public void setPersonMarital (boolean tf) { personM.setMarital(tf); }
    public boolean isPersonMarital () { return personM.isMarital (); }

    public void setPersonGender (char g) { personM.setGender(g); }
    public char getPersonGender () { return personM.getGender(); }

    public float getSalary () { return salaryM.getSalary(); }
    public void setSalary (float s) { salaryM.setSalary(s);}

    public void editPersonMenu() throws Exception {
        printFullList();
        ePersonM.editMenu();
    }

    public void changeLastName (int id) {
        if (modelList.get(id+1).getPersonGender() == 'K') {
            System.out.println("Podaj nowe nazwisko...");
            modelList.get(id+1).setPersonLastName(in.nextLine());
        }
    }

    public void changeAge (int id) {
        System.out.println("Podaj nowy wiek pracownika...");
        modelList.get(id).setPersonAge(in.nextInt());
    }

    public void changeMaritalStatus(int id) {
        System.out.println("If Rozwodzik/Wdodzik press 'R' czy nowy związek press 'Z'");
        if (in.next().charAt(0) == 'R')
            modelList.get(id+1).setPersonMarital(false);
        else modelList.get(id+1).setPersonMarital(true);
    }

    public void changeKids (int id) {
        System.out.println("Podaj liczbę dzieci");
        modelList.get(id+1).setPersonKids(in.nextInt() + modelList.get(id+1).getPersonKids());
    }
/*
    personC.changeSalary();
                    break;
                case 4:
                    personC.changeDepartment();
                    break;
*/


    public void removePerson() {
        printFullList();
        System.out.println ("\nKtórego pracownika usunąć? Podaj numer...");
        int id = in.nextInt();
        modelList.remove(id-1);
        printFullList();
    }

    public void printFullList () {
        System.out.println("Lista pełna pracowników");
        System.out.println("|-----------------------------------------------------|");
        System.out.printf("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n");
        for (PersonController pc: modelList)
            System.out.printf("\n%-4d %-20s %-20s %-4d",
                    pc.getPersonId(), pc.getPersonFirstName(),
                    pc.getPersonLastName(), pc.getPersonAge());
    }

    @Override
    public String toString () {
        return String.format("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n",
                            this.getPersonId(), this.getPersonFirstName(),
                            this.getPersonLastName(), this.getPersonAge());
    }

    public void toStringShort() {
        System.out.println("Skrócona wersja listy pracowników");
        System.out.println("|-----------------------------------------------------|");
        System.out.printf("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n");
        for (PersonController pc: modelList)
                                System.out.printf("\n%-4d %-20s %-20s %-4d",
                                pc.getPersonId(), pc.getPersonFirstName(),
                                pc.getPersonLastName(), pc.getPersonAge());
    }

    @Override
    public String toStringUpper() {
        return null;
    }

    @Override
    public void toStringUpper(int index) {
        System.out.println(modelList.get(index).getPersonFirstName().toUpperCase());
        System.out.println(modelList.get(index).getPersonLastName().toUpperCase());
    }
}
