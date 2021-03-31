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

public class LabTest6 {
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
        WebElement selectDropdownList = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Select Dropdown List']"));
        selectDropdownList.click();
        WebElement selectNewYork = driver.findElement(By.xpath("//select[@id='multi-select']/option[text()='New York']"));
        selectNewYork.click();
        WebElement selectFlorida = driver.findElement(By.xpath("//select[@id='multi-select']/option[text()='Florida']"));
        selectFlorida.click();
        WebElement getAllSelected = driver.findElement(By.xpath("//button[@id='printAll']"));
        getAllSelected.click();
        WebElement printedResult = driver.findElement(By.xpath("//p[@class='getall-selected']"));
        Assert.assertTrue(printedResult.isDisplayed());

        driver.quit();

    }

}
