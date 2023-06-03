package Lambda_Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test3 {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement name = driver.findElement(By.linkText("Drag & Drop Sliders"));
        name.click();
        List<WebElement> sliders = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> range = driver.findElements(By.xpath("//output[contains(@id, 'range')]\t"));

        Actions actions = new Actions(driver);

        int expectedRange = 99;
        for (int j = 0; j < range.size(); j++) {
            while (!range.get(j).getText().equals("50")) {
                if (range.get(j).getText().equals("50")) {
                    break;
                } else {
                    sliders.get(j).sendKeys(Keys.ARROW_RIGHT);
                }
            }
        }
    }
}