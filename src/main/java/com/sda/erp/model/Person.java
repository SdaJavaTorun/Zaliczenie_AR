package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/17/17 */
public class Person implements IntPerson {

    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private int kids;
    private boolean marital;

    private Person person;
    private Department department;
    private Salary salary;

    public Person(String firstName, String lastName,
                  char gender, int age, int kids, boolean marital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.kids = kids;
        this.marital = marital;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kinds) {
        this.kids = kids;
    }

    public boolean isMarital() {
        return marital;
    }

    public void setMarital(boolean marital) {
        this.marital = marital;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentNo=" + department.getDepartmentNo() +
                ", salary=" + salary.getSalary() +
                ", gender=" + gender +
                ", age=" + age +
                ", kids=" + kids +
                ", marital=" + marital +
                '}';
    }

    public String toStringShort() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary.getSalary() +
                '}';
    }

    public String toStringUpper() {
        return "Person{" +
                "firstName='" + firstName.toUpperCase() + '\'' +
                ", lastName='" + lastName.toUpperCase() + '\'' +
                '}';
    }
}
