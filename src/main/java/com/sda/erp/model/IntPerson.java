package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/18/17 */
public interface IntPerson {

    public String getFirstName();
    public void setFirstName(String firstName);
    public String getLastName();
    public void setLastName(String lastName);
    public char getGender();
    public void setGender(char gender);
    public int getAge();
    public void setAge(int age);
    public int getKids();
    public void setKids(int kinds);
    public boolean isMarital();
    public void setMarital(boolean marital);

    public String toString();
    public String toStringShort();
    public String toStringUpper();

}
