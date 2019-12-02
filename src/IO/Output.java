/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author 2ndyrGroupA
 */
public class Output {

    public static boolean print(String val) {
        try {
            System.out.println(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

   

}
