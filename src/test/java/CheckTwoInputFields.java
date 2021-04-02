import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTwoInputFields extends BaseTest {

    private By enterValueA = By.xpath("//input[@id='sum1']");
    private By enterValueB = By.xpath("//input[@id='sum2']");
    private By getTotalButton = By.xpath("//button[text()='Get Total']");
    private By totalSumOutput = By.xpath("//span[@id='displayvalue']");

    @Test

    public void TwoInputsTest() {

        int a = 5;
        int b = 12;
        int expectedResult = a + b;

        find(inputFormsMenu).click();
        find(simpleFormDemo).click();
        find(enterValueA).sendKeys(String.valueOf(a));
        find(enterValueB).sendKeys(String.valueOf(b));
        find(getTotalButton).click();

        int actualResult = Integer.parseInt(find(totalSumOutput).getText());

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

}
