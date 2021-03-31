import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTestByOleg {

    protected WebDriver driver;
    protected By inputFormMenuItem = By.xpath("//a[text()='Input Forms']");
    protected By simpleFormDemoMenuItem = By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']");

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/");
        closeAdv();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }

    private void closeAdv() {
        try {
            WebElement exit = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='at-cv-lightbox-close']")));
            exit.click();
        } catch (NoSuchElementException e) {
            System.out.println("No any adv appears");
        }
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void pickFromSelect(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public String getPartOfString(String originalString, String regex, int index) {
        String[] strings = originalString.split(regex);
        return strings[index];
    }

    public void scrollToElementWithJS(WebElement element) throws InterruptedException {
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }

    public void waitUntilVisibility(By locator, int... time) {
        int waitTime = time.length > 0 ? time[0] : 5;
        new WebDriverWait(driver, waitTime)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getYesterdayDateInFormat(String format) {
        //"dd/MM/yyyy"
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String validFormat = yesterday.format(formatter);
        return validFormat;
    }

    public int getYesterdayDay() {
        //"dd/MM/yyyy"
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        return yesterday.getDayOfMonth();
    }

}
