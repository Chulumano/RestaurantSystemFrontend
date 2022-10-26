package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class GenericHelper {

    public static boolean isNullorEmpty(String x) {
        return ( x == null || x.equals("") || x.equalsIgnoreCase("null"));
    }

    public static boolean  isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);

    }




}
