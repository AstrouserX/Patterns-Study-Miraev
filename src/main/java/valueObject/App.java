package valueObject;

import java.util.regex.Pattern;

public class App {
    public static String registration(int age, String username, String password, String email) {
        String resultMessage = "Guest wasn't registered.";
        String emailCheckResult = "";
        String passwordCheckResult = "";
        String usernameCheckResult = "";
        String ageCheckResult = "";

        if (email == null) {
            emailCheckResult = emailCheckResult + " | " + "Поле email null";
        }
        else if (email == "") {
            emailCheckResult = emailCheckResult + " | " + "Поле email пустое";
        }
        else if (!email.contains("@")){
            emailCheckResult = emailCheckResult + " | " + "Поле email не содержит спецсимвола @";
        }
        else if (Pattern.matches(".*\\p{InCyrillic}.*", email)){
            emailCheckResult = emailCheckResult + " | " + "Поле email содержит символы кириллицы";
        }
        else {
            emailCheckResult = null;
        }

        if (password == null) {
            passwordCheckResult = passwordCheckResult + " | " + "Поле password null";
        }
        else if (password == "") {
            passwordCheckResult = passwordCheckResult + " | " + "Поле password пустое";
        }
        else if (password.length() < 8){
            passwordCheckResult = passwordCheckResult + " | " + "Поле password содержит менее 8 символов";
        }
        else if (Pattern.matches(".*\\p{InCyrillic}.*", password)){
            passwordCheckResult = passwordCheckResult + " | " + "Поле password содержит символы кириллицы";
        }
        else {
            passwordCheckResult = null;
        }

        if (username == null) {
            usernameCheckResult = usernameCheckResult + " | " + "Поле username null";
        }
        else if (username == "") {
            usernameCheckResult = usernameCheckResult + " | " + "Поле username пустое";
        }
        else if (Pattern.matches(".*\\p{InCyrillic}.*", username)){
            usernameCheckResult = usernameCheckResult + " | " + "Поле username содержит символы кириллицы";
        }
        else {
            usernameCheckResult = null;
        }

        if (age < 18){
            ageCheckResult = ageCheckResult + " | " + "Поле age меньше 18";
        }
        else {
            ageCheckResult = null;
        }

        if (usernameCheckResult == null && passwordCheckResult == null && emailCheckResult == null && ageCheckResult == null) {
            resultMessage = "User was registered.";
            System.out.println(resultMessage);
            return resultMessage;
        }
        else {
            resultMessage = resultMessage + usernameCheckResult + passwordCheckResult + emailCheckResult + ageCheckResult;
            System.out.println(resultMessage);
            return resultMessage;
        }
    }
}
