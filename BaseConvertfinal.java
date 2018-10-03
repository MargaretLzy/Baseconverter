import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaseConvertfinal{
 static String a="";
  int remainder;

static char convert(int num) { 
    if (num >= 0 && num <= 9) 
        return (char)(num + '0'); 
    else
        return (char)(num - 10 + 'A'); 

}
 static String con(int number, int base){

      while (number>0)
      {
         a=convert(number%base)+a;
         number=number/base;
      }
       return a; 

      }
      
   public static void main (String args[]) throws IOException
   
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter a number ===>> ");
      int num= Integer.parseInt(input.readLine());
      System.out.println();
      System.out.println("Entered number:     " + num);
      System.out.print("Enter a base you want to convert to ===>> ");
      int base= Integer.parseInt(input.readLine());

     System.out.println("Base "+base+":" + con(num,base)); 
}
}