package tests.day14;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C1_BilgisayardakiDosyalaraUlasma {

    @Test
    public void test01(){

        // System.getProperty("user.dir") icinde oldugumuz projenin bilgisayardaki yolunu verir

        System.out.println(System.getProperty("user.dir"));

        // System.getProperty("user.home") kullandigimiz bilgisayarin Main Path'ini verir
        // Ana yol
        System.out.println(System.getProperty("user.home"));

        // Bir dosyaya dinamik olarak ulasabilmek icin

        // Masaustune ulasmak istiyorsam

        String masaUstuDosyaYolu= System.getProperty("user.home") + "\\Desktop";

        System.out.println(masaUstuDosyaYolu);



    }

}
