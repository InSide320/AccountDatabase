package com.example.coursework.user.generate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

public class GenerateEmail {
    public static String generateEmail(String lastName, String firstName) {

        Random random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return (lastName + "_"
                + firstName.charAt(0)
                + random.nextInt(1, 9)
                + "@chpt.edu.ua").toLowerCase(Locale.ROOT);
    }

}
