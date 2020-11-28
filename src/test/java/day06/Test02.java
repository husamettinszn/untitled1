package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {
    public static void main(String[] args) {
        /*
        1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine  “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10”
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin

         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com");

        WebElement signIn = driver.findElement(By.xpath("//i[@class='icon-signin']"));
        signIn.click();

        WebElement userName = driver.findElement(By.id("user_login"));

        userName.sendKeys("username");

        WebElement passWord = driver.findElement(By.id("user_password"));
        passWord.sendKeys("password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.linkText("Pay Bills")).click();
        WebElement amountTextBox = driver.findElement(By.id("sp_amount"));
        amountTextBox.sendKeys("250");

        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("2020-09-10");

        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement basariliMesaji = driver.findElement(By.xpath("//span[@title='$ 250 payed to payee sprint']"));

        if (basariliMesaji.isDisplayed()) {
            System.out.println("Havale Basarili Yazisi testi PASS");
        }else{
            System.out.println("Havale Basarili Yazisi testi FAILED");
        }
        driver.close();
    }
}
