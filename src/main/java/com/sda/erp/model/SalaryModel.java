package com.sda.erp.model;

public class SalaryModel {

    private float salary;

    //private PersonModel person;

    public SalaryModel () {}

    public SalaryModel(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    /*
* obliczanie podwyżki // procedura z parametrem, który określa procent podniesienia pensji –
* dodatkowo, za każde dziecko pracownika zwiększa mu się pensję o 2 procent,
* natomiast pracownicy będący w formalnym związku dodatkowo dostają 3 procent podwyżki) ;*/

    public boolean salaryValue (float sal) {
        if (sal > this.salary) return true;
        else return false;
    }


}
