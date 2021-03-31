import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LabTest1 extends BaseTest{

    private By inputFormsMenu = By.xpath("//a[text()='Input Forms']");
    private By simpleFormDemo = By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']");
    private By singleInputField = By.xpath("//input[@id='user-message']");
    private By showMessageButton = By.xpath("//button[text()='Show Message']");
    private By yourMessageOutput = By.xpath("//span[@id='display']");

    @Test

    public void Tests() {
        String expectedText = "Hello, my name is Lika";

        find(inputFormsMenu).click();
        find(simpleFormDemo).click();
        find(singleInputField).click();
        find(singleInputField).sendKeys(expectedText);
        find(showMessageButton).click();
        find(yourMessageOutput).click();

        String actualText = find(yourMessageOutput).getText();
        Assert.assertEquals(actualText, expectedText);

        driver.quit();



//        WebElement inputForms = driver.findElement(By.xpath("//a[text()='Input Forms']"));
//        inputForms.click();
//        WebElement simpleFormDemo = driver.findElement(By.xpath("//ul[@id='treemenu']//a[text()='Simple Form Demo']"));
//        simpleFormDemo.click();
//        WebElement singleInputField = driver.findElement(By.xpath("//input[@id='user-message']"));
//        singleInputField.click();
//        singleInputField.sendKeys(expectedText);
//        WebElement showMessage = driver.findElement(By.xpath("//button[text()='Show Message']"));
//        showMessage.click();
//        WebElement yourMessage = driver.findElement(By.xpath("//span[@id='display']"));
//        Assert.assertEquals(yourMessage.getText(), expectedText);
//
//        driver.quit();

    }

}
