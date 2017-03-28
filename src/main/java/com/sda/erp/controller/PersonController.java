package com.sda.erp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class PersonController {

    private EditPersonMenu editPerson = new EditPersonMenu();
    private ReadWriteObjectToFile readWriteObjectToFile = new ReadWriteObjectToFile();
    private Scanner in = new Scanner(System.in);

    /**
     * an ArrayList to get main list
     */
    static List<ListController> personList = new ArrayList<>();

    public PersonController () {}

    public void setPersonList(List<ListController> personList) {
        PersonController.personList = personList;
    }

    List<ListController> sortList = personList;

    public void setReadWriteObjectToFile () {
        readWriteObjectToFile.setListToFile(personList);
    }

    public void editPersonMenu() throws Exception {
        printFullList();
        editPerson.editMenu();
    }

    public void printFullList () {
        System.out.println("Lista pełna pracowników");
        System.out.println("|-----------------------------------------------------|");
        System.out.printf("%-4s %-20s %-20s %-4s %-13s %-5s %-10s" , "Id", "Imię", "Nazwisko", "Wiek", "Płaca", "Płeć", "Dział");
        for (ListController lc: personList)
            System.out.printf("\n%-4d %-20s %-20s %-4d %-10.2f zł %-5s %-10s\n",
                    lc.getPersonId(), lc.getPersonFirstName(),
                    lc.getPersonLastName(), lc.getPersonAge(),
                    lc.getSalary() , lc. getPersonGender(), lc.getDepartmentName());
    }

    public void changeLastName(int id) {

        if (personList.get(id-1).getPersonGender() == 'K') {
            System.out.println("Podaj nowe nazwisko...");
            personList.get(id-1).setPersonLastName(in.nextLine());
        }
        else System.out.println("Nie kobiecie nie da rady zmienić nazwiska");
    }

    public void changeAge(int id) {
        System.out.println("Podaj nowy wiek pracownika...");
        personList.get(id-1).setPersonAge(in.nextInt());
    }

    public void changeMaritalStatus(int id) {
        System.out.println("If Rozwodzik/Wdodzik press 'R' czy nowy związek press 'Z'");
        if (in.next().charAt(0) == 'R')
            personList.get(id-1).setPersonMarital(false);
        else personList.get(id-1).setPersonMarital(true);
    }

    public void changeKids(int id) {
        System.out.println("Podaj liczbę dzieci");
        personList.get(id-1).setPersonKids(in.nextInt()
                + personList.get(id-1).getPersonKids());
    }

    public void sortByLastNameInFile(boolean dir) throws Exception {

        readWriteObjectToFile.setListToFile(sortList);

        if (dir == true) { // sortowanie rosnąco
            sortList.sort(Comparator.comparing(ListController::getPersonLastName));
            ReadWriteObjectToFile.writeToTXTFile("SortOrder.txt");
        }
        else {  // sortowanie malejąco
            sortList.sort(Comparator.comparing(ListController::getPersonLastName).reversed());
            ReadWriteObjectToFile.writeToTXTFile("SortRevOrd");
        }
    }

    public void exportToTXTFile() throws Exception {
        System.out.println("Export: Podaj nazwę pliku");
        String fileName = in.nextLine();
        ReadWriteObjectToFile.writeToTXTFile(fileName);
    }

    public void removePerson() {
        printFullList();
        System.out.println ("\nKtórego pracownika usunąć? Podaj numer...");
        int id = in.nextInt();
        personList.remove(id-1);
        printFullList();
    }

    public void averageAgeWithKids() {
        float ageSum = 0f;
        int counter = 0;

        for (ListController aa: personList) {
            if (aa.getPersonKids() != 0) {
                ageSum = ageSum + (float)aa.getPersonAge();
                counter++;
            }
        }
        // liczymy srednia i wypisujemy
        System.out.println("Średnia wieku osób posiadającyh dzieci:" + ageSum/counter);
    }
}
