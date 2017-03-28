package com.sda.erp.controller;

import com.sda.erp.view.GUI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void mainMenu () throws Exception {
        int option = 0;
        ListController listController = new ListController();
        PersonController personController = new PersonController();
        Scanner in = new Scanner(System.in);
        listController.setReadWriteObjectToFile();

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
                case 1: listController.toStringShort(); break;
                case 2: listController.addPersonToList(); break;
                case 3: personController.exportToTXTFile(); break;
                case 4: personController.removePerson(); break;
                case 5: listController.setPersonController();
                        listController.setSalaryController();

                        personController.editPersonMenu(); break;
                case 6: SubMenu1.Menu(); break;
                case 7: SubMenu2.Menu(); break;
                case 8: GUI.systemInfo(); break;
                case 0: optionFlag = false; break;
            }
        }
    }
}
