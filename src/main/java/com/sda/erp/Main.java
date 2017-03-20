package com.sda.erp;

import com.sda.erp.controller.PersonController;
import com.sda.erp.model.*;
import com.sda.erp.view.GUI;
import com.sda.erp.view.PersonView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int option = 0;
        boolean optionFlag = true;

        PersonModel personM = new PersonModel();
        PersonView personV = new PersonView();
        PersonController personC = new PersonController(personM, personV);
        Scanner in = new Scanner(System.in);

        while (optionFlag) {
            System.out.println(GUI.systemInfo());
            GUI.showMenu();
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
                case 1:
                    personC.toStringShort();
                    break;
                case 2:
                    personC.addPerson();
                    break;
                case 3:
                    personC.exportToTXTFile();
                    break;
                case 4:
                    // po wyswietleniu wszystkich pracownikow nastepuje usuniecie podanego pracownika
                    personC.removePerson();
                    break;
                case 5:
                    //"5. Edycja danych pracownika\n" +
                    System.out.println("TODO");
                    //personC.editPerson();
                    break;
                case 6:
                    // "6. Przejście do podmenu 1...\n" +
                    GUI.showSubMenu1();
                    break;
                case 7:
                    //"7. Export danych i przejście do podmenu 2...\n" +
                    GUI.showSubMenu2();
                    break;
                case 8:
                    // "8. Informacja o systemie\n" +
                    GUI.systemInfo();
                    break;
                case 0:
                    optionFlag = false;
                    break;
            }
        }
    }
}
