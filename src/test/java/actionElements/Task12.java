package actionElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task12 extends TestBaseTask12 {

    @Test
    public void addNewProduct() {
        driver.findElement(By.xpath("//span[text()='Catalog']")).click();
        driver.findElement(By.xpath("//a[contains(., ' Add New Product')]")).click();
        if (!driver.findElement(By.xpath("//label[contains(text(), 'Enabled')]//input")).isSelected()) {
            driver.findElement(By.xpath("//label[contains(text(), 'Enabled')]//input")).click();
        }

        driver.findElement(By.name("name[en]")).sendKeys("Sasha");
        driver.findElement(By.name("code")).sendKeys("12345");

        if (!driver.findElement(By.xpath("//input[@data-name='Rubber Ducks']")).isSelected()) {
            driver.findElement(By.xpath("//input[@data-name='Rubber Ducks']")).click();
        }
        if (!driver.findElement(By.xpath("//input[@data-name='Subcategory']")).isSelected()) {
            driver.findElement(By.xpath("//input[@data-name='Subcategory']")).click();
        }

        if (!driver.findElement(By.xpath("(//input[@name='product_groups[]'])[3]")).isSelected()) {
            driver.findElement(By.xpath("(//input[@name='product_groups[]'])[3]")).click();
        }

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("10");


        File file = new File("src/test/resources/RedDuck.png");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate today = LocalDate.now();
        driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys(formatter.format(today));
        driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys(formatter.format(today.plusDays(10)));

        //information
        driver.findElement(By.xpath("//a[text()='Information']")).click();
        WebElement selectElem = driver.findElement(By.xpath("//select[@name='manufacturer_id']"));
        Select select = new Select(selectElem);
        select.selectByValue("1");
        driver.findElement(By.name("keywords")).sendKeys("Loonatik");
        driver.findElement(By.name("short_description[en]")).sendKeys("cool");
        driver.findElement(By.xpath("//div[@id='tab-information']/table/tbody/tr[5]/td/span/div/div[2]"))
                .sendKeys("Do not know what to say");
        driver.findElement(By.name("head_title[en]")).sendKeys("Information");
        driver.findElement(By.name("meta_description[en]")).sendKeys("Green");

        //price
        driver.findElement(By.xpath("//a[text()='Prices']")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("20");
        WebElement selectPurchasePrice = driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']"));
        Select select1 = new Select(selectPurchasePrice);
        select1.selectByVisibleText("US Dollars");
        driver.findElement(By.name("prices[USD]")).sendKeys("23");
        driver.findElement(By.name("save")).click();

        String catalogSuccessCreate = driver.findElement(By.xpath("//div[@class='notice success']")).getText();
        Assertions.assertEquals(catalogSuccessCreate, "Changes were successfully saved.");
    }
}
