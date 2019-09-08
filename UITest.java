import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UITest {

    @BeforeMethod
    public void browser(){
        Configuration.browser = "chrome";
    }

    @Test
    public void test(){

        Selenide.open("https://gorzdrav.spb.ru/");
        Selenide.$(By.xpath("//*[@id=\"header\"]/ul/li[2]/a")).click();
        Selenide.$(By.xpath("//*[@id=\"mobileOrEmail\"]")).setValue("111");
        Selenide.$(By.xpath("//*[@id=\"password\"]")).setValue("111");
        Selenide.$(By.xpath("//*[@id=\"loginByPwdButton\"]")).click();
        Selenide.$(By.xpath("//*[@id=\"authnFrm\"]/div[1]/div[3]/dl[1]/dd/div/div/span")).shouldBe(Condition.visible);
        String resultText = Selenide.$(By.xpath("//*[@id=\"authnFrm\"]/div[1]/div[3]/dl[1]/dd/div/div/span")).getText();

        MatcherAssert.assertThat("Введите мобильный телефон или почту", Matchers.equalTo(resultText));
        Selenide.sleep(1000);

    }






}
