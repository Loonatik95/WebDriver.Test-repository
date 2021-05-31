package getPropertiesOfElements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task9_2 {
    private WebDriver driver;
    private List<WebElement> countriesElements;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Geo Zones')]")).click();
    }

    @Test
    public void testAlphabeticalOrderOfZones(){
       List<Boolean> resultForEachCountry = new ArrayList<>();
       init();
       for (int i = 0; i < countriesElements.size(); i++){
           countriesElements.get(i).click();
           List<WebElement> zoneElement = driver.findElements(
                   By.xpath("//select[contains(@name, 'zone_code')]/option[@selected='selected']"));
           List<String> zoneName = new ArrayList<>();
           for(WebElement element : zoneElement ){
              zoneName.add(element.getText());
           }
           List<String> zoneNameForSorting = new ArrayList<>(zoneName);
           Collections.sort(zoneNameForSorting);
           resultForEachCountry.add(zoneNameForSorting.equals(zoneName));
           driver.navigate().back();
           init();
       }
        Assertions.assertTrue(!resultForEachCountry.contains(false));


    }

    @AfterEach
    public void finish() {
        driver.quit();
    }

    private void init(){
        countriesElements = driver.findElements(By.xpath("//tr[@class='row']/td/a[not(@title)]"));
    }
    }
