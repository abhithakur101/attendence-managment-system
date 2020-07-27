package com.ams.validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {

    Logger logger= LoggerFactory.getLogger(Validation.class);

       public String  validationmobile(String mobile) {


            String regex = "\\d{10}";

            Pattern pat = Pattern.compile(regex);

            Matcher mat = pat.matcher(mobile);

            if(mat.matches()) {
              logger.info("Mobile Number Accepted");
                return "Accepted";
            } else {
               logger.error("Mobile Number Not Accepted");
                return "NotAccepted";
            }

        }



    public String validationEmail(String email)
    {
        String regex = "^(.+)@(.+)$";
        //Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        //Creating a Matcher object
        Matcher matcher = pattern.matcher(email);
        //Verifying whether given phone number is valid
        if(matcher.matches()) {
            logger.info("Email  Accepted");
            return  "Accepted";
        } else {
            logger.error("Email Not Accepted");
            return  "NotAccepted";
        }
    }
    public String validationUsername(String name)
    {

        // Regex to check valid username.
        String regex = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";


        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(name);

        if(m.matches()) {
            logger.info("Username  Accepted");
            return  "Accepted";
        } else {
            logger.error("Email Not  Accepted");
            return  "NotAccepted";}

    }
}