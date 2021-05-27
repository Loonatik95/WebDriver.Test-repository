package searchElemets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task8 extends TestBaseTask8 {

    @Test
    public void chekSticker() {
        List<WebElement> card = driver.findElements(By.className("image-wrapper"));
        for (WebElement s : card) {
            Assertions.assertEquals(s.findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size(), 1);
        }
    }

}
