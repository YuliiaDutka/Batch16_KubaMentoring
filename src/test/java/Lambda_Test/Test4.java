package Lambda_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test4 {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.tumblr.com/");

        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        loginBtn.click();
        Thread.sleep(2000);
        WebElement loginWithEmail = driver.findElement(By.xpath("//button[@class='dKGjO']"));
        loginWithEmail.click();
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("fsjhdbfjs@gmail.com");
        WebElement nextEmail = driver.findElement(By.xpath("//span[.='Next']"));
        nextEmail.click();
        WebElement setupPassword = driver.findElement(By.xpath("//input[contains(@placeholder, 'Set')]"));
        setupPassword.sendKeys("12345");
        WebElement repeatPassword = driver.findElement(By.xpath("//input[contains(@placeholder, 'Repeat')]"));
        repeatPassword.sendKeys("12345");
        WebElement nextBtnPassword = driver.findElement(By.xpath("//span[.='Next']"));
        nextBtnPassword.click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
        Assert.assertEquals(errorMessage.getText().trim(), "The password must be at least 8 characters long.");
        boolean validation = false;
        if(errorMessage.getText().trim().equals("The password must be at least 8 characters long.")){
            validation = true;
            System.out.println("Error message \"The password must be at least 8 characters long.\" is shown: " + validation);
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
