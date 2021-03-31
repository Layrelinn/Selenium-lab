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

public class LabTest4 {
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
        WebElement radioButtonsDemo = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Radio Buttons Demo']"));
        radioButtonsDemo.click();
        WebElement gender = driver.findElement(By.xpath("//label[text()='Male']/input[@name='gender']"));
        gender.click();
        WebElement ageGroup = driver.findElement(By.xpath("//label[text()='15 to 50']/input[@name='ageGroup']"));
        ageGroup.click();
        WebElement getValuesButton = driver.findElement(By.xpath("//button[text()='Get values']"));
        getValuesButton.click();
        String value = driver.findElement(By.className("groupradiobutton")).getText();
        Assert.assertEquals(value, "Sex : Female Age group: 5 - 15");

        //the next locator and assert are not correct:
        //WebElement valuesResult = driver.findElement((By.className("groupradiobutton")).getText());
        //Assert.assertEquals(valuesResult.getText(), "Sex : Female Age group: 5 - 15");

        driver.quit();

    }

}
