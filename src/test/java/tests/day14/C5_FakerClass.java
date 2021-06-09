package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C5_FakerClass extends TestBase {

    @Test
    public void facebookFaker(){

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu=driver.findElement(By.name("firstname"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        actions.
                click(isimKutusu).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("10").
                sendKeys(Keys.TAB).
                sendKeys("May").
                sendKeys(Keys.TAB).
                sendKeys("2010").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.ARROW_LEFT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();



        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin
    }
}
