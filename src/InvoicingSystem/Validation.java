package InvoicingSystem;

import java.util.regex.Pattern;

public class Validation {

    // Validate if a given string is not empty or null
    public static boolean isValidString(String str)
    {
        return str != null && !str.trim().isEmpty();
    }

    // Validate if a given number is positive
    public static boolean isPositiveNumber(Integer number) {

        return number > 0;
    }

    // Validate if a given number is positive
    public static boolean isPositiveNumber(double number) {

        return number > 0;
    }


    // Validate if a given email address is in a valid format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate if a given phone number is in a valid format
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Implement phone number validation logic
        // Example: Check if phoneNumber matches a specific format
        return phoneNumber.matches("\\d{8}"); // Example: 8-digit phone number validation
    }

    // Validate if a given URL is in a valid format
    public static boolean isValidURL(String url) {
        // Implement URL validation logic using a regex pattern or other validation method
        // Example regex pattern for URL validation:
        String urlRegex = "^(https?|ftp)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?$";
        return Pattern.matches(urlRegex, url);
    }

}

