import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class ServletTest {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @After
    public void close() {
        driver.quit();
        System.out.println("Test finished");
    }

    @Test
    public void saveTest() {
        driver.get("http://localhost:8080/servlet/index.jsp");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Insert title here"));

        Random random = new Random();
        String name = String.valueOf(random.nextInt(100000000));
        String pass = String.valueOf(random.nextInt(100000000));
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.xpath("//*[contains(text(),'view persons')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + name + "')]")));
    }

}
