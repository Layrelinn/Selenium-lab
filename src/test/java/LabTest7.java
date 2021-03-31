import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LabTest7 {

    @Test

    public void Tests() {
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

        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        inputForms.click();
        WebElement ajaxFormSubmit = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Ajax Form Submit']"));
        ajaxFormSubmit.click();
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='btn-submit']"));
        submitButton.click();
        WebElement validationError = driver.findElement(By.xpath("//span[@class='title-validation validation-error']"));
        Assert.assertTrue(validationError.isEnabled());

        driver.quit();

    }

}
