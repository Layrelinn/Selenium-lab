import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LabTest3 {
    @Test

    public void Tests() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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
        WebElement checkboxDemo = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Checkbox Demo']"));
        checkboxDemo.click();

        //Thread.sleep(1000);


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");


        WebElement optionOne = driver.findElement(By.xpath("//label[text()='Option 1']//input"));
        optionOne.click();


        WebElement optionTree = driver.findElement(By.xpath("//label[text()='Option 3']//input"));
        optionTree.click();

        Assert.assertTrue(optionOne.isSelected());
        Assert.assertTrue(optionTree.isSelected());

        driver.quit();

    }

}
