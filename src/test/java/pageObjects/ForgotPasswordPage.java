package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{

    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtemail;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    public void enterMail(String s){
        txtemail.sendKeys(s);
    }
    public void setBtnContinue(){
        btnContinue.click();
    }
}
