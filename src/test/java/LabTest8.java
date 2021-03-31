import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class LabTest8 {

    @Test

    public void Tests() {

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String correctDate = yesterday.format(formatter);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='at-cv-lightbox-content']")));
            WebElement findButton = driver.findElement(By.xpath("//a[text()='No, thanks!']"));
            findButton.click();

        } catch (Exception e) {
            System.out.println("No such button!");
        }

        WebElement datePickers = driver.findElement(By.xpath("//a[text()='Date pickers']"));
        datePickers.click();
        WebElement bootstrapDatePicker = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Bootstrap Date Picker']"));
        bootstrapDatePicker.click();
        WebElement datePicker = driver.findElement(By.xpath("//div[@id='sandbox-container1']//span[@class='input-group-addon']"));
        datePicker.click();
        WebElement dateInput = driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
        dateInput.sendKeys(correctDate);
        WebElement yesterdayDate = driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
        Assert.assertTrue(yesterdayDate.isDisplayed());

        driver.quit();

    }

}
