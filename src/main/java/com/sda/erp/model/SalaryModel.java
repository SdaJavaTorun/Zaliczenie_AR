package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/18/17 */
public class SalaryModel implements IntSalaryModel {

    private float salary;

    private PersonModel person;

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

    public void setSalaryRaise (float rise) {
        float percent = 0;
        percent = (rise * 100) / this.salary;

        if (this.person.isMarital()) percent = percent + 3;
        percent = percent + 2 * this.salary;

        System.out.println("Pensja podwyższona o procent: " + percent);
        this.salary = this.salary + percent*this.salary/100;
    }

    public boolean salaryValue (float sal) {
        if (sal > this.salary) return true;
        else return false;
    }

    public void countPeopleWithHiSalary (float s) {

    }
}
