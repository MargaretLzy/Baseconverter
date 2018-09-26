public class BaseConverter{
	
	public static void main(final String...arguments){
     
    for (int x = 0; x< arguments.length; x++){
        arguments[x] = arguments[x].toUpperCase(); 
    }
    if(arguments.length < 3)
        System.out.println("Requires three arguments: operation, number to change, number to modify with."); 
    else{
    if(arguments[0].equals("CONVERT"))
        //special handling for fractions
        if(arguments[1].contains(".")){
        System.out.println("Must use fractional equivalent instead of decimal"); 
        }
        else if(arguments[1].contains("/")){
        System.out.println("The converted fraction is " + base10DeciToBaseN(fractionToBase10Deci(arguments[1]), arguments[2])); 
        }
        else{
        System.out.println("The converted number is " + base10toN(toBase10(arguments[1]), arguments[2]));
        }
    }

    }


    private static String base10toN(int num, String spaceAndBase){
 
        int base = Integer.parseInt(spaceAndBase.substring(1)); 
    
        String output = ""; 

        while(num > 0){

        int digit = num % base; 

        if(digit > 9){
        char alphaDig = (char) (digit+55); 
        output = alphaDig + output; 
        }
        else{
        output = digit + output; 
        }

        num = num/base; 
        }
        
        return output; 
        
    }

    private static String base10DeciToBaseN(String decy, String spaceAndBase){
        int base = Integer.parseInt(spaceAndBase.substring(1)); 

        //Array of two numbers, one before and after decimal point
        String[] decySplit = decy.split("\\."); 

        int num = Integer.parseInt(decySplit[0]); 

        String wholeOutput = ""; 


        //change base of integer
        while(num > 0){

        int digit = num % base; 

        if(digit > 9){
        char alphaDig = (char) (digit+55); 
        wholeOutput = alphaDig + wholeOutput; 
        }
        else{
        wholeOutput = digit + wholeOutput; 
        }
        num = num/base; 
        }



        String fracOutput = ""; 

        double frac = Double.parseDouble(decySplit[1]); 
        for(int i = 0; i < decySplit[1].length(); i++){
                frac = frac*0.1;
        }   
          
        //change base of decimal 
        for(int p = 0; p < 10; p++){
            int digit = (int) (frac*base); 
            
            if(digit > 9){
            char alphaDig = (char) (digit+55); 
             fracOutput = fracOutput + alphaDig; 
             }
            else{
            fracOutput = fracOutput + digit; 
            }

            frac = (frac * base) - digit;
            if(frac <= 0){
            break; 
            } 
         }      

        return wholeOutput + "." + fracOutput;   
    }



    private static String fractionToBase10Deci(String number){ 
        
        String[] params = number.split("/|\\_"); 
        int origBase = Integer.parseInt(params[2]); 
            

        //convert fraction to base 10 by converting numerator and denominator
        //individually
        double numerator = (double) toBase10(params[0] + "_" + origBase);
        double denom =  (double) toBase10(params[1] + "_" + origBase); 
        
        //divide by num and denom 
        String decy = numerator/denom + ""; 
     

        return decy; 

    } 

    private static int toBase10(String number){

        //split input string into base and numbers
        String[] params = number.split("_"); 
        String origNum = params[0]; 
        int origBase = Integer.parseInt(params[1]); 
       

        //"translate" 'numbers' A-Z into computable digits
        int[] computable = new int[origNum.length()]; 

        for(int p = 0; p < origNum.length(); p++){
            if(origNum.charAt(p) >= 65)
              computable[p] = origNum.charAt(p) - 55; 
            else
              computable[p] = origNum.charAt(p) - 48; 
        } 

        int returnVal = 0;

        for(int k = 0; k < computable.length; k++){


            int base = 1; 
            
            //raise base to digit placement power
            for(int b = computable.length-k-1; b > 0; b--){
                base = origBase*base; 
            }
       
            //multiply exponent by digit and add to output
            returnVal += base*computable[k]; 
        }

        return returnVal; 
        }

	}



