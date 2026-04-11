package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC04_ForgotPassword extends BaseClass {

    @Test()
    public void testForgotPassword(){
        HomePage hp=new HomePage(driver);
        hp.clkMyAcc();
        hp.clkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.clkforgotpwd();

        ForgotPasswordPage fp=new ForgotPasswordPage(driver);
        fp.enterMail("msk13@gmail.com");
        fp.setBtnContinue();

        if(lp.txtAlert()==true){
            System.out.println("alert sent to mail");
            Assert.assertTrue(true);
        }else{
            System.out.println("alert not sent to mail");
            Assert.fail();
        }

    }
}
