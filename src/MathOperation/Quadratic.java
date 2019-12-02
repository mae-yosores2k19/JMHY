/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathOperation;

/**
 *
 * @author 2ndyrGroupB
 */
public class Quadratic {

    public double QaudraticPositive(double a, double b, double c) {
        double x,y,z;
        x = (Math.sqrt(b*b-4*a*c));
        y = -b+x;
        z = y/2*a;
        return z;
    }
    public double QaudraticNegative(double a, double b, double c) {
       double x,y,z;
        x = (Math.sqrt(b*b-4*a*c));
        y = -b-x;
        z = y/2*a;
        return z;
    }

}
