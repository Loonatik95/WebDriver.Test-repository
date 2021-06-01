package actionElements;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task11 extends TestBaseTask11 {

    private User user = new User("Sasha", "Karapuz",
            "karapuzikst@tut.by", "171820");

    @Order(1)
    @Test
    public void newCustomers() {
        buttonNewCustomers();
        createAccount(user);
        String textAccountCreated = driver.findElement(By.xpath("//div[@id='notices']/div")).getText();
        Assertions.assertEquals(textAccountCreated, "Your customer account has been created.");
        logout();


    }

    @Order(2)
    @Test
    public void login() {
        driver.findElement(By.name("email")).sendKeys(user.getEmail());
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.name("login")).click();
        String textLogged = driver.findElement(By.xpath("//div[@id='notices']/div")).getText();
        Assertions.assertEquals(textLogged, "You are now logged in as "
                + user.getFirstname() + " " + user.getLastname() + ".");
        logout();
    }

}
