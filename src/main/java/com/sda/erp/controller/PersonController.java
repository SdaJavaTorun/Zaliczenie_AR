package com.sda.erp.controller;

import com.sda.erp.model.IntPersonModel;
import com.sda.erp.model.PersonModel;
import com.sda.erp.view.PersonView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonController implements IntPersonModel, Serializable {

    private PersonView personV;
    private ReadWriteObjectToFile operFile;

    PersonModel personM = new PersonModel();
    UserInput userInput = new UserInput();
    Scanner in = new Scanner(System.in);

    List<PersonController> modelList = new ArrayList<>();

    public PersonController () {}

    public PersonController (PersonModel personM, PersonView personV) {
        this.personM = personM;
        this.personV = personV;
    }

    public void exportToTXTFile() throws Exception {
        System.out.println("Export: Podaj nazwę pliku");
        String fileName = in.nextLine();
        ReadWriteObjectToFile.writeToTXTFile(fileName, modelList);
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

    public void setPersonAge (int age) {
        personM.setAge(age);
    }

    public int getPersonAge () {
        return personM.getAge();
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
    public void removePerson() {
        printFullList();
        System.out.println ("\nKtórego pracownika usunąć? Podaj numer...");
        int id = in.nextInt();
        modelList.remove(id+1);
        printFullList();
    }

    @Override
    public void editPerson() {

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
}
