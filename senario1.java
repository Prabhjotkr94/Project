package HRMselenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class senario1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        //login
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String currentURL = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        System.out.println(currentURL);

        if (currentURL.equals(expectedURL)) {
            System.out.println("Test Passed");

            //logout now
            WebElement logoutDropdown = driver.findElement(By.className("oxd-userdropdown"));
            logoutDropdown.click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            //logout
            List<WebElement> logout_button = driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']"));
            logout_button.getLast().click();

            driver.quit();
        }
        else {
            System.out.println("Test Failed");
            driver.quit();
        }

    }
}
