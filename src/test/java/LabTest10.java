import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LabTest10 {
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
        WebElement tableFilter = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Table Filter ']"));
        tableFilter.click();
        WebElement orangeButton = driver.findElement(By.xpath("//div[@class='pull-right']//button[text()='Orange']"));
        orangeButton.click();
        List<WebElement> list = driver.findElements(By.xpath("//table [@class='table table-filter']//*[@style='color:orange;']"));

        for (WebElement webElement : list) {
            String style = webElement.getAttribute("style");
            Assert.assertEquals(style, "color:orange;");
        }

        driver.quit();

    }

}
