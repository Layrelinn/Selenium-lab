import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LabTest14 {
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

        WebElement listBox = driver.findElement(By.xpath("//a[text()='List Box']"));
        listBox.click();
        WebElement jQueryListBox = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='JQuery List Box']"));
        jQueryListBox.click();
        Select names = new Select(driver.findElement(By.xpath("//select[contains(@class,'pickData')]")));
        names.selectByVisibleText("Alice");
        names.selectByVisibleText("Laura");
        names.selectByVisibleText("Giovanna");
        WebElement addButton = driver.findElement(By.xpath("//div[contains(@class,'pickListButtons')]/button[text()='Add']"));
        addButton.click();
        List<WebElement> selectedNames = driver.findElements(By.xpath("//select[contains(@class,'pickListResult')]/option"));
        List<String> expectedResult = Arrays.asList("Alice", "Laura", "Giovanna");
        //don't know how to get names from the block with selected names
        Assert.assertEquals(selectedNames.toArray(), expectedResult);


        //driver.quit();

    }

}
