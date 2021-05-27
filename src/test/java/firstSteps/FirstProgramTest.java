package firstSteps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgramTest {

  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
  }

  @Test
  public void firstProgram() {
    driver.get("https://www.facebook.com/");
    Assertions.assertEquals("Facebook — Выполните вход или зарегистрируйтесь", driver.getTitle());
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
    driver = null;
  }
}
