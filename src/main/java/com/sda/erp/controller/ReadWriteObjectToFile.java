package com.sda.erp.controller;

import com.sda.erp.model.PersonModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteObjectToFile implements Serializable{

    static OutputStream fileOutputStream = null;
    static ObjectOutput objectOutputStream = null;
    static OutputStream bufferOut = null;

    public static void writeToTXTFile (String file, List<PersonController> p) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        out.printf("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n");
        for (PersonController pc: p)
            out.printf("%-4d %-20s %-20s %-4d\n",
                    pc.getPersonId(), pc.getPersonFirstName(),
                    pc.getPersonLastName(), pc.getPersonAge());
        out.close();
    }

    public static void writeToFile(String fileName, List<PersonController> modelList) throws Exception {
        try {
            fileOutputStream = new FileOutputStream(fileName, true);
            bufferOut = new BufferedOutputStream(fileOutputStream);
            objectOutputStream = new ObjectOutputStream(bufferOut);

            objectOutputStream.close();
        }
        finally {
            if (objectOutputStream != null) objectOutputStream.close();

            fileOutputStream.close();
            bufferOut.close();
            objectOutputStream.close();
        }
    }

    public void readFromFile() throws Exception {
        String fileName = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStream bufferIn = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferIn);

            PersonModel readCase = null;
            List<PersonModel> recordList = new ArrayList<>();

            while (true) {
                try {
                    readCase = (PersonModel) objectInputStream.readObject();
                    recordList.add(readCase);
                } catch (EOFException exc) {
                    break;
                }
            }

            recordList.forEach(s -> System.out.println(s.getFirstName()));

            fileOutputStream.close();
            objectOutputStream.close();

        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
    }
}
