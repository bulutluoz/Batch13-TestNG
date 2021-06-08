package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C3_MouseActions03 extends TestBase {

    /*
        Yeni bir class olusturalim: D15_MouseActions4
        1- https://www.facebook.com adresine gidelim
        2- Yeni hesap olustur butonuna basalim
        3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        4- Kaydol tusuna basalim

     */

    @Test
    public void test01(){
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        WebElement isimKutusu=driver.findElement(By.name("firstname"));

        Actions actions=new Actions(driver);

        /*
        actions.click(isimKutusu).perform();
        actions.sendKeys("Mehmet").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Bulut").perform();
        actions.sendKeys(Keys.TAB).perform();
        */

        actions.
                click(isimKutusu).
                sendKeys("Mehmet").
                sendKeys(Keys.TAB).
                sendKeys("Bulut").
                sendKeys(Keys.TAB).
                sendKeys("mehmetbulut@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("mehmetbulut@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("12345").
                perform();

    }
}
