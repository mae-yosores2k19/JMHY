/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupA
 */
public class Input {

    public static double getInput(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
       
    }
    public static String getInputString(){
        Scanner s = new Scanner(System.in);
        return s.next();
       
    }
}
