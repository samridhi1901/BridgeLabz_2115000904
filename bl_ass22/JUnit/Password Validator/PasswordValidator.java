class PasswordValidator {

    public static boolean isValid(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
