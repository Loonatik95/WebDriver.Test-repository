import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProgram {

  WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
  }

  @Test
  public void firstProgram() {
    driver.get("https://www.facebook.com/");
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
