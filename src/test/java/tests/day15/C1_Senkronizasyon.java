package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_Senkronizasyon extends TestBase {

    @Test
    public void implicitWait(){

        /*
        1. Bir class olusturun : WaitTest
        2. Iki tane metod olusturun : implicitWait() , explicitWait()

             Iki metod icin de asagidaki adimlari test edin.
        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        4. Remove butonuna basin.
        5. “It’s gone!” mesajinin goruntulendigini test edin
        6. Add buttonuna basin
        7. It’s back mesajinin gorundugunu test edin
         */

        // https://the-internet.herokuapp.com/dynamic_controls

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.

        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini test edin

        WebElement itsGoneYazisiElementi=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackYazisiElementi=driver.findElement(By.cssSelector("p#message"));

        Assert.assertTrue(itsBackYazisiElementi.isDisplayed());

    }

    @Test
    public void explicit(){
        // https://the-internet.herokuapp.com/dynamic_controls

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.

        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini test edin

        WebDriverWait wait=new WebDriverWait(driver,30);

        WebElement itsGoneYazisiElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        // WebElement itsGoneYazisiElementi=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackYazisiElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p#message")));


        // WebElement itsBackYazisiElementi=driver.findElement(By.cssSelector("p#message"));

        Assert.assertTrue(itsBackYazisiElementi.isDisplayed());

    }
}
