package com.sda.erp.controller;

import com.sda.erp.model.PersonModel;
import com.sda.erp.model.SalaryModel;
import com.sda.erp.view.GUI;
import com.sda.erp.view.PersonView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EditPersonMenu {

    public void editMenu(List<PersonController> modelList) throws Exception {

        int option = 0;
        PersonModel personM = new PersonModel();
        PersonView personV = new PersonView();
        EditPersonMenu ePersonM = new EditPersonMenu();
        SalaryModel salaryM = new SalaryModel();
        PersonController personC = new PersonController(personM, personV, ePersonM, salaryM);
        Scanner in = new Scanner(System.in);

        boolean optionFlag = true;

        while (optionFlag) {
            System.out.println("\nPodaj nr pracownka, którego chcesz edytować:");
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
                case 1: personC.changeLastName(number, modelList); break;
                case 2: personC.changeAge(number, modelList); break;
                case 3: personC.changeSalary(number, modelList); break;
                case 4: personC.changeDepartment(number, modelList); break;
                case 5: personC.changeMaritalStatus(number, modelList); break;
                case 6: personC.changeKids(number, modelList); break;
                case 0: optionFlag = false; break;
            }
        }
    }
}
