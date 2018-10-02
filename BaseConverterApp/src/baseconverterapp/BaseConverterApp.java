/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverterapp;

/**
 *
 * @author greerhoffmann
 */
public class BaseConverterApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TheConverter c = new TheConverter();
       
//        
        switch(args[0]){
            case "convert": System.out.println(c.convertToNBase(args[1], args[2])); break;
            case "add": c.add(args[1], args[2]); break;
            case "multiply": System.out.println(c.multiply(args[1], args[2]));; break;
            case "subtract": c.subtract(args[1], args[2]); break;
            case "divide": c.divide(args[1], args[2]); break;
            default: System.out.println("There is an error");
        }
    }
    
}
