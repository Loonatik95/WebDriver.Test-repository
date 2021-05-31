package getPropertiesOfElements;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task10 extends TestBase {

    @Test
    public void checkNavigateOnItemProductDescriptionPage() {
        ItemProduct firstProductCampaigns = new ItemProduct().getFirstItemProductCampaigns(driver);
        driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).click();
        ItemProduct fromDescriptionPage = new ItemProduct().getItemFromDescriptionPage(driver);
        assertEquals(firstProductCampaigns, fromDescriptionPage);
    }

    @Test
    public void checkPricesStyleOnItemHomePage() {
        WebElement firstPrice = driver.findElement(
                By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        WebElement secondPrice = driver.findElement(
                By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        assertTrue(elementTextIsGray(firstPrice.getCssValue("color")));
        assertEquals("line-through", firstPrice.getCssValue("text-decoration-line"));
        assertEquals("700", secondPrice.getCssValue("font-weight"));
        assertTrue(elementTextIsRed(secondPrice.getCssValue("color")));
    }

    @Test
    public void checkPricesStyleOnItemDescriptionPage() {
        driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).click();
        WebElement firstPrice = driver.findElement(By.xpath("//s[@class='regular-price']"));
        WebElement secondPrice = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
        assertTrue(elementTextIsGray(firstPrice.getCssValue("color")));
        assertEquals("line-through", firstPrice.getCssValue("text-decoration-line"));
        assertEquals("700", secondPrice.getCssValue("font-weight"));
        assertTrue(elementTextIsRed(secondPrice.getCssValue("color")));
    }

    @Test
    public void checkPricesSizeOnHomePage() {
        WebElement firstPrice = driver.findElement(
                By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        WebElement secondPrice = driver.findElement(
                By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        assertTrue(getElementTextSize(secondPrice) > getElementTextSize(firstPrice));
    }

    @Test
    public void checkPricesSizeOnItemDescriptionPage() {
        driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']")).click();
        WebElement firstPrice = driver.findElement(By.xpath("//s[@class='regular-price']"));
        WebElement secondPrice = driver.findElement(By.xpath("//strong[@class='campaign-price']"));
        assertTrue(getElementTextSize(secondPrice) > getElementTextSize(firstPrice));
    }


    private boolean elementTextIsGray(String textColor) {
        String[] rgba = textColor.substring(5, textColor.length() - 1).split(", ");
        return rgba[0].equals(rgba[1]) && rgba[1].equals(rgba[2]);
    }

    private boolean elementTextIsRed(String textColor) {
        String[] rgba = textColor.substring(5, textColor.length() - 1).split(", ");
        return !rgba[0].equals("0") && rgba[1].equals("0") && rgba[2].equals("0");
    }

    private double getElementTextSize(WebElement element) {
        String size = element.getCssValue("font-size");
        if (size.contains("em")) {
            String parentSize = element.findElement(
                    By.xpath(".//parent::div[@class='price-wrapper']")).getCssValue("font-size")
                    .replaceAll("[a-zA-Z]", "");
            double textSize = Double.parseDouble(size.replaceAll("[a-zA-Z]", ""));
            return Double.parseDouble(parentSize) * textSize;
        }
        return Double.parseDouble(size.replaceAll("[a-zA-Z]", ""));
    }
}
