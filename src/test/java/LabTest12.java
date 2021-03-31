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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LabTest12 {
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
        WebElement bootstrapListBox = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Bootstrap List Box']"));
        bootstrapListBox.click();
        WebElement requiredOption = driver.findElement(By.xpath("//div[contains(@class,'list-left')]//li[text()='Morbi leo risus']"));
        requiredOption.click();
        WebElement moveRightButton = driver.findElement(By.xpath("//button[contains(@class,'move-right')]"));
        moveRightButton.click();

        String searchText = "Morbi leo risus";
        List <WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'list-right')]//li"));

        for (WebElement option : options)
        {
            if (option.getText().equals(searchText))
            {
                option.click();
                break;
            }
        }
        //Assert.assertEquals(option.getText(), "Morbi leo risus");



        //WebElement allOptionsFromRight = driver.findElement(By.xpath("//div[contains(@class,'list-right')]//li"));
        //allOptionsFromRight.findElements(By.xpath("//div[contains(@class,'list-right')]//li[text()='Morbi leo risus']"));
        //allOptionsFromRight.click();
        //Select selector = new Select(driver.findElement(By.xpath("//div[contains(@class,'list-right')]//li")));
        //selector.selectByVisibleText("Morbi leo risus");

        //for (WebElement webElement : options) {
       //     String style = webElement.getText();
       //     Assert.assertEquals(style, "Morbi leo risus");
       //}

        //allOptionsFromRight.findElements(By.name("Morbi leo risus"));
        //allOptionsFromRight.click();
        //Assert.assertTrue(allOptionsFromRight.isDisplayed());

        //driver.quit();

    }

}
