/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public boolean addData(String sqlString) {
        try {
            Connection conn = dbConnect();
            Statement st = conn.createStatement();

            st.executeUpdate(sqlString);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
        
    }
    
    public boolean addToDB(String table ,String columns, String values[]) {
        try {
            
            Connection conn = dbConnect();
            Statement st = conn.createStatement();
            String sqlString = ("INSERT INTO" +table+"(+columns+)"
                + "VALUES(" + Arrays.toString(values)+ ")");
            st.executeUpdate(sqlString);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
        
    }

}
