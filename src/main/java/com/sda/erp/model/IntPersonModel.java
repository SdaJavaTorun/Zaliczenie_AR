package com.sda.erp.model;

/* Created by Artur Rózgowski on 3/18/17 */
public interface IntPersonModel {

    public void toStringShort();
    public String toStringUpper();

    public void toStringUpper(int index);

    public void removePerson();
    public void editPersonMenu() throws Exception;
}
