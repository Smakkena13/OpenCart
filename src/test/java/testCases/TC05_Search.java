package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC05_Search extends BaseClass {

    @Test
    public void testSearch(){
        HomePage ho=new HomePage(driver);
        String search="mac0";
        ho.setTxtSearch(search);
        ho.clkSearch();

        SearchPage sp=new SearchPage(driver);
        sp.setContentbox();
        if(sp.productsCount()>0){
            System.out.println("products found");
            sp.totalProductstext();
            Assert.assertTrue(true);
        }else{
            System.out.println("no products found");
            Assert.fail();
        }

    }
}
