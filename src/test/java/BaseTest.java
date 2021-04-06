import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected By inputFormsMenu = By.xpath("//a[text()='Input Forms']");
    protected By simpleFormDemo = By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']");

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
        closeAdv();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }

    private void closeAdv() {
        try {
            WebElement exit = new WebDriverWait(driver, 60)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']")));
            exit.click();

        } catch (Exception e) {
            System.out.println("Can't find the pop-up to close!");
        }

    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

}
