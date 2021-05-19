package firstSteps;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {

  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
  }

  @Test
  public void firstProgram() {
    driver.get("https://www.facebook.com/");
    Assert.assertEquals("Facebook — Выполните вход или зарегистрируйтесь", driver.getTitle());
  }

  @After
  public void tearDown() {
    driver.quit();
    driver = null;
  }
}
