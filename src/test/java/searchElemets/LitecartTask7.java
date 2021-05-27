package searchElemets;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LitecartTask7 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setup() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterAll
    public static void finish() {

        driver.quit();
    }

    @Test
    public void testLoginAsAdmin() {

        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.manage().window().maximize();
    }

    @Test
    public void testLeftMenuLinks() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
        List<WebElement> leftMenuItems = driver.findElements(By.className("name"));
        List<String> leftMenuItemNames = getElementNames(leftMenuItems);

        for (String s : leftMenuItemNames) {
            driver.findElement(By.xpath("//span[text()='" + s + "']")).click();
            Assertions.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

            List<WebElement> menuSubItems = driver.findElements(By.cssSelector(("[id^=doc-]")));
            List<String> leftSubMenuItemNames = getElementNames(menuSubItems);

            for (String se : leftSubMenuItemNames) {
                driver.findElement(By.xpath("//span[text()='" + se + "']")).click();
                Assertions.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
            }
        }
    }

    private List<String> getElementNames(List<WebElement> elements) {
        List<String> names = new ArrayList<>();
        for (WebElement e : elements) {
            names.add(e.getText());
        }

        return names;
    }
}
