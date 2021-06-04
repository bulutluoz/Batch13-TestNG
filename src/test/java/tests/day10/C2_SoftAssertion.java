package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_SoftAssertion {

    /* "Selenium ogrenmek cok zevkli" cumlesinde
         asagidaki testleri yapiniz
         - cumle ogrenmek iceriyor
         - cumle Java icermiyor
         - cumle 4 kelimeden olusuyor
         - cumledeki karakter sayisi 25
     */

    WebDriver driver;
    String cumle="Selenium ogrenmek cok zevkli";

    @Test
    public void hardAssertion(){
        Assert.assertTrue(cumle.contains("ogrenmek"));
        System.out.println("1");
        Assert.assertFalse(cumle.contains("Java"));
        System.out.println("2");
        String kelimeler[]=cumle.split(" ");
        Assert.assertEquals(kelimeler.length,4);
        System.out.println("3");
        String karakterler[]=cumle.split("");
        Assert.assertEquals(karakterler.length,25);
        System.out.println("4");
    }

    @Test
    public void softAssertionTesti(){

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(cumle.contains("ogrenmek"),"ogrenmek testi failed");
        System.out.println("1");

        softAssert.assertFalse(cumle.contains("Java"),"Java testi failed");
        System.out.println("2");

        String kelimeler[]=cumle.split(" ");
        softAssert.assertEquals(kelimeler.length,4,"kelime sayisi testi failed");
        System.out.println("3");

        String karakterler[]=cumle.split("");
        softAssert.assertEquals(karakterler.length,28,"karakter sayisi testi failed");
        System.out.println("4");

        softAssert.assertAll();
        // assertAll gorundugunde soft assert test bitti olarak algilar ve durumu rapor eder
        // tum testler pass olduysa calismaya devam eder
        // ypilan soft assertlerden 1 tanesi bile failed olursa bu satirda execution durur
        System.out.println("bu yazi konsolda cikar mi ?");

    }
}
