package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC02_Login extends BaseClass {

    @Test()
    void testLogin(){
        HomePage hp=new HomePage(driver);
        hp.clkMyAcc();
        hp.clkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setTxtemail(p.getProperty("email"));
        lp.setTxtpassword(p.getProperty("password"));
        lp.clkLogin();
        
        if(lp.getTxtMyAcc()==true){
            System.out.println("Login successful");
            Assert.assertTrue(true);
        }else{
            System.out.println("Login failed");
            Assert.assertEquals(lp.getTxtMyAcc(),"My Account","login failed");
        }

    }
}
