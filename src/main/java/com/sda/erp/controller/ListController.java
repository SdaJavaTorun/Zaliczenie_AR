package com.sda.erp.controller;

import com.sda.erp.model.DepartmentModel;
import com.sda.erp.model.PersonModel;
import com.sda.erp.model.SalaryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to maintains a main list built with object from model package
 */

public class ListController {
    private PersonModel personM = new PersonModel();
    private SalaryModel salaryM = new SalaryModel();
    private DepartmentModel deparM = new DepartmentModel();
    private UserInput userInput = new UserInput();
    private PersonController personController = new PersonController();
    private SalaryController salaryController = new SalaryController();
    //private DepartController departController = new DepartController();
    private ReadWriteObjectToFile readWriteObjectToFile = new ReadWriteObjectToFile();

    /**
     * Main list of program
     */
    private List<ListController> listControllers = new ArrayList<>();

    public ListController(){}

    public List<ListController> getListControllers() { return this.listControllers; }
    public void setListControllers(List<ListController> listControllers) { this.listControllers = listControllers; }

    public void addPersonToList () {
        this.listControllers.add(userInput.populatePerson());
    }

    public void setPersonId() { personM.setId(); }
    public int getPersonId () { return personM.getId(); }

    public void setPersonFirstName (String name) { personM.setFirstName(name); }
    public void setPersonLastName (String lastName) { personM.setLastName(lastName); }

    public String getPersonFirstName () { return personM.getFirstName(); }
    public String getPersonLastName () { return personM.getLastName(); }

    public void setPersonAge (int age) { personM.setAge(age); }
    public int getPersonAge () { return personM.getAge(); }

    public void setPersonKids (int age) { personM.setKids(age); }
    public int getPersonKids () { return personM.getKids(); }

    public void setPersonMarital (boolean tf) { personM.setMarital(tf); }
    public boolean isPersonMarital () { return personM.isMarital (); }

    public void setPersonGender (char g) { personM.setGender(g); }
    public char getPersonGender () { return personM.getGender(); }

    public float getSalary () { return salaryM.getSalary(); }
    public void setSalary (float s) { salaryM.setSalary(s); }

    public int getDepartmentNr () { return deparM.getDepartmentNo(); }
    public void setDepartmentNr (int dep) { deparM.setDepartmentNo(dep); }

    public String getDepartmentName () { return deparM.getDepartmentName(); }
    public void setDepartmentName (String depName) { deparM.setDepartmentName(depName); }

    /**
     * pass main list to other controller class
     */
    public void setPersonController () {
        personController.setPersonList(listControllers); }
    public void setSalaryController () {
        salaryController.setSalaryList(listControllers); }
    public void setReadWriteObjectToFile () {
        readWriteObjectToFile.setListToFile(listControllers); }

    @Override
    public String toString () {
        return String.format("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n",
                this.getPersonId(), this.getPersonFirstName(),
                this.getPersonLastName(), this.getPersonAge());
    }

    public void toStringShort() {
        System.out.println("Skrócona wersja listy pracowników");
        System.out.println("|-----------------------------------------------------|");
        System.out.printf("%-4s %-20s %-20s %-10s", "Id", "Imię", "Nazwisko", "Płaca\n");
        for (ListController pc: listControllers)
            System.out.printf("\n%-4d %-20s %-20s %-10.2f zł",
                    pc.getPersonId(), pc.getPersonFirstName(),
                    pc.getPersonLastName(), pc.getSalary());
    }

    public String toStringUpper() {
        return null;
    }

    public void toStringUpper(int index) {
        System.out.println(listControllers.get(index).getPersonFirstName().toUpperCase());
        System.out.println(listControllers.get(index).getPersonLastName().toUpperCase());
    }

}
