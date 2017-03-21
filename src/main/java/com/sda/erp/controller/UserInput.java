package com.sda.erp.controller;

import com.sda.erp.model.PersonModel;

import java.util.Scanner;

/* Created by Artur Rózgowski on 3/18/17 */
public class UserInput {
    public PersonController populatePerson() {
        PersonController personC = new PersonController();
        //Department department = new Department();
        personC.setPersonId();
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj imie pracownika: ");
        personC.setPersonFirstName(in.nextLine());
        System.out.println("Podaj nazwisko pracownika: ");
        personC.setPersonLastName(in.nextLine());
        System.out.println("Podaj wiek pracownika:");
        personC.setPersonAge(in.nextInt());
        //System.out.println("Podaj pensje:");
        //personC.setSalary(in.nextFloat());

        return personC;
    }
}
