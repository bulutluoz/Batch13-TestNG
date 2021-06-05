package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_IFrame {
    /*
    ● Bir class olusturun: D12_IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
            ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
            ○ Text Box’a “Merhaba Dunya!” yazin.
            ○ TextBox’in altinda bulunan “Elemental Selenium”
            linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

     */


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void iframeTest(){
        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
        WebElement iFrameYazisiWebElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(iFrameYazisiWebElementi.isEnabled());
        System.out.println(iFrameYazisiWebElementi.getText());

        // Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0);
        WebElement yaziAlani=driver.findElement(By.cssSelector(".mce-content-body "));
        yaziAlani.clear();
        yaziAlani.sendKeys("Merhaba Dunya");

        //TextBox’in altinda bulunan “Elemental Selenium”
        //linkinin textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement linkWebElementi=driver.findElement(By.linkText("Elemental Selenium"));


        softAssert.assertTrue(linkWebElementi.isDisplayed());
        System.out.println(linkWebElementi.getText());


        softAssert.assertAll();

    }

}
