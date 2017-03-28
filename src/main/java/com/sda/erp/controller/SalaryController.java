package com.sda.erp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SalaryController {

    static List<ListController> salaryList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public SalaryController () {}

    public void setSalaryList (List<ListController> salaryList) {
        SalaryController.salaryList = salaryList;
    }

    public void countPeopleWithHiSalary (float s) {
        int counter = 0;
        for (ListController sl: salaryList) {
            if (sl.getSalary() >= s) counter++;
        }
        System.out.println(
                "Liczba pracowników z pensją nie niższą niż " + s + " wynosi: " + counter);
    }

    public float averageSalaryInDepartment (int dep) {
        float sumSal = 0;
        int counter = 0;
        float result = 0;

        for (ListController sl: salaryList) {
            if (sl.getDepartmentNr() == dep) {
                sumSal = sumSal + sl.getSalary();
                counter++;
            }
            System.out.println("Średnia pensja w dziale wynosi" + sumSal/(float)counter);
        }
        return result;
    }

    public void maxSalaryWM () {
        float maxW = 0;
        float maxM = 0;

        for (ListController sl: salaryList) {
            if (sl.getPersonGender() == 'K') if (sl.getSalary() > maxW) maxW = sl.getSalary();
            if (sl.getPersonGender() == 'M') if (sl.getSalary() > maxM) maxM = sl.getSalary();
        }
        System.out.println("Najwyższa pensja kobieca: " + maxW + "zł, a męska: " + maxM + "zł");
    }
    /**
     * *d) Wyświetlenie wszystkich działów (tylko tych, które aktualnie mają pracowników) i informacji,
     * czy większość pracowników jest kobietami, mężczyznami, czy ich liczba rozkłada się równomiernie.
     * Do tego, przy każdym dziale wyświetlana zostaje średnia pensja w tym dziale
     * (można skorzystać z funkcji napisanej na potrzeby podpunktu 'b)' // procedura bez dodatkowych parametrów.
     */
    public void depWMplusAvSal () {
        int sumaW = 0;
        int sumaM = 0;
        for (ListController sl: salaryList) {
            if (sl.getDepartmentNr() != 0) {
                if (sl.getPersonGender() == 'K') sumaW++;
                else sumaM++;
            }
            if (sumaM > sumaW) {
                System.out.printf("W dziale %s pracuje więcej mężczyzn. Średnia płaca wynosi: %s%n", sl.getDepartmentName(), averageSalaryInDepartment(sl.getDepartmentNr()));
            } else if (sumaM < sumaW) {
                System.out.println("W dziale " + sl.getDepartmentName() + " pracuje więcej kobiet" + averageSalaryInDepartment(sl.getDepartmentNr()));
            } else {
                System.out.println("W dziale " + sl.getDepartmentName() + " kobiet i meżczyzn jest tylu samo" + averageSalaryInDepartment(sl.getDepartmentNr()));
            }
        }
    }

    public void averWMSalary () {
        float sumW = 0;
        float sumM = 0;
        for (ListController sl: salaryList) {
            if (sl.getPersonGender() == 'K') sumW = sumW + sl.getSalary();
            else sumM = sumM + sl.getSalary();
        }
        System.out.println("Stosunek pencji kobiety/faceci wynosi: " + sumW/sumM);
    }

    public void setSalaryRaise (float rise) {
        System.out.println("O ile podniesc pensje pracownikow?");
        for (ListController sl: salaryList) {
            float percent = 0f;
            percent = (rise * 100) / sl.getSalary();

            if (sl.isPersonMarital()) percent = percent + 3;
            if (sl.getPersonKids() != 0) percent = (percent + 2) * sl.getSalary();

            System.out.println("Pensja podwyższona o procent: " + percent);
            sl.setSalary(sl.getSalary() + percent * sl.getSalary() / 100);
        }
    }
    public void changeSalary (int id) {
        System.out.println("Podaj nową płacę");
        salaryList.get(id-1).setSalary(in.nextFloat());
    }

    public void riseSalaryAll() {
        System.out.println("O ile podnieść płacę wszystkim pracownikom?");
        for (ListController sc: salaryList)
            sc.setSalary(sc.getSalary() + in.nextFloat());
    }
}
