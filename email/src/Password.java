import java.util.Scanner;
import java.util.regex.*;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;


public class Password {
    
    //------------------------------- PUBLIC FUNCTIONS --------------------------------------------
    
    //code.tutsplus.com/es/tutorials/build-a-simple-password-strength-checker--net-7565
    //Method to perform password security measurement algorithm
    public static String algorithmPass(String strPassword){
        char[] charPassword = strPassword.toCharArray();
        int baseScore = 0;
        int minPasswordLength = 8;
        
        //Length the password
        if (charPassword.length >= minPasswordLength) 
        {
            baseScore = 50;
            baseScore = baseScore + AnalyzeString(charPassword, minPasswordLength, strPassword);
        }
        else
        {
            baseScore = 0;
        }
               
        return TypePassword(baseScore,minPasswordLength);
    }
    
    //Method to encrypt
    public String P_encode(String key, String cadena){
        String encriptacion = "";
        encriptacion = Encode(key, cadena);
        return encriptacion;
    }
    
    //Method to decrypt
     public String P_dencode(String key, String cadena){
        String desencriptacion = "";
        desencriptacion = Encode(key, cadena);
        return desencriptacion;
    }
  
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
      //Method to analyze string in array
    private static int AnalyzeString(char[] charPassword, int minPass, String strPass){
        //var
        int numUpper = 0;
        int numNumbers = 0;
        int numSymbols = 0;
        int numExcess = 0;
        int bonusCombo = 0;
        int bonusFlatLower = 0;
        int bonusFlatNumber = 0;
        int bonusExcess = 3;
        int bonusUpper = 4;
        int bonusNumbers = 5;
        int bonusSymbols = 5;
        int Score = 0;
        
        //scroll
        for (int i = 0; i < charPassword.length; i++) {
            if (Character.toString(charPassword[i]).matches("[A-Z]")) {numUpper++;}
            else if (Character.toString(charPassword[i]).matches("[0-9]")) {numNumbers++; } 
            else if (Character.toString(charPassword[i]).matches("[!,@,#,$,%,^,&,*,?,_,~]")) {numSymbols++; } 
        }
        numExcess = charPassword.length - minPass;
        //combination bonus
        if (numUpper > 0 && numNumbers > 0 && numSymbols > 0) {
            bonusCombo = 25;
        }
        else if ((numUpper > 0 && numNumbers > 0) || (numUpper > 0 && numSymbols > 0) || (numNumbers > 0 && numSymbols > 0)) {
            bonusCombo = 15;
        }
        //if the string is flat
        if (strPass.matches("^[\\sa-z]+$")) {
            bonusFlatLower = -15;
        }
        if (strPass.matches("^[\\s0-9]+$")) {
            bonusFlatNumber = -35;
        }
        //total
        Score = (numExcess* bonusExcess) + (numUpper*bonusUpper) + (numNumbers*bonusNumbers) + 
                (numSymbols*bonusSymbols) + bonusCombo + bonusFlatLower + bonusFlatNumber; 
        return Score;
    }
    
    //Method to know the type of password
    private static String TypePassword(int score, int minPass){
        String level = "";
        if (score == 0) 
        {
            level = "Se requiere minimo de caracteres: "+ minPass + " .";
        }
        else if (score < 50)
        {
            level = "Bajo.";
        }
        else if (score >= 50 && score < 75)
        {
            level = "Medio.";
        }
        else if (score >= 75 && score < 100)
        {
            level = "Medio alto.";
        }
        else if (score >= 100)
        {
            level = "Alto.";
        }
        
        return level;
    }
    
    //Method to encrypt
    private String Encode(String key, String cadena){
        String encriptacion = "";
        
        return encriptacion;
    }
    
    //Method to decrypt
     private String Dencode(String key, String cadena){
        return null;
    }
    
}
