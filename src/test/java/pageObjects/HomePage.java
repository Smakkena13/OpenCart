package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //constructor
    public HomePage(WebDriver driver){
        super(driver);
    }

    //locators
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement btnMyAcc;
    @FindBy(xpath = "//a[text()='Register']")
    WebElement btnRegister;
    @FindBy(xpath = "//a[text()='Login']")
    WebElement btnLogin;
    @FindBy(xpath = "//input[@name='search']")
    WebElement txtSearch;
    @FindBy(xpath = "//span[@class='input-group-btn']//button")
    WebElement btnSearch;


    public void clkMyAcc(){
        btnMyAcc.click();
    }
    public void clkRegister(){
        btnRegister.click();
    }
    public void clkLogin(){
        btnLogin.click();
    }
    public void setTxtSearch(String s){
        txtSearch.sendKeys(s);
    }
    public void clkSearch(){
        btnSearch.click();
    }


}
