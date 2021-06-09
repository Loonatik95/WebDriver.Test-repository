package expectations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task13 extends TestBase {

    @Test
    public void addProductOnBasket() {
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//div[@class='image-wrapper']")).click();
            WebElement item = driver.findElement(By.xpath("//span[@class='quantity']"));
            String quantityOfItemBeforeAdding = item.getText();
            addProduct();
            try {
                driver.findElement(By.linkText("View full page")).click();
            } catch (Exception e) {
            }
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']")
                    , quantityOfItemBeforeAdding)));
            driver.findElement(By.xpath("//a/i[@title='Home']")).click();
        }

        driver.findElement(By.xpath("//a[text()='Checkout »']")).click();

        WebElement buttonDeleteItem;
        while (driver.findElements(By.cssSelector("[name='remove_cart_item']")).size() != 0) {
            buttonDeleteItem = driver.findElement(By.cssSelector("[name='remove_cart_item']"));
            buttonDeleteItem.click();
            wait.until(ExpectedConditions.stalenessOf(buttonDeleteItem));
        }

        Assertions.assertTrue(driver.findElement(By.tagName("p")).getText().contains("There are no items in your cart."));
    }
}
