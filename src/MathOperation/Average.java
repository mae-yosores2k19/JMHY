/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathOperation;

import IO.*;


/**
 *
 * @author yosoresje_sd2081
 */
public class Average {
    public double sum=0;
    public int counter=0;
    
    public double getAverage(double value[]) {
        for (double d : value) {
            sum+=d;
            counter++;
        }
        return sum/counter;    
    }
    public void Input(){
        Output.print("Enter size of Inputs: ");
        int size = (int) Input.getInput();
        Output.print("=^^= Please Enter number =^^=");
        double array[] = new double[size];
        double sum = 0;

        for (int i = 0; i < size;) {
            try {
                double num = Input.getInput();
                array[i] = num;
                sum += num;
                i++;

            } catch (Exception e) {
                System.out.println("Input must be Integer!!!");
            }

        }
        Output.print("Sum is: " + sum);
        Output.print("Average is: " +getAverage(array));
    }

    
    
    
//        System.out.println("Enter number of Inputs: ");
//        try{
//        inputNumber = in.nextInt();
//        }catch(Exception e){
//            System.out.println("Input must be Integer!");
//        }
//        
//        System.out.println("Please Enter "+ inputNumber+" number!");
//        for (int i = 0; i<=inputNumber-1;) {
//            try{
//                
//                number = in.nextDouble();
//                list.add(number);
//                sum += number;
//                i++;
//            }catch(Exception e){
//                
//                System.out.println("Input must be Integer");
//            }
//        }
//        System.out.println("The Sum Of The input number: ");
//        return sum;
//    }
    
   
}
