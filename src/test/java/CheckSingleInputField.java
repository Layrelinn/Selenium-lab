import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckSingleInputField extends BaseTest{

    private By singleInputField = By.xpath("//input[@id='user-message']");
    private By showMessageButton = By.xpath("//button[text()='Show Message']");
    private By yourMessageOutput = By.xpath("//span[@id='display']");

    @Test
    public void SingleInputTest() {
        String expectedText = "Hello, my name is Lika";

        find(inputFormsMenu).click();
        find(simpleFormDemo).click();
        find(singleInputField).sendKeys(expectedText);
        find(showMessageButton).click();
        find(yourMessageOutput).click();

        String actualText = find(yourMessageOutput).getText();
        Assert.assertEquals(actualText, expectedText);

        driver.quit();

    }

}
