package actionElements;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseTask11 {

    public static WebDriver driver;


    @BeforeAll
    public static void start() {
        driver = new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void stop() {
        driver.quit();
    }

    protected void createAccount(User user) {
        driver.findElement(By.name("firstname")).sendKeys(user.getFirstname());
        driver.findElement(By.name("lastname")).sendKeys(user.getLastname());
        driver.findElement(By.name("address1")).sendKeys(user.getAddress());
        driver.findElement(By.name("postcode")).sendKeys(user.getPostcode());
        driver.findElement(By.name("city")).sendKeys(user.getCity());

        driver.findElement(By.xpath("//span[@role='combobox']")).click();
        driver.findElement(By.xpath("//li[text()='United States']")).click();

        driver.findElement(By.name("email")).sendKeys(user.getEmail());
        driver.findElement(By.name("phone")).sendKeys(user.getPhone());

        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.name("confirmed_password")).sendKeys(user.getConfirmedPassword());

        driver.findElement(By.name("create_account")).click();
    }

    protected void buttonNewCustomers() {
        driver.findElement(By.xpath("//a[text()='New customers click here']")).click();
    }

    protected void logout() {
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }
}
