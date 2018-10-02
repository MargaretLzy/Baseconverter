package baseconverterapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author greerhoffmann
 */
public class TheConverter implements BaseConverter{

    protected static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected String input0;
    protected String input1;

    public TheConverter() {
        input0 = "";
        input1 = "";
    }

    public TheConverter(String input0, String input1) {
        this.input0 = input0;
        this.input1 = input1;
    }
    
    public String convertToNBase(String str0, String str1) {
        //        System.out.println("Input: "+input0);
//        String returnStr="";
        String num0 = input0.substring(0, input0.indexOf("_"));
        int base0 = Integer.parseInt(input0.substring(input0.indexOf("_") + 1));
        int base1 = Integer.parseInt(input1.substring(input1.indexOf("_") + 1));

        String nAryToDecStr = nAryToDec(num0, base0);
        if (base1 != 10) {
            return decToNAry(Integer.parseInt(nAryToDecStr), base1) + "_" + base1;
        } else {
            return nAryToDecStr + "_" + base1;
        }
//        return "Output: " + returnStr + "_" + base1;
    }

    public String add(String input0, String input1) {
        String num0 = input0.substring(0, input0.indexOf("_"));
        String num1 = input1.substring(0, input1.indexOf("_"));
//        System.out.println("num0: "+num0 + " num1: "+num1);
        int base0 = Integer.parseInt(input0.substring(input0.indexOf("_") + 1));
        int base1 = Integer.parseInt(input1.substring(input1.indexOf("_") + 1));

        int input0Dec = Integer.parseInt(nAryToDec(num0, base0));
        int input1Dec = Integer.parseInt(nAryToDec(num1, base1));
//        System.out.println("input0Dec: "+input0Dec + ", input1Dec: "+input1Dec);
        int sum = input0Dec + input1Dec;
//        System.out.println("sum: "+sum);
        return decToNAry(sum, base0) + "_" + base0;
    }

    public String subtract(String input0, String input1) {
        String num0 = input0.substring(0, input0.indexOf("_"));
        String num1 = input1.substring(0, input1.indexOf("_"));
//        System.out.println("num0: "+num0 + " num1: "+num1);
        int base0 = Integer.parseInt(input0.substring(input0.indexOf("_") + 1));
        int base1 = Integer.parseInt(input1.substring(input1.indexOf("_") + 1));

        int input0Dec = Integer.parseInt(nAryToDec(num0, base0));
        int input1Dec = Integer.parseInt(nAryToDec(num1, base1));
//        System.out.println("input0Dec: "+input0Dec + ", input1Dec: "+input1Dec);
        int sum = input0Dec - input1Dec;
//        System.out.println("sum: "+sum);
        return decToNAry(sum, base0) + "_" + base0;
    }

    public String multiply(String input0, String input1) {
        String num0 = input0.substring(0, input0.indexOf("_"));
        String num1 = input1.substring(0, input1.indexOf("_"));
//        System.out.println("num0: "+num0 + " num1: "+num1);
        int base0 = Integer.parseInt(input0.substring(input0.indexOf("_") + 1));
        int base1 = Integer.parseInt(input1.substring(input1.indexOf("_") + 1));

        int input0Dec = Integer.parseInt(nAryToDec(num0, base0));
        int input1Dec = Integer.parseInt(nAryToDec(num1, base1));
//        System.out.println("input0Dec: "+input0Dec + ", input1Dec: "+input1Dec);
        int product = input0Dec * input1Dec;
//        System.out.println("sum: "+sum);
        return decToNAry(product, base0) + "_" + base0;
    }

    public String divide(String input0, String input1) {
        String num0 = input0.substring(0, input0.indexOf("_"));
        String num1 = input1.substring(0, input1.indexOf("_"));
//        System.out.println("num0: "+num0 + " num1: "+num1);
        int base0 = Integer.parseInt(input0.substring(input0.indexOf("_") + 1));
        int base1 = Integer.parseInt(input1.substring(input1.indexOf("_") + 1));

        int input0Dec = Integer.parseInt(nAryToDec(num0, base0));
        int input1Dec = Integer.parseInt(nAryToDec(num1, base1));
//        System.out.println("input0Dec: "+input0Dec + ", input1Dec: "+input1Dec);
        int quotient = input0Dec + input1Dec;
//        System.out.println("sum: "+sum);
        return decToNAry(quotient, base0) + "_" + base0;
    }

//    public String nAryToNAry(String input0, String input1) {
///
//    }

    public static String nAryToDec(String num, int n) {
//        System.out.println(num);
        int dec = 0;
        for (int i = 0; i < num.length(); i++) {
            int current = ALPHABET.indexOf(num.charAt(num.length() - 1 - i));
//            System.out.println("Current: "+current);
            dec += current * power(n, i);
        }
        return "" + dec;
    }

    public String decToNAry(int dec, int n) {
        if (dec == 0) {
            return "";
        }
        if (dec % n > 9) {
            return "" + decToNAry(dec / n, n) + (ALPHABET.charAt(dec % n));
        }
        return "" + decToNAry(dec / n, n) + (dec % n);
    }

    public static int power(int a, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }

    
}
