package windiwAndDialogs;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class Task14 extends TestBaseTask14 {

    @Test
    public void testOpeningLinkInNewWindow(){

        // open page 'Countries'
        goTo("http://localhost/litecart/admin/?app=countries&doc=countries");
        login("admin", "admin", "//button[contains(text(),'Login')]");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[name='countries_form']"))));

        driver.findElement(By.cssSelector("[title='Edit']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(), 'Edit Country')]"))));

        String existingWindow = driver.getWindowHandle();
        System.out.println(existingWindow);

        List<WebElement> links = driver.findElements(By.className("fa-external-link"));
        int numberOflinks = links.size();
        for(int i = 0; i < numberOflinks; i++){
            links.get(i).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windows = driver.getWindowHandles();
            windows.remove(existingWindow);
            String newWindow = windows.iterator().next();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(existingWindow);
        }
    }
}
