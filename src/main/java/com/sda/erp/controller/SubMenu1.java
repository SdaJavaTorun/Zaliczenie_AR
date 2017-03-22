package com.sda.erp.controller;

import com.sda.erp.view.GUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenu1 {
    public void editMenu () throws Exception {

        int option = 0;
        PersonController personC = new PersonController();
        Scanner in = new Scanner(System.in);

        boolean optionFlag = true;

        while (optionFlag) {
            System.out.println("\nPodaj nr pracownka, którego chcesz edytować:");
            int number = in.nextInt();
            System.out.println("Podmenu 1:\n" +
                    "1. Liczba pracowników z pensją nie mniejszą niż podana\n" +
                    "2. Średnia płaca w podanym dziale\n" +
                    "3. Najlepiej zarabiający: Pani i Pan\n" +
                    "4. *Wszystkie działy + stosunek kobiety/mężczyźni + średnia pensja w dziale\n" +
                    "5. Zwiększ płace pracowników o 10% + extra dodatki\n" +
                    "6. *Zwiększ pensje wszystkich o podaną kwotę\n" +
                    "7. Sortowanie pracowników według nazwiska w pliku - roznąco/malejąco\n" +
                    "8. Sortowanie pracowników według pensji w pliku - roznąco/malejąco\n" +
                    "0. Wyjście do menu głównego"
            );
            GUI.showSubMenu1();
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
                    //personC.changeLastName(number, modelList);
                    break;
                case 2:
                    //personC.changeAge(number);
                    break;
                case 3:
                    // personC.changeSalary();
                    break;
                case 4:
                    // personC.changeDepartment();
                    break;
                case 5:
                    //personC.changeMaritalStatus(number);
                    break;
                case 6:
                    //personC.changeKids(number);
                    break;
                case 7:

                    break;

                case 8:

                    break;
                case 0:
                    optionFlag = false;
                    break;
            }
        }
    }
}
