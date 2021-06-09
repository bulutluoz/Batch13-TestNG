package tests.day14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C3_FileDownload extends TestBaseClass {
    /*
    2. Iki tane metod oluşturun : isExist() ve downloadTest()
    3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
            - https://the-internet.herokuapp.com/download adresine gidelim.
            - code.txt dosyasını indirelim
    4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

     */

    @Test
    public void downloadTesti() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("code.txt")).click();
        Thread.sleep(5000);

    }

    @Test
    public void isExistTesti(){

        String dosyaYolu= System.getProperty("user.home")+"\\Downloads\\code.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}
