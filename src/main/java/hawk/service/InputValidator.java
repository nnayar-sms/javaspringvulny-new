public class InputValidator {
    private InputValidator() {
        // Private constructor to prevent instantiation
    }

    public static boolean checkValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }
    
    public static boolean checkAlphanumeric(String input) {
        return input != null && input.matches("^[a-zA-Z0-9]+$");
    }
    
    public static boolean checkValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }
    public static boolean checkValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean checkInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }    

    public static String sanitizeForSQL(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("['\"\\\\]", "");
    }

    public static String sanitizeForXSS(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

}
