import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.$;

public class UITest {
    @BeforeMethod
    public void settings(){
        Configuration.browser = "firefox";
    }
    @Test
    public void test(){


    Selenide.open("https://gorzdrav.spb.ru/");

    $(By.xpath("//*[@id=\"header\"]/ul/li[2]/a")).click();

    LoginPage loginPage = new LoginPage();

    loginPage.setLogin();
    loginPage.setPassword();
    loginPage.clickButton();

    $(By.xpath("//*[@id=\"authnFrm\"]/div[1]/div[3]/dl[1]/dd/div/div/span")).shouldBe(Condition.visible);

    String resulText = $(By.xpath("//*[@id=\"authnFrm\"]/div[1]/div[3]/dl[1]/dd/div/div/span")).getText();
    MatcherAssert.assertThat("Введите мобильный телефон или почту", Matchers.equalTo((resulText)));

    Selenide.sleep(500);
    }

}
