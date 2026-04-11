package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

//@Listeners(Utility.ExtentReportManager.class)
public class TC01_AccountRegistration extends BaseClass{

    @Test(groups = "sanity")
    void testRegister(){
        HomePage hp=new HomePage(driver);
        hp.clkMyAcc();
        hp.clkRegister();

        RegistrationPage rp=new RegistrationPage(driver);
        rp.firstname(randomString());
        rp.lastname(randomString());
        rp.email(randomAlphaNum()+"@gmail.com");
        rp.telephone(randomNumeric());
        String pwd=randomAlphaNum();
        rp.password(pwd);
        rp.cnfpassword(pwd);
        rp.policy();
        rp.submit();

        if(rp.Msg().equals("Your Account Has Been Created!")){
            System.out.println("Account registration successful");
            Assert.assertTrue(true);
        }else {
            System.out.println("Account registration failed");
            log.error("Account creation failed");
            Assert.fail();
        }
    }

}
