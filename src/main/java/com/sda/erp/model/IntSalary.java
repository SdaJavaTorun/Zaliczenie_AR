package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/18/17 */
public interface IntSalary {

    public void setSalary(float salary);

    /*
* obliczanie podwyżki // procedura z parametrem, który określa procent podniesienia pensji –
* dodatkowo, za każde dziecko pracownika zwiększa mu się pensję o 2 procent,
* natomiast pracownicy będący w formalnym związku dodatkowo dostają 3 procent podwyżki) ;*/

    public void setSalaryRaise (float rise);
    public boolean salaryValue (float sal);
}
