package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC03_Logout extends BaseClass {

    @Test
    public void testLogout(){
        HomePage hp =new HomePage(driver);
        hp.clkMyAcc();
        hp.clkLogin();
        LoginPage lp=new LoginPage(driver);
        lp.setTxtemail(p.getProperty("email"));
        lp.setTxtpassword(p.getProperty("password"));
        lp.clkLogin();
        MyAccountPage ma=new MyAccountPage(driver);
        ma.clkLogout();
        LogoutPage lo=new LogoutPage(driver);
        lo.clkContinue();

        if(driver.getTitle().equals("Your Store")){
            Assert.assertEquals(driver.getTitle(),"Your Store","title is different");
        }else{
            Assert.fail();
        }
    }
}
