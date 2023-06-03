package Lambda_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test2 {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement javascriptAlerts = driver.findElement(By.linkText("Javascript Alerts"));
        javascriptAlerts.click();
        Thread.sleep(500);
        WebElement jsAlertBtn = driver.findElement(By.xpath("//p[contains(text(), 'JS Alert')]//button"));
        jsAlertBtn.click();
        Thread.sleep(500);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(), "Alert box!");
        alert.accept();

        WebElement confirmBtn = driver.findElement(By.xpath("//p[contains(text(), 'Confirm box')]//button"));
        confirmBtn.click();
        Thread.sleep(500);
        Assert.assertEquals(alert.getText().trim(), "Press a button!");
        alert.dismiss();

        WebElement promptBtn = driver.findElement(By.xpath("//p[contains(text(), 'Prompt box')]//button"));
        promptBtn.click();
        Thread.sleep(500);
        alert.sendKeys("Yuliia");
        alert.accept();
        System.out.println(alert.getText());
        // Assert.assertTrue(alert.getText().trim().contains("Yuliia"));


    }
}
