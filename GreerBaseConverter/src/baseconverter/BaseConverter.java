/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;

/**
 *
 * @author ghoffmann
 */

public class BaseConverter {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        TheConverter c = new TheConverter();
       
//        
        switch(args[0]){
            case "convert": System.out.println(c.nAryToNAry(args[1], args[2])); break;
            case "add": c.add(args[1], args[2]); break;
            case "multiply": System.out.println(c.multiply(args[1], args[2]));; break;
            case "subtract": c.subtract(args[1], args[2]); break;
            case "divide": c.divide(args[1], args[2]); break;
            default: System.out.println("There is an error");
        }
//System.out.println(c.nAryToNAry("3_10", "_2"));
//        System.out.println(c.subtract("3_10", "1_2"));
//        System.out.println(c.add("1_2", "11_2"));;//=1+3=4=100
        //System.out.println("N-Ary to N-Ary: " + c.nAryToNAry(c.input0, c.input1));
    }

}




