package searchElemets;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseTask8 {
    public static WebDriver driver;

    @BeforeAll
    public static void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void stop() {
        driver.quit();
        driver = null;
    }
}
