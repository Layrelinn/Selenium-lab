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

public class LabTest11 {
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

        WebElement alertsModals = driver.findElement(By.xpath("//a[text()='Alerts & Modals']"));
        alertsModals.click();
        WebElement javascriptAlerts = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Javascript Alerts']"));
        javascriptAlerts.click();
        WebElement clickMeButton = driver.findElement(By.xpath("//p[@id='confirm-demo']/preceding-sibling::button"));
        clickMeButton.click();
        driver.switchTo().alert().dismiss();
        WebElement textAppears = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']"));
        Assert.assertEquals(textAppears.getText(), "You pressed Cancel!");

        driver.quit();

    }

}