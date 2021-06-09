package windiwAndDialogs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBaseTask14 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }

    void goTo(String url){
        driver.navigate().to(url);
    }

    void login(String username, String password, String confirmLocator){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath(confirmLocator)).click();
        // wait untill the page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-sign-out")));
    }

}
