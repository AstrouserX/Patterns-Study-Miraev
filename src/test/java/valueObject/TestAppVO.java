package valueObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAppVO {
    User user;

    private void setUpUser(int age, String username, String password, String email) {
        this.user.setAge(age);
        this.user.setUsername(username);
        this.user.setPassword(password);
        this.user.setEmail(email);
    }

    @BeforeClass
    public void precondition(){
        this.user = new User();
    }

    @Test(description = "Гость не может зарегистрироваться с age 17")
    public void checkWrongAge(){
        setUpUser(17, "David", "qwertyuiop", "daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с username содержащим кириллицу")
    public void checkUsernameCyrillic(){
        user.setAge(18);
        user.setUsername("Давид");
        user.setPassword("qwertyuiop");
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с username null")
    public void checkUsernameNullValue(){
        user.setAge(18);
        user.setUsername(null);
        user.setPassword("qwertyuiop");
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с пустым username")
    public void checkUsernameEmpty(){
        user.setAge(18);
        user.setUsername("");
        user.setPassword("qwertyuiop");
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с email null")
    public void checkEmailNullValue(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword("qwertyuiop");
        user.setEmail(null);
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с пустым email")
    public void checkEmailEmpty(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword("qwertyuiop");
        user.setEmail("");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с email не содержащим @")
    public void checkEmailAtSymbol(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword("qwertyuiop");
        user.setEmail("daavviiddmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с password null")
    public void checkPasswordNullValue(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword(null);
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с password null")
    public void checkPasswordEmpty(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword("");
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с password null")
    public void checkPasswordLessEightSymbols(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword("q");
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }

    @Test(description = "Гость не может зарегистрироваться с password null")
    public void checkPasswordCyrillic(){
        user.setAge(18);
        user.setUsername("David");
        user.setPassword("ждertyuiop");
        user.setEmail("daavviid@dmail.com");
        App.registration(user);
    }
}
