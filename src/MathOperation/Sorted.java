/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathOperation;

import IO.Input;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yosoresje_sd2081
 */
public class Sorted {

    List<Double> list = new ArrayList<>();
    private int size;
    public double trial = 0;

    public void doubleInput() {
        System.out.println("Enter Size: ");
        Input i = new Input();
        this.size = (int)i.getInput();

        double d;
        int count = 0;
        System.out.println("Enter Double Number: ");
        while (count != size) {
            Scanner s1 = new Scanner(System.in);
            try {
                if (!s1.hasNextInt()) {
                    d = s1.nextDouble();
                    list.add(d);
                    count++;
                } else {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Only Accept Double Input!!!");
            }

        }

    }

    private double[] sorted;

    public void getSort() {
        sorted = new double[size];
        double temp = 0;
        for (int i = 0; i < size; i++) {
            sorted[i] = list.get(i);
        }
        for(int i=0; i<sorted.length;i++){
            for (int j=0; j<sorted.length-1;j++){
                if (sorted[j+1] < sorted[j]) {
                    temp = sorted[j+1];
                    sorted[j+1]=sorted[j];
                    sorted[j]=temp;
                    
                }
            }
        }
    }

    public void viewSorted() {
        System.out.println("Sorted Ascending Order:");
        for (Double val : sorted) {
            System.out.print("[" + val + "]");
        }
    }
}
