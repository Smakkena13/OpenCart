package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistration extends BaseClass{

    @Test
    void testRegister(){
        HomePage hp=new HomePage(driver);
        hp.clkMyAcc();
        hp.clkRegister();
    }

}
