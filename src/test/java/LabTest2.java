import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LabTest2 extends BaseTest {

    private By enterValueA = By.xpath("//input[@id='sum1']");
    private By enterValueB = By.xpath("//input[@id='sum2']");
    private By getTotalButton = By.xpath("//button[text()='Get Total']");
    private By totalSum = By.xpath("//span[@id='displayvalue']");

    @Test

    public void Tests() {

        int a = 5;
        int b = 12;
        int expectedResult = a + b;

        find(inputFormsMenu).click();
        find(simpleFormDemo).click();
        find(enterValueA).sendKeys(String.valueOf(a));
        find(enterValueB).sendKeys(String.valueOf(b));
        find(getTotalButton).click();

        int actualResult = Integer.parseInt(find(totalSum).getText());

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

}
