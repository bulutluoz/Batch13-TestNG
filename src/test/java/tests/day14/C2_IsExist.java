package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C2_IsExist {

    @Test
    public void test01(){
        // masaustunuzde flower dosyasinin oldugunu test ediniz

        // 1- main path'ini String olarak kaydedelim

        String mainPath = System.getProperty("user.home");

        // 2- dosya yolunu String olarak kaydedelim

        String dosyaYolu=mainPath+"\\Desktop"+"\\FLOWER.jpg";

        System.out.println(dosyaYolu);

        // 3- Assertion yapalim

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
