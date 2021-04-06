import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckMultipleCheckboxes extends BaseTest {

    private By checkboxDemo = By.xpath("//ul[@id='treemenu']//a[text()='Checkbox Demo']");
    private By optionOneSelector = By.xpath("//label[text()='Option 1']//input");
    private By optionTreeSelector = By.xpath("//label[text()='Option 3']//input");


    @Test
    public void CheckboxesSelectionTest() throws InterruptedException {

        find(inputFormsMenu).click();
        find(checkboxDemo).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(1000);

        find(optionOneSelector).click();
        find(optionTreeSelector).click();

        Assert.assertTrue(find(optionOneSelector).isSelected());
        Assert.assertTrue(find(optionTreeSelector).isSelected());

        driver.quit();

    }

}
