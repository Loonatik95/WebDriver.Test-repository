package expectations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;
   protected WebDriverWait wait;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.get("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void stop() {
        driver.quit();
    }



    protected void addProduct() {
        try {
            WebElement element = driver.findElement(By.name("options[Size]"));
            if (element.isDisplayed()) {
                new Select(element).selectByValue("Small");
            }
        } catch (NoSuchElementException ignored) {
        } finally {
            driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
        }
    }
}
