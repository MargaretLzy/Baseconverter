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
    
    public String convertToNBase(String str0, String str1);
    public String add(String str0, String str1);
    public String subtract(String str0, String str1);
    public String multiply(String str0, String str1);
    public String divide(String str0, String str1);
    
}
