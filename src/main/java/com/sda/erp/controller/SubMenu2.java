package com.sda.erp.controller;

import com.sda.erp.view.GUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenu2 {

    public static void Menu () throws Exception {

        int option = 0;
        PersonController personController = new PersonController();
        ReadWriteObjectToFile readWriteObjectToFile = new ReadWriteObjectToFile();
        Scanner in = new Scanner(System.in);
        String fileName = "baza.dat";

        boolean optionFlag = true;

        while (optionFlag) {
            GUI.showSubMenu2();
            boolean flag = true;

            while (flag) {
                try {
                    option = in.nextInt();
                    flag = false;
                } catch (InputMismatchException e) {
                    System.out.println("Podaj prawidłową wartość menu");
                    in.next();
                }
            }
            switch (option) {
                case 1: //"1. Wyswietlanie danych o osbie z najdluzszym nazwiskiem\n" +
                    readWriteObjectToFile.showDataLongestLastName();
                    break;
                case 2: //"2. Średni wiek osob z dziecmi\n" +
                    personController.averageAgeWithKids();
                    break;
                case 3: //"3. Kodowanie danych z pliku" +
                    readWriteObjectToFile.dataCoding (fileName);
                    break;
                case 4: //  "4. *Plik HTML" +
                    readWriteObjectToFile.writeToHTMLFile();
                    break;
                case 0:
                    optionFlag = false;
                    break;
            }
        }
    }
}
