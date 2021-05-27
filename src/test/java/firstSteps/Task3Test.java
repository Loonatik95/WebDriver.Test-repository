package firstSteps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task3Test {
  private WebDriver driver;


  @BeforeEach
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.navigate().to("http://localhost/litecart/admin/");
    driver.manage().window().maximize();

  }

  @Test
  public void actionsTest() {
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.xpath("//span[text()='Appearence']")).click();
    driver.findElement(By.xpath("//button[@name='cancel']")).click();
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
  }


  @AfterEach
  public void stop() {
    driver.quit();
    driver = null;
  }
}
