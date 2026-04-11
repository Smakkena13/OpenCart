package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_Login extends BaseClass {

    @Test(groups = {"regression"})
    void testLogin(){
        HomePage hp=new HomePage(driver);
        hp.clkMyAcc();
        hp.clkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setTxtemail(p.getProperty("email"));
        lp.setTxtpassword(p.getProperty("password"));
        lp.clkLogin();

        MyAccountPage ap=new MyAccountPage(driver);
        if(ap.getTxtMyAcc()==true){
            System.out.println("Login successful");
            Assert.assertTrue(true);
        }else{
            System.out.println("Login failed");
            Assert.assertEquals(ap.getTxtMyAcc(),"My Account","login failed");
        }

    }
}
