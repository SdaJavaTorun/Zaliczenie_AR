package com.sda.erp.controller;

import com.sda.erp.model.PersonModel;
import com.sda.erp.model.SalaryModel;
import com.sda.erp.view.PersonView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EditPersonMenu {

    public void editMenu () throws Exception {

        int option = 0;
        //PersonModel personM = new PersonModel();
        //PersonView personV = new PersonView();
        //EditPersonMenu ePersonM = new EditPersonMenu();
        //SalaryModel salaryM = new SalaryModel();
        PersonController personC = new PersonController();
        Scanner in = new Scanner(System.in);

        boolean optionFlag = true;

        while (optionFlag) {
            System.out.println("\nPodaj nr pracownka, którego chcesz edytować:");
            int number = in.nextInt();
            System.out.println("Co edytować u pracownika:\n" +
                                "1. Zmiana nazwiska (dla kobiet tylko)\n" +
                                "2. Zmiana wieku\n" +
                                "3. Zmiana płacy\n" +
                                "4. Zmiana działu\n" +
                                "5. Zmiana stanu cywilnego\n" +
                                "6. Zmiana liczby dzieci\n" +
                                "0. Wyjście do menu głównego"
            );
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
                    personC.changeLastName(number);
                    break;
                case 2:
                    personC.changeAge(number);
                    break;
                case 3:
                   // personC.changeSalary();
                    break;
                case 4:
                   // personC.changeDepartment();
                    break;
                case 5:
                    personC.changeMaritalStatus(number);
                    break;
                case 6:
                    personC.changeKids(number);
                    break;
                case 0:
                    optionFlag = false;
                    break;
            }
        }
    }
}
