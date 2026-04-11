package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_LoginDD extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = Utility.DataProviders.class)
    public void testLoginDD(String email,String password,String result){
        HomePage hp=new HomePage(driver);
        hp.clkMyAcc();
        hp.clkLogin();

        LoginPage lp=new LoginPage(driver);
        lp.setTxtemail(email);
        lp.setTxtpassword(password);
        lp.clkLogin();
        MyAccountPage ap=new MyAccountPage(driver);
        boolean flag=ap.getTxtMyAcc();

        //valid ->login success  ->test pass
//              ->login failed   ->test fail

        //invalid ->login failed ->test success
//                ->login success ->test fail

        if(result.equalsIgnoreCase("valid")){
            if(flag==true){
                System.out.println("valid- Login successful");
                ap.clkLogout();
                ap.clkLogin2();
                Assert.assertTrue(true);
            }else{
                System.out.println("valid- Login failed");
                Assert.fail();
            }

        }else{
            if (flag == false) {
                System.out.println("invalid- Login failed");
                Assert.assertTrue(true);
            }else{
                System.out.println("invalid- Login success");
                Assert.assertTrue(false);
            }
        }

    }
}
