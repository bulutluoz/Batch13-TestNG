package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C1_MouseActions01 extends TestBase {

    /*
        1- Yeni bir class olusturalim: D14_MouseActions1
        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        3- Cizili alan uzerinde sag click yapalim
        4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        5- Tamam diyerek alert’I kapatalim
        6- Elemental Selenium linkine tiklayalim
        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */

    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim

            // i) actions objesi olustur
        Actions actions= new Actions(driver);

            // ii) mouse action'i yapacagim web elementini locate edelim
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));

            // iii) actions objesi ve locate ettigimiz webelementini kullanarak istedigimiz islemi yapalim
        actions.contextClick(cizgiliAlan).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String alertYazisi=driver.
                                switchTo().
                                alert().
                                getText();

        String expectedYazi="You selected a context menu";
        Assert.assertEquals(alertYazisi,expectedYazi);
        // 5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        // contextclick'in menusu acik kaliyor
        // kapatmak icin herhangi bir yere normal klik yapalim
        Thread.sleep(2000);
        cizgiliAlan.click();

        // 6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        // driver.findElement(By.linkText("Elemental Selenium")).click();

        WebElement elementalLinki=driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(elementalLinki).perform();

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> handleKumesi = driver.getWindowHandles();

        String ikinciSayfaHandleDegeri="";

        for (String each: handleKumesi
             ) {
            if (!ilkSayfaHandleDegeri.equals(each)){
                ikinciSayfaHandleDegeri=each;
            }
        }

        driver.switchTo().window(ikinciSayfaHandleDegeri);

        WebElement h1TagYaziWebElementi= driver.findElement(By.tagName("h1"));

        String actualH1Yazisi= h1TagYaziWebElementi.getText();
        String expectedH1Yazisi="Elemental Selenium";
        h1TagYaziWebElementi.click();

        Assert.assertEquals(actualH1Yazisi,expectedH1Yazisi);

    }
}
