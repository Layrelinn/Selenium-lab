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

public class LabTest9 {
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

        WebElement table = driver.findElement(By.xpath("//a[text()='Table']"));
        table.click();
        WebElement tableDataSearch = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Table Data Search']"));
        tableDataSearch.click();
        WebElement input = driver.findElement(By.xpath("//input[@id='task-table-filter']"));
        input.click();
        input.sendKeys("Emily John");
        WebElement output = driver.findElement(By.xpath("//table[@id='task-table']//td[text()='Emily John']"));
        Assert.assertTrue(output.isDisplayed());

        driver.quit();

    }
}
