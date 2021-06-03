package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class C3_DropDownAmazon {
    /*
        ● https://www.amazon.com/ adresine gidin.
        - Test 1
            Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        -Test 2
            1. Kategori menusunden Books secenegini  secin
            2. Arama kutusuna Java yazin ve aratin
            3. Bulunan sonuc sayisini yazdirin
            4. Sonucun Java kelimesini icerdigini test edin

     */
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
    }

}
