package valueObject;

import java.util.regex.Pattern;

public class App {
    public static String registration(User user){
        String usernamevalidateResult = validateUsername(user.getUsername());
        String passwordvalidateResult = validatePassword(user.getPassword());
        String emailvalidateResult = validateEmail(user.getEmail());
        String agevalidateResult = validateAge((user.getAge()));

        String resultMessage = "Guest wasn't registered.";
        if (!(usernamevalidateResult == null)) {
            resultMessage = resultMessage + " | " + usernamevalidateResult;
        }
        if (!(passwordvalidateResult == null)) {
            resultMessage = resultMessage + " | " + passwordvalidateResult;
        }
        if (!(emailvalidateResult == null)) {
            resultMessage = resultMessage + " | " + emailvalidateResult;
        }
        if (!(agevalidateResult == null)) {
            resultMessage = resultMessage + " | " + agevalidateResult;
        }
        if (resultMessage == "Guest wasn't registered.") {
            resultMessage = "User was registered.";
        }

        System.out.println(resultMessage);

        return resultMessage;
    }
    
    private static String validateEmail(String email){
        if (email == null) {
            return "Поле email null";
        }
        else if (email == "") {
            return "Поле email пустое";
        }
        else if (!email.contains("@")){
            return "Поле email не содержит спецсимвола @";
        }
        else if (Pattern.matches(".*\\p{InCyrillic}.*", email)){
            return  "Поле email содержит символы кириллицы";
        }
        else {
            return null;
        }
    }

    private static String validatePassword(String password){
        if (password == null) {
            return "Поле password null";
        }
        else if (password == "") {
            return "Поле password пустое";
        }
        else if (password.length() < 8){
            return "Поле password содержит менее 8 символов";
        }
        else if (Pattern.matches(".*\\p{InCyrillic}.*", password)){
            return  "Поле password содержит символы кириллицы";
        }
        else {
            return null;
        }
    }

    private static String validateUsername(String username){
        if (username == null) {
            return "Поле username null";
        }
        else if (username == "") {
            return "Поле username пустое";
        }
        else if (Pattern.matches(".*\\p{InCyrillic}.*", username)){
            return  "Поле username содержит символы кириллицы";
        }
        else {
            return null;
        }
    }

    private static String validateAge(int age){
        if (age < 18){
            return  "Поле age меньше 18";
        }
        else {
            return null;
        }
    }
}
