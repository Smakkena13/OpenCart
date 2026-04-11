package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txtMyAcc;
    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    WebElement btnLogout;
    @FindBy(xpath = "(//a[text()='Login'])[2]")
    WebElement btnLogin2;

    public boolean getTxtMyAcc(){
        return txtMyAcc.isDisplayed();
    }
    public void clkLogout(){
        btnLogout.click();
    }
    public void clkLogin2(){
        btnLogin2.click();
    }
}
