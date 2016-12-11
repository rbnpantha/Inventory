package models;

import controllers.RegistrationController;

import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pratik Acharya on 10/16/2016.
 */
public class RuleSetFactory {

    public static boolean isNumeric(String str)
    {
        if(str.isEmpty())
            return false;
        for(int i=0;i<str.length();i++)
        {

            if(!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;

    }
    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    public static boolean isValidPhoneNumber(String phoneNo)
    {
        if (phoneNo.matches("\\d{10}")) return true;
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
        else return false;

    }


    public static  boolean  isEmpty(String str){
        return str.isEmpty();
    }
}
