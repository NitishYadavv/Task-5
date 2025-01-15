import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    
    // Character sets for password generation
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}|;:'\",<.>/?";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Input: Desired password length
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        
        // Input: Include uppercase letters
        System.out.print("Include uppercase letters (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");
        
        // Input: Include lowercase letters
        System.out.print("Include lowercase letters (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");
        
        // Input: Include digits
        System.out.print("Include digits (y/n): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("y");
        
        // Input: Include special characters
        System.out.print("Include special characters (y/n): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        // Generate password based on user specifications
        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialChars, random);
        
        // Display the generated password
        if (password != null) {
            System.out.println("Generated password: " + password);
        } else {
            System.out.println("Error: You must select at least one character type!");
        }

        scanner.close();
    }

    // Generate a random password based on criteria
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialChars, Random random) {
        // Create the character pool based on user input
        StringBuilder characterPool = new StringBuilder();
        
        if (includeLowercase) characterPool.append(LOWERCASE);
        if (includeUppercase) characterPool.append(UPPERCASE);
        if (includeDigits) characterPool.append(DIGITS);
        if (includeSpecialChars) characterPool.append(SPECIAL_CHARACTERS);
        
        // If no character type is selected, return null
        if (characterPool.length() == 0) {
            return null;
        }
        
        // Generate password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }
        
        return password.toString();
    }
}
