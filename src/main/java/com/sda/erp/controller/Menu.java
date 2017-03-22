package com.sda.erp.controller;

import com.sda.erp.model.PersonModel;
import com.sda.erp.model.SalaryModel;
import com.sda.erp.view.GUI;
import com.sda.erp.view.PersonView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void mainMenu () throws Exception {
        int option = 0;
        PersonModel personM = new PersonModel();
        PersonView personV = new PersonView();
        EditPersonMenu ePersonM = new EditPersonMenu();
        SalaryModel salaryM = new SalaryModel();
        PersonController personC = new PersonController(personM, personV, ePersonM, salaryM);
        Scanner in = new Scanner(System.in);

        boolean optionFlag = true;

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
                case 1: personC.toStringShort(); break;
                case 2: personC.addPerson(); break;
                case 3: personC.exportToTXTFile(); break;
                case 4: personC.removePerson(); break;
                case 5: personC.editPersonMenu(); break;
                case 6: GUI.showSubMenu1(); break;
                case 7: GUI.showSubMenu2(); break;
                case 8: GUI.systemInfo(); break;
                case 0: optionFlag = false; break;
            }
        }
    }
}
