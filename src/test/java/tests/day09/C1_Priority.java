package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class C1_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("before method calisti");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        System.out.println("After method calisti");
    }

    @Test
    public void test01(){
        System.out.println("test01 calisti");
    }

    @Test
    public void ikincitest(){
        System.out.println("Ikinci test calisti");
    }

    @Test (priority = 2)
    public void yazdimTest(){
        System.out.println("yazdim testi calisti");
    }
}
