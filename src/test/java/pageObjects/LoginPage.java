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
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txtMyAcc;
    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    WebElement btnLogout;
    @FindBy(xpath = "(//a[text()='Login'])[2]")
    WebElement btnLogin2;


    public void setTxtemail(String e){
        txtemail.sendKeys(e);
    }
    public void setTxtpassword(String p){
        txtpassword.sendKeys(p);
    }
    public void clkLogin(){
        btnLogin.click();
    }
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
