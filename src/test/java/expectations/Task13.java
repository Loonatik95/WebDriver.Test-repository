package expectations;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task13 extends TestBase {

    @Test
    public void addProductOnBasket() {
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[@class='image-wrapper']")).click();
            WebElement item = driver.findElement(By.xpath("//span[@class='quantity']"));
            String quantityOfItemBeforeAdding = item.getText();
            addProduct();
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']")
                    , quantityOfItemBeforeAdding)));
            driver.findElement(By.xpath("//a/i[@title='Home']")).click();
        }

        driver.findElement(By.xpath("//a[text()='Checkout »']")).click();

        int item = driver.findElements(By.xpath("//tr/td[@class='item']")).size();
        while (item > 0) {
            driver.findElement(By.xpath("//button[text()='Remove']")).click();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tr/td[@class='item']"), item--));
        }

        assertTrue(driver.findElement(By.xpath("//p/em")).isDisplayed());
    }


}
