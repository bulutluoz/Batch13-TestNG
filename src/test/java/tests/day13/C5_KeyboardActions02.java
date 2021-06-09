package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C5_KeyboardActions02 extends TestBase {
    /*
        1- Bir Class olusturalim D14_KeyboardActions2
        2- https://html.com/tags/iframe/ sayfasina gidelim
        3- video’yu gorecek kadar asagi inin
        4- videoyu izlemek icin Play tusuna basin
        5- videoyu calistirdiginizi test edin
     */

    @Test
    public void test01(){
        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));

        driver.switchTo().frame(iFrame);


        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        // 5- videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='html5-video-player ytp-exp-bottom-control-flexbox ytp-title-enable-channel-logo ytp-embed ytp-embed-playlist ad-created playing-mode ytp-autohide']")).isDisplayed());

    }
}
