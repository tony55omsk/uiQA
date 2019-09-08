package page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class LoginPage {

    By login = By.xpath("//*[@id=\"mobileOrEmail\"]"); // поле авторизации
    By password = By.xpath("//*[@id=\"password\"]");// поле пароль
    By buttonOk = By.xpath("//*[@id=\"loginByPwdButton\"]/span");//кнопка Ввода введенной инфы

    public void setLogin(String login1){ //метод заполнения поля авторизации
        Selenide.$(login).setValue(login1);

    }

    public void setPassword(){ //метод заполнения поля пароль
        Selenide.$(password).setValue("111");

    }

    public void clickButton(){ //клик по кнопке Ввода введенной инфы
        Selenide.$(buttonOk).click();

    }
}
