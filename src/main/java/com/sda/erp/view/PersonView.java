package com.sda.erp.view;

import com.sda.erp.controller.PersonController;

import java.util.List;

public class PersonView {

    public void printPerson (int id, String firstName, String lastName, int age) {
        System.out.print("Nr " + id);
        System.out.print(" Imię " + firstName);
        System.out.print(" Nazwisko " + lastName);
        System.out.println(" Wiek " + age);
    }

    public void printAllPerson(List<PersonController> modelList) {
        modelList.stream().forEach(System.out::println);
    }

}
