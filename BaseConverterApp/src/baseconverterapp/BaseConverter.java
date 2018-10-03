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
public interface BaseConverter {
    
    /**
     * CONVERTTONBASE
     * Inputs: STR0 and STR1; string in the format number_base (or _base for str1)
     * Outputs: A string in the format number_base, str0 converted to the base specified in str1
     */
    public String convertToNBase(String str0, String str1);
    
    /**
     * ADD
     * Inputs: STR0 and STR1; string in the format number_base
     * Outputs: A string in the format number_base, representing str0 added to str1, with the base from str0
     */
    public String add(String str0, String str1);
    
    /**
     * ADD
     * Inputs: STR0 and STR1; string in the format number_base
     * Outputs: A string in the format number_base, representing str0 subtracted with str1, with the base from str0
     */
    public String subtract(String str0, String str1);
    
    /**
     * MULTIPLY
     * Inputs: STR0 and STR1; string in the format number_base
     * Outputs: A string in the format number_base, representing str0 multiplied to str1, with the base from str0
     */
    public String multiply(String str0, String str1);
    
    /**
     * DUVIDE
     * Inputs: STR0 and STR1; string in the format number_base
     * Outputs: A string in the format number_base, representing str0 divided by str1, with the base from str0
     */
    public String divide(String str0, String str1);
    
}
