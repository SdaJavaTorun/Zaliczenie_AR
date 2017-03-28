package com.sda.erp.controller;

import com.sda.erp.model.PersonModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadWriteObjectToFile implements Serializable{

    static List<ListController> listToFile = new ArrayList<>();

    static OutputStream fileOutputStream = null;
    static ObjectOutput objectOutputStream = null;
    static OutputStream bufferOut = null;

    // setter glównej listy
    public void setListToFile (List<ListController> listToFile) {
        ReadWriteObjectToFile.listToFile = listToFile;
    }

    public static void writeToTXTFile (String file)
                                        throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        out.printf("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n");
        for (ListController lf: listToFile)
            out.printf("%-4d %-20s %-20s %-4d\n",
                    lf.getPersonId(), lf.getPersonFirstName(),
                    lf.getPersonLastName(), lf.getPersonAge());
        out.close();
    }

    public void sortBySalaryInFile(boolean dir) throws Exception {
        if (dir == true) { // sortowanie rosnąco
            listToFile.sort(Comparator.comparing(ListController::getSalary));
            ReadWriteObjectToFile.writeToTXTFile("SortOrder.txt");
        }
        else {  // sortowanie malejąco
            listToFile.sort(Comparator.comparing(ListController::getSalary).reversed());
            ReadWriteObjectToFile.writeToTXTFile("SortRevOrd");
        }
    }

    public void writeToHTMLFile() throws FileNotFoundException {
        String fileHTML = "pracownicy.html";
        PrintWriter html = new PrintWriter(fileHTML);
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<meta charset=UTF-8>")
                .append("<head>")
                .append("</head>")
                .append("<body>")
                .append("<table>")
                .append("<tr>")
                .append("<td width=20%> Nazwisko </td>")
                .append("<td width=10%> Imię </td>")
                .append("<td width=5%> Płeć </td>")
                .append("<td width=5%> Nr działu </td>")
                .append("<td width=20%> Płaca </td>")
                .append("<td width=10%> Wiek </td>")
                .append("</tr>");

        for (ListController hp: listToFile) {
           sb.append("<tr>")
            .append("<td width=20%>").append(hp.getPersonLastName()).append("</td>")
            .append("<td width=10%>").append(hp.getPersonFirstName()).append("</td>")

            .append("<td width=5%>").append(hp.getPersonGender()).append("</td>")
            .append("<td width=5%>").append(hp.getDepartmentNr()).append("</td>")
            .append("<td width=20%>").append(hp.getSalary()).append("</td>")
            .append("<td width=10%>").append(hp.getPersonAge()).append("</td>")
            .append("</tr>");

        }
        sb.append("</table></body></html>");
        html.print(sb);
        html.close();
    }

    public void showDataLongestLastName() {
        System.out.println("Dane osoby o najdłuższym nazwisku");
        ListController longestLastName = new ListController();
        for (ListController pll: listToFile) {
            if (pll.getPersonLastName().length()
                    >= longestLastName.getPersonLastName().length()) {
                longestLastName = pll;
            }
        }
        longestLastName.toString();
    }

    public void dataCoding(String fileName) throws Exception {
        PrintWriter out = new PrintWriter(fileName);
        out.printf("%-4s %-20s %-20s %-4s", "Id", "Imię", "Nazwisko", "Wiek\n");
        double aveSal =
                listToFile.stream()
                        .mapToDouble(s -> s.getSalary())
                        .average()
                        .getAsDouble();

        for (ListController as: listToFile) {
            if (as.getSalary() < aveSal)
                out.printf("%-4d %-20s %-20s %-4d\n",
                        as.getPersonId(), as.getPersonFirstName(),
                        codeLastName(as.getPersonLastName()),
                        as.getPersonAge());
        }
        out.close();
    }

    public String codeLastName (String lastNameToCrypt) {
        StringBuilder sb = new StringBuilder(lastNameToCrypt.length());
        for (int i = 1; i<lastNameToCrypt.length(); i++)
            sb.append('*');
        return sb.toString();
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
