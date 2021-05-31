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

public class Task9 {
    private WebDriver driver;
    private List<WebElement> countriesElements;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Countries')]")).click();
    }

    @Test
    public void testAlphabeticalOrderCountries() {
        List<WebElement> countriesElements = driver.findElements(By.xpath("//tr[@class='row']/td/a[not(@title)]"));
        List<String> countryNamesBeforeSorting = new ArrayList<>();
        for (WebElement country : countriesElements) {
            countryNamesBeforeSorting.add(country.getText());
        }
        List<String> countryNameForSorting = new ArrayList<>(countryNamesBeforeSorting);
        Collections.sort(countryNameForSorting);
        countryNamesBeforeSorting.forEach(System.out::println);
        Assertions.assertEquals(countryNameForSorting, countryNamesBeforeSorting);
    }

    @Test
    public void zones() {
        List<Boolean> resultForEachCountry = new ArrayList<>();
        init();
        for (int i = 0; i < countriesElements.size(); i++) {
            countriesElements.get(i).click();
            List<WebElement> zonesElements =
                    driver.findElements(
                            By.xpath("//table[@id]//input[contains(@name, 'name')][@type='hidden']//parent::td"));
            List<String> zonesName = new ArrayList<>();
            for (WebElement zone : zonesElements) {
                zonesName.add(zone.getText());
            }
            List<String> zoneNameForSorting = new ArrayList<>(zonesName);
            Collections.sort(zoneNameForSorting);
            resultForEachCountry.add(zoneNameForSorting.equals(zonesName));
            driver.navigate().back();
            init();
        }
        Assertions.assertTrue(!resultForEachCountry.contains(false));

    }

    private void init() {
        countriesElements = driver.findElements(
                By.xpath("//tr[@class='row']/td[6][not(text()='0')]//parent::tr//a[not(@title)]"));
    }

    @AfterEach
    public void finish() {
        driver.quit();
    }
}
