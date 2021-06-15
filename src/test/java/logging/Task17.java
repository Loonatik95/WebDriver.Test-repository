package logging;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task17 {
    private WebDriver driver;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    @Test
    public void Logs() {
        List<WebElement> products = driver.findElements(By.cssSelector("a[href*='product_id']"));
        List<String> productNames = new ArrayList<>();
        for (int i = 0; i < products.size(); i += 2) {
            productNames.add(products.get(i).getText());
        }

        for (String productName : productNames) {
            driver.findElement(By.linkText(productName)).click();
            driver.navigate().back();
        }

        driver.manage().logs().get("browser").forEach(l -> {
            System.out.println(l);
            Assertions.assertTrue(l.equals(""));
        });
    }

    @AfterEach
    public void stop() {
        driver.quit();
    }
}
