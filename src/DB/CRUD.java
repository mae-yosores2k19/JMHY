/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author yosoresje_sd2081
 */
public class CRUD {

    public Connection dbConnect() {
        //executeUpdate means to return the numbers of rows affected by the execution of the SQL statement (Create,Update,Delete)
        //executeQuery means to return a resultset object(Retrieve)
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/yosores";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            return conn;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean addToDB(String table, String columns, String values[]) {
        try {
            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = ("INSERT INTO " + table + "(" + columns + ")"
                    + "VALUES('" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "','" + values[4] + "')");
            System.out.println("Columns: " + columns);
            System.out.println("Values: " + Arrays.toString(values));
            System.out.println("Query: " + sqlString);

            st.executeUpdate(sqlString);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println("Message: " + e.getMessage());
            return false;
        }
    }

    public ResultSet retrieveFromDB(String table, String columns) {
        try {
            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = ("SELECT " + columns + " from (" + table + ")");
            ResultSet rs = st.executeQuery(sqlString);
            return rs;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println("Message: " + e.getMessage());
        }
        return null;
    }

    public void updateFromDB(String table, String columns[], String values[], int id) {

        try {
            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = "UPDATE `" + table + "` SET `" + columns[0] + "`='" + values[0] + "',`" + columns[1] + "`='" + values[1] + "',`" + columns[2] + "`='" + values[2] + "',`" + columns[3] + "`='" + values[3] + "',`" + columns[4] + "`='" + values[4] + "' WHERE `id`=" + id;
            System.out.println("Querry: " + sqlString);
            st.executeUpdate(sqlString);
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println("Message: " + e.getMessage());
        }
    }

    public void deleteFromDB(String table, String email) {

        try {
            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = "DELETE FROM `" + table + "` WHERE email='" + email + "'";
            System.out.println("Querrysss: " + sqlString);

            st.executeUpdate(sqlString);
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println("Message: " + e.getMessage());
        }
    }
    
    
    public ResultSet login(String table, String columnpass, String columnemail, String email) {
        try {

            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = "SELECT " + columnpass + " FROM `" + table + "` WHERE `" + columnemail + "`='" + email + "'";
//            SELECT password FROM `user` WHERE email = "jmhy@gmail.com" 
            System.out.println("qurry: " + sqlString);
            ResultSet rs = st.executeQuery(sqlString);

            return rs;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println("Message: " + e.getMessage());
        }
        return null;
    }

    public ResultSet emailexist(String table, String email) {
        try {

            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = "SELECT * FROM `" + table + "` WHERE email='" + email + "'";
            ResultSet rs = st.executeQuery(sqlString);
            return rs;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println("Message: " + e.getMessage());
        }
        return null;
    }



}
