/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practice.pkg3;

/**
 *
 * @author USER
 */
public class Practice3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Multiplication and Divison
        
        //Step 1 declare variables 
        
        int valOne;
        int valTwo;
        int resultAdd;
        int resultMult;
        int resultDiv , resultMod;
        
        
        
       //step 2 assign values
       
       valOne = 79;
       valTwo = 55;
       
       // step 3 check mwmory and cal 
       
      
       resultAdd = valOne + valTwo;
       resultMult = valOne * valTwo;
       resultDiv = valOne / valTwo;
       resultMod = valOne % valTwo;
       
       
       // step 4 output
       
        System.out.println(valOne + "+" + valTwo + " = " + resultAdd);
        System.out.println(valOne + "*" + valTwo + " = " + resultMult);
        System.out.println(valOne + "/" + valTwo + " = " + resultDiv);
        System.out.println(resultMod);
       
       
       
    }
    
}
