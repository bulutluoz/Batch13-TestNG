package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C2_Dropdown01 {
    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
	4.Tüm dropdown değerleri(value) yazdırın
	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

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

    @Test
    public void DropdownTesti(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // dropdown'i kullanabilmek icin 3 asama yapmamiz gerekir
        // 1.asama---- dropdown'u locate edelim
        WebElement dropdownMenu =driver.findElement(By.xpath("//select[@id='dropdown']"));
        // 2.asama
        Select dropdownListe = new Select(dropdownMenu);
        // 3.asama dropdown menusunden istedigimiz option'i secelim
        dropdownListe.selectByIndex(1);

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        System.out.println("listeden  " + dropdownListe.getFirstSelectedOption().getText());
        System.out.println("get text" + dropdownMenu.getText());


    }

    @Test
    public void degerKullanma(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement acilirListe=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(acilirListe);
        select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText());

    }

    @Test
    public void gorunurIsim(){
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement acilirListe= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(acilirListe);

        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    public void tumListe(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement acilirListe=driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select=new Select(acilirListe);

        List<WebElement> tumOpsiyonlar = select.getOptions();
        //  4.Tüm dropdown değerleri(value) yazdırın


        System.out.println("============================");
        for (WebElement each: tumOpsiyonlar
             ) {
            System.out.println(each.getText());
        }

        //	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println("dropdown daki web elemnt sayisi : " + tumOpsiyonlar.size());


    }
}
