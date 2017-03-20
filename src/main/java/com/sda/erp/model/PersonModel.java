package com.sda.erp.model;

public class PersonModel {

    private static int nextId = 1;
    private int id;
    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private int kids;
    private boolean marital;

    private SalaryModel salaryM;
    private DepartmentModel departmentM;

    public PersonModel(String firstName, String lastName,
                  char gender, int age, int kids, boolean marital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.kids = kids;
        this.marital = marital;
    }

    public PersonModel () {}

    //po każdym wywolaniu/dodaniu obiektu zwieksza sie wartosc nextId statycznej
    public void setId() {
        this.id = nextId;
        nextId++;
    }
    public int getId() { return id;}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) { this.firstName = firstName; }

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
    public void setKids(int kids) {
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
        return "PersonM{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", departmentNo=" + department.getDepartmentNo() +
//                ", salary=" + salary.getSalary() +
                ", gender=" + gender +
                ", age=" + age +
                ", kids=" + kids +
                ", marital=" + marital +
                '}';
    }

    public String toStringShort() {
        return "PersonM{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salaryM.getSalary() +
                '}';
    }

    public String toStringUpper() {
        return "PersonM{" +
                "firstName='" + firstName.toUpperCase() + '\'' +
                ", lastName='" + lastName.toUpperCase() + '\'' +
                '}';
    }
}
