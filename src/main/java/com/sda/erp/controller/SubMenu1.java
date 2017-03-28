package com.sda.erp.controller;

import com.sda.erp.view.GUI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenu1 {
    public static void Menu () throws Exception {

        int option = 0;
        PersonController personController = new PersonController();
        SalaryController salaryController = new SalaryController();
        ReadWriteObjectToFile readWriteObjectToFile = new ReadWriteObjectToFile();
        Scanner in = new Scanner(System.in);

        boolean optionFlag = true;

        while (optionFlag) {
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
                case 1: //"1. Liczba pracowników z pensją nie mniejszą niż podana\n" +
                    System.out.println
                            ("Podaj wyskość pensji, żeby sprawdzić ilu zarabia więcej lub tyle samo");
                    salaryController.countPeopleWithHiSalary(in.nextFloat());
                    break;
                case 2: //"2. Średnia płaca w podanym dziale\n" +
                    System.out.println("Podaj nr działu to policzenia średniej pensji");
                    salaryController.averageSalaryInDepartment(in.nextInt());
                    break;
                case 3: //"3. Najlepiej zarabiający: Pani i Pan\n" +
                    salaryController.maxSalaryWM ();
                    break;
                case 4: //  "4. *Wszystkie działy + stosunek kobiety/mężczyźni + średnia pensja w dziale\n" +
                    salaryController.depWMplusAvSal();
                    break;
                case 5: // 5. średnia płaca kobiet do średniej płacy facetów
                    salaryController.averWMSalary();
                    break;
                case 6: //"6. Zwiększ płace pracowników o 10% + extra dodatki\n" +
                    System.out.println("O ile podniesc pensje pracownikow?");
                    salaryController.setSalaryRaise(in.nextFloat());
                    break;
                case 7: // "7. *Zwiększ pensje wszystkich o podaną kwotę\n" +
                    salaryController.riseSalaryAll();
                    break;
                case 8: // "8. Sortowanie pracowników według nazwiska w pliku - roznąco/malejąco\n" +
                    personController.sortByLastNameInFile(false);
                    break;
                case 9: // "9. Sortowanie pracowników według pensji w pliku - roznąco/malejąco\n" +
                    readWriteObjectToFile.sortBySalaryInFile(false);
                    break;
                case 0:
                    optionFlag = false;
                    break;
            }
        }
    }
}
