/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2ndyrGroupA
 */
public class Crud {

    public static String file = "C:\\Users\\yosoresje_sd2081\\Documents\\NetBeansProjects\\FileListOfUser\\files\\list.csv";
    public static List<String> lines = new ArrayList();

    public static void add(String first_name, String middle_name, String last_name, String mails, String pswrd) {
        getLines();
        int id = lines.size();
        String inp = String.format("%s,%s,%s,%s,%s,%s\n", id, first_name, middle_name, last_name, mails, pswrd);
        try {
            Files.write(Paths.get(file), inp.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void getLines() {
        lines.clear();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static String getPassword(String email) {
        getLines();
        String getpass = "id-not-found";
        for (int i = 0; i < lines.size(); ++i) {
            if (email.equals(lines.get(i).split(",")[4])) {
                getpass = lines.get(i).split(",")[5];
                break;
            }
        }
        return getpass;
    }

    public static List showList() {
        getLines();
        return lines;
    }

    public static boolean delete(String email) {
        getLines();
        boolean bool = false;
        int id = lines.size();
        List<String> temp = new ArrayList();
        for (int i = 0; i < lines.size(); ++i) {
            if (email.equals(lines.get(i).split(",")[4])) {
                bool = true;
            } else {
                temp.add(lines.get(i));
            }
        }
        try {
            Files.write(Paths.get(file), "".getBytes());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        for (int i = 0; i < temp.size(); ++i) {
           
            String[] line = temp.get(i).split(",");
            String inp = String.format("%s,%s,%s,%s,%s,%s\n", line[0], line[1], line[2], line[3], line[4], line[5]);
            try {
                Files.write(Paths.get(file), inp.getBytes(), StandardOpenOption.APPEND);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return bool;
    }
    public static String getOne(String email) {
        List<String> lines = new ArrayList();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < lines.size(); ++i) {
            if (email.equals(lines.get(i).split(",")[4])) {
                return lines.get(i);
            }
        }
        return "not found";
    }
    public static void update( String id, String first_name, String middle_name, String last_name, String mails, String pswrd) {
        getLines();
        List<String> temp = new ArrayList();
        for (int i = 0; i < lines.size(); ++i) {
            if (id.equals(lines.get(i).split(",")[0])) {
                String inp = String.format("%s,%s,%s,%s,%s,%s", id, first_name, middle_name,last_name, mails, pswrd);
                temp.add(inp);
            } else {
                temp.add(lines.get(i));
            }
        }
        try {
            Files.write(Paths.get(file), "".getBytes());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < temp.size(); ++i) {
            String[] line = temp.get(i).split(",");
            String inp = String.format("%s,%s,%s,%s,%s,%s\n", line[0], line[1], line[2], line[3], line[4], line[5]);
            try {
                Files.write(Paths.get(file), inp.getBytes(), StandardOpenOption.APPEND);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
      
    }

}
