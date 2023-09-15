package valueObject;

import org.testng.Assert;
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

    @Test(description = "Гость может зарегистрироваться с валидными данными")
    public void checkAllRight(){
        setUpUser(18, "David", "qwertyuiop", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "User was registered.");
    }

    @Test(description = "Гость не может зарегистрироваться с age 17")
    public void checkWrongAge(){
        setUpUser(17, "David", "qwertyuiop", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле age меньше 18");
    }

    @Test(description = "Гость не может зарегистрироваться с username содержащим кириллицу")
    public void checkUsernameCyrillic(){
        setUpUser(18, "Давид", "qwertyuiop", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле username содержит символы кириллицы");
    }

    @Test(description = "Гость не может зарегистрироваться с username null")
    public void checkUsernameNullValue(){
        setUpUser(18, null, "qwertyuiop", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле username null");
    }

    @Test(description = "Гость не может зарегистрироваться с пустым username")
    public void checkUsernameEmpty(){
        setUpUser(18, "", "qwertyuiop", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле username пустое");
    }

    @Test(description = "Гость не может зарегистрироваться с email null")
    public void checkEmailNullValue(){
        setUpUser(18, "David", "qwertyuiop", null);
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле email null");
    }

    @Test(description = "Гость не может зарегистрироваться с пустым email")
    public void checkEmailEmpty(){
        setUpUser(18, "David", "qwertyuiop", "");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле email пустое");
    }

    @Test(description = "Гость не может зарегистрироваться с email не содержащим @")
    public void checkEmailAtSymbol(){
        setUpUser(18, "David", "qwertyuiop", "daavviiddmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле email не содержит спецсимвола @");
    }

    @Test(description = "Гость не может зарегистрироваться с email содержащим кириллицу")
    public void checkEmailCyrillic(){
        setUpUser(18, "David", "qwertyuiop", "dаavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле email содержит символы кириллицы");
    }

    @Test(description = "Гость не может зарегистрироваться с password null")
    public void checkPasswordNullValue(){
        setUpUser(18, "David", null, "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле password null");
    }

    @Test(description = "Гость не может зарегистрироваться с пустым password")
    public void checkPasswordEmpty(){
        setUpUser(18, "David", "", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле password пустое");
    }

    @Test(description = "Гость не может зарегистрироваться с password содержащим менее 8 символов")
    public void checkPasswordLessEightSymbols(){
        setUpUser(18, "David", "q", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле password содержит менее 8 символов");
    }

    @Test(description = "Гость не может зарегистрироваться с password содержащим кириллицу")
    public void checkPasswordCyrillic(){
        setUpUser(18, "David", "ждertyuiop", "daavviid@dmail.com");
        Assert.assertEquals(AppVO.registration(user), "Guest wasn't registered. | Поле password содержит символы кириллицы");
    }
}
