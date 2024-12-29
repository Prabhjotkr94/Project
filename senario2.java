package HRMselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class senario2 {

    public static void main(String[] args) {
        String user_id = "Admin";
        String user_password = "admin123";

        //create webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        //login
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys(user_id);
        System.out.println(user_id);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(user_password);
        System.out.println(user_password);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();


        //check login
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String currentURL = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(currentURL);
        if (currentURL.equals(expectedURL)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        //get print all the left side menu
        List<WebElement> menu_elem = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li//span"));
        System.out.println(menu_elem);
        menu_elem.stream().forEach(elem -> System.out.println("element " + elem.getText()));

        //go to admin page
        menu_elem.get(0).click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //find input boxes 1) Username 2) Empoyee Name
        List<WebElement> usernames_elemts = driver.findElements(By.xpath("//div[@class='oxd-table-filter']//input"));
        //System.out.println(usernames_elemts);
        //search admin
        usernames_elemts.getFirst().sendKeys("Admin");

        //click_search (make a function)
        WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
        search.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //record found print
        WebElement record_elem = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span"));
        System.out.println(record_elem.getText());

        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //dropdown click
        WebElement user_role_dropdown = driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        user_role_dropdown.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MICROSECONDS);

        //dropdown element click 'Admin'
        List<WebElement> user_role_admin_click = driver.findElements(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div"));
        System.out.println(user_role_admin_click);
        user_role_admin_click.get(1).click();

        //click_search (make a function)
        WebElement search1 = driver.findElement(By.xpath("//button[@type='submit']"));
        search1.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //record found print
        WebElement record_elem1 = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span"));
        System.out.println(record_elem1.getText());

        driver.navigate().refresh();


        //go to status dropdown
        List<WebElement> status_dropdown = driver.findElements(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
        status_dropdown.getLast().click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MICROSECONDS);


        //dropdown element click 'Enable'
        List<WebElement> status_click_dropdown = driver.findElements(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div"));
        //System.out.println(user_role_admin_click);
        status_click_dropdown.get(1).click();

        //click_search (make a function)
        WebElement search2 = driver.findElement(By.xpath("//button[@type='submit']"));
        search2.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //record found print
        WebElement record_elem2 = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span"));
        System.out.println(record_elem2.getText());

        driver.navigate().refresh();

        driver.close();
    }
}
