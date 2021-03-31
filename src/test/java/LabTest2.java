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

public class LabTest2 {

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
        WebElement simpleFormDemo = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']"));
        simpleFormDemo.click();
        int a = 5;
        int b = 12;
        WebElement enterA = driver.findElement(By.xpath("//input[@id='sum1']"));
        enterA.click();
        enterA.sendKeys(String.valueOf(a));
        WebElement enterB = driver.findElement(By.xpath("//input[@id='sum2']"));
        enterB.click();
        enterB.sendKeys(String.valueOf(b));
        WebElement getTotal = driver.findElement(By.xpath("//button[text()='Get Total']"));
        getTotal.click();
        WebElement totalSum = driver.findElement(By.xpath("//span[@id='displayvalue']"));
        int c = Integer.parseInt(totalSum.getText());
        Assert.assertEquals(c, 17);

        driver.quit();

    }

}
