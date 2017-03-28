package com.sda.erp.controller;

import java.util.Scanner;
import com.sda.erp.model.DepartmentModel;

public class UserInput {

    public ListController populatePerson() {

        ListController listController = new ListController();
        Scanner in = new Scanner(System.in);

        listController.setPersonId();
        System.out.println("Podaj imie pracownika: ");
        String firstN = in.nextLine();
        listController.setPersonFirstName(
                            firstN.substring(0,1).toUpperCase()
                            + firstN.substring(1).toLowerCase());
        System.out.println("Podaj nazwisko pracownika: ");
        String lastN = in.nextLine();
        listController.setPersonLastName(
                            lastN.substring(0,1).toUpperCase()
                            + lastN.substring(1).toLowerCase());
        System.out.println("Podaj płeć:");
        listController.setPersonGender(in.next().charAt(0));
        System.out.println("Podaj wiek pracownika:");
        listController.setPersonAge(in.nextInt());
        System.out.println("Podaj pensje:");
        listController.setSalary(in.nextFloat());
        System.out.println("Podaj dział: 1 - IT, 2 - HR, 3 - Produkcja, 4 - Sprzedaż");
        switch (in.nextInt()) {
            case 1: listController.setDepartmentName("IT"); break;
            case 2: listController.setDepartmentName("HR"); break;
            case 3: listController.setDepartmentName("PRODUCTION"); break;
            case 4: listController.setDepartmentName("SALES"); break;
        }
        return listController;
    }
}
