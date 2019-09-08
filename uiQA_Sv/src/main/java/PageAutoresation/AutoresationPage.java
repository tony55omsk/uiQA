package PageAutoresation;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class AutoresationPage {

    By login = By.xpath("//*[@id=\"mobileOrEmail\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By buttomOk = By.xpath("//*[@id=\"loginByPwdButton\"]");

    public void sendLogin (String loginvhod) {
        Selenide.$(login).setValue(loginvhod);
    }

    public void sendPassword (String passwordvhod){
        Selenide.$(password).setValue(passwordvhod);
    }

    public void clickButtomOk (){
        Selenide.$(buttomOk).click();
    }
}
