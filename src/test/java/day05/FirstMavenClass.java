package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FirstMavenClass {
    /*
    Class Work Amazon Search Test
1- https://www.amazon.com/ sayfasina gidelim
            2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement arama = driver.findElement(By.xpath("//input[@type='text']"));
       arama.sendKeys("Samsung headphones");
       arama.submit();

       WebElement sonucSayisi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println("Sonuc sayisi :"+ sonucSayisi.getText());

        WebElement ilk = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilk.click();
        driver.navigate().back();
        WebElement elementLst = (WebElement) driver.findElements(By.xpath("//span[@class='a-size-base a-color-base a-text-bold']"));
        List<WebElement> elementSayisi = new ArrayList<WebElement>();


        for (WebElement w:elementSayisi
             ) {
            w.getText();
        }
        System.out.println(elementSayisi);




    }
}
