package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EachProductPage extends BasePage{

    public EachProductPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//i[@class='fa fa-exchange'])[1]")
    WebElement btnCompareproduct;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//a")
    WebElement alrtMsg;
    @FindBy(xpath = "//a[text()='product comparison']")
    WebElement lnkproductcomp;

    public void clkcompare(){
        Actions at=new Actions(driver);
        at.moveToElement(btnCompareproduct).perform();
        btnCompareproduct.click();
    }
    public String getMessage(){
        return alrtMsg.getText();
    }
    public void clkproductcopare(){
        lnkproductcomp.click();
    }

}
