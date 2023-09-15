package valueObject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApp {
    @Test(description = "Гость может зарегистрироваться с валидными данными")
    public void checkAllRight(){
        Assert.assertEquals(App.registration(18, "David", "qwertyuiop", "daavviid@dmail.com"), "User was registered.");
    }

    @Test(description = "Гость не может зарегистрироваться с age 17")
    public void checkWrongAge(){
        Assert.assertEquals(App.registration(17, "David", "qwertyuiop", "daavviid@dmail.com"), "Guest wasn't registered. | Поле age меньше 18");
    }

    @Test(description = "Гость не может зарегистрироваться с username содержащим кириллицу")
    public void checkUsernameCyrillic(){
        Assert.assertEquals(App.registration(18, "Давид", "qwertyuiop", "daavviid@dmail.com"), "Guest wasn't registered. | Поле username содержит символы кириллицы");
    }

    @Test(description = "Гость не может зарегистрироваться с username null")
    public void checkUsernameNullValue(){
        Assert.assertEquals(App.registration(18, null, "qwertyuiop", "daavviid@dmail.com"), "Guest wasn't registered. | Поле username null");
    }

    @Test(description = "Гость не может зарегистрироваться с пустым username")
    public void checkUsernameEmpty(){
        Assert.assertEquals(App.registration(18, "", "qwertyuiop", "daavviid@dmail.com"), "Guest wasn't registered. | Поле username пустое");
    }

    @Test(description = "Гость не может зарегистрироваться с email null")
    public void checkEmailNullValue(){
        Assert.assertEquals(App.registration(18, "David", "qwertyuiop", null), "Guest wasn't registered. | Поле email null");
    }

    @Test(description = "Гость не может зарегистрироваться с пустым email")
    public void checkEmailEmpty(){
        Assert.assertEquals(App.registration(18, "David", "qwertyuiop", ""), "Guest wasn't registered. | Поле email пустое");
    }

    @Test(description = "Гость не может зарегистрироваться с email не содержащим @")
    public void checkEmailAtSymbol(){
        Assert.assertEquals(App.registration(18, "David", "qwertyuiop", "daavviiddmail.com"), "Guest wasn't registered. | Поле email не содержит спецсимвола @");
    }

    @Test(description = "Гость не может зарегистрироваться с email содержащим кириллицу")
    public void checkEmailCyrillic(){
        Assert.assertEquals(App.registration(18, "David", "qwertyuiop", "dаavviid@dmail.com"), "Guest wasn't registered. | Поле email содержит символы кириллицы");
    }

    @Test(description = "Гость не может зарегистрироваться с password null")
    public void checkPasswordNullValue(){
        Assert.assertEquals(App.registration(18, "David", null, "daavviid@dmail.com"), "Guest wasn't registered. | Поле password null");
    }

    @Test(description = "Гость не может зарегистрироваться с пустым password")
    public void checkPasswordEmpty(){
        Assert.assertEquals(App.registration(18, "David", "", "daavviid@dmail.com"), "Guest wasn't registered. | Поле password пустое");
    }

    @Test(description = "Гость не может зарегистрироваться с password содержащим менее 8 символов")
    public void checkPasswordLessEightSymbols(){
        Assert.assertEquals(App.registration(18, "David", "q", "daavviid@dmail.com"), "Guest wasn't registered. | Поле password содержит менее 8 символов");
    }

    @Test(description = "Гость не может зарегистрироваться с password содержащим кириллицу")
    public void checkPasswordCyrillic(){
        Assert.assertEquals(App.registration(18, "David", "ждertyuiop", "daavviid@dmail.com"), "Guest wasn't registered. | Поле password содержит символы кириллицы");
    }
}
