/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class Validation {
    public static boolean isValidEmail(String email ) {
        Pattern emaiPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emaiPattern.matcher(email);
        return matcher.find();
    }
    public static boolean isValidMobile(String mobileNumber) {
        Pattern mobileNumberPattern = Pattern.compile("^\\\\d{10}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = mobileNumberPattern.matcher(mobileNumber);
        return matcher.find();
    }
}
