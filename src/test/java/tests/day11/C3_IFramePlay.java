package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_IFramePlay {
    // https://html.com/tags/iframe/ adresine gidin
    // youtube videosunu calistirin


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
        //driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframe);


        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();


    }

}
