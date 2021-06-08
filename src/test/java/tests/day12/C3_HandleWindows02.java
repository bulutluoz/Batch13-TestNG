package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseClass;

import java.util.Set;

public class C3_HandleWindows02 extends TestBaseClass {

    /*
        ● https://the-internet.herokuapp.com/windows adresine gidin.
        ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        ● Click Here butonuna basın.
        ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softAssert=new SoftAssert();
        WebElement yaziWebElementi=driver.findElement(By.tagName("h3"));

        String expectedYazi="Opening a new window";
        softAssert.assertEquals(yaziWebElementi.getText(),expectedYazi);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        softAssert.assertEquals(driver.getTitle(),expectedTitle);

        // yeni bir sayfa acma islemi yapilmadan once varolan sayfanin window handle degerini kaydetmeliyiz

        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();

        // click islemi yapilinca yeni sayfaya gecebilmek icin ikinci sayfa handle degerini bulmam lazim

        Set <String> handleSeti= driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";

        for (String each : handleSeti
             ) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }

        //simdi ikinci sayfaya gecebiliriz
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String expectedIkinciSayfaTitle="New Window";
        softAssert.assertEquals(driver.getTitle(),expectedIkinciSayfaTitle);

        // ayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement ikinciSayfaYaziWebElementi=driver.findElement(By.tagName("h3"));
        String expectedIkinciSayfaYazisi="New Window";

        softAssert.assertEquals(ikinciSayfaYaziWebElementi.getText(),expectedIkinciSayfaYazisi);
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaHandleDegeri);
        softAssert.assertEquals(driver.getTitle(),expectedTitle);


        softAssert.assertAll();
    }
}
