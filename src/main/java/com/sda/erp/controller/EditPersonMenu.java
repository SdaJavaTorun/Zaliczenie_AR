package com.sda.erp.controller;

import com.sda.erp.view.GUI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EditPersonMenu {
    /**
     * constructor without arguments
     */
    public EditPersonMenu () {}

    public void editMenu() throws Exception {

        Scanner in = new Scanner(System.in);

        PersonController personController = new PersonController();
        SalaryController salaryController = new SalaryController();
        DepartController departController = new DepartController();

        boolean optionFlag = true;
        int option = 0;

        while (optionFlag) {
            System.out.println("\nPodaj nr pracownika, którego chcesz edytować:");
            int number = in.nextInt();
            GUI.showEditMenu();
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
                case 1: personController.changeLastName(number); break;
                case 2: personController.changeAge(number); break;
                case 3: salaryController.changeSalary(number); break;
                case 4: departController.changeDepartment(number); break;
                case 5: personController.changeMaritalStatus(number); break;
                case 6: personController.changeKids(number); break;
                case 0: optionFlag = false; break;
            }
        }
    }
}
