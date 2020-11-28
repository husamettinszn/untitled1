package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        /*
        1-Test01 isimli bir class olusturun
        2- https://www.walmart.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4-Sayfayi “refresh” yapin
        5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        7- URL in walmart.com icerdigini control edin
        8-”Nutella” icin arama yapiniz
        9- Kac sonuc bulundugunu yaziniz
        10-Sayfayi kapatin

         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.walmart.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        String arananKelimeTitle = "Save";

        if (driver.getTitle().contains(arananKelimeTitle)) {
            System.out.println("Titel "+ arananKelimeTitle +" iceriyor PASS");
        }else{
            System.out.println("Titel "+ arananKelimeTitle +" icermiyor FAILED");
        }
        String expectedTitle = "Walmart.com | Save Money.Live Better";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Titel test PASS");
        }else{
            System.out.println("Titel test FAILED");
            System.out.println("Actual Title: "+ actualTitle);
            System.out.println("Expected Title: "+ expectedTitle);
        }
        String actualURL = driver.getCurrentUrl();
        String arananKelime = "walmart.com";

        if (actualURL.contains(arananKelime)) {
            System.out.println("URL testi PASS");
        }else{
            System.out.println("URL testi FAILED");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String aramaKelimesi = "Nutella";
        aramaCubugu.sendKeys(aramaKelimesi + Keys.ENTER);
        //aramaCubugu.submit();

        WebElement sayi = driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(sayi.getSize());
        driver.close();





    }
}
