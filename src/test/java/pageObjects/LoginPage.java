package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtemail;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtpassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text()='Forgotten Password']")
    WebElement linkforgotpwd;
    @FindBy(xpath = "//div[contains(text(),'confirmation')]")
    WebElement txtalert;


    public void setTxtemail(String e){
        txtemail.sendKeys(e);
    }
    public void setTxtpassword(String p){
        txtpassword.sendKeys(p);
    }
    public void clkLogin(){
        btnLogin.click();
    }
    public void clkforgotpwd(){
        linkforgotpwd.click();
    }
    public boolean txtAlert(){
        return txtalert.isDisplayed();
    }

}
