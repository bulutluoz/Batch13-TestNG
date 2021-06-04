package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C1_DependsOnTest {

    /*
    ● Bir class oluşturun: DependsOnTest
    ● https://www.walmart.com/ adresine gidin.
	1. Test : Wallmart ana sayfaya gittiginizi test edin
	2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
	    arama yapin ve aramanizin gerceklestigini Test edin
	3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin
	    ve fiyatinin $6.65 oldugunu test edin
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
    public void test01HomePage(){
        // 1. Test : Wallmart ana sayfaya gittiginizi test edin
        driver.get("https://www.walmart.com/");
        String expectedUrl="https://www.walmart.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"niye olmadi ki ?");

    }

    @Test (dependsOnMethods = "test01HomePage")
    public void test02Search(){
       // 2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
       //	    arama yapin ve aramanizin gerceklestigini Test edin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String aranacakKelime= "Nutella";
        aramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(aranacakKelime));

    }

    @Test (dependsOnMethods = "test02Search")
    public void test03Result(){
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin
        //	    ve fiyatinin $7.97 oldugunu test edin

        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();
        WebElement fiyatWebElementi=driver.findElement(By.xpath("(//span[@class='price-group'])[1]"));

        String actualFiyat=fiyatWebElementi.getText();
        String expectedFiyat="$7.97";
        Assert.assertEquals(actualFiyat,expectedFiyat);
    }

}
