package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EachProductPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC06_ProductCompare extends BaseClass {
    @Test
    public void testProductCompare() throws InterruptedException {
        HomePage ho=new HomePage(driver);
        String search="iMac";
        ho.setTxtSearch(search);
        ho.clkSearch();

        SearchPage sp=new SearchPage(driver);
        sp.setContentbox();
        if(sp.productsCount()>0){
            System.out.println("products found");
            sp.clkImage();
            EachProductPage rp=new EachProductPage(driver);
            rp.clkcompare();
            String msg=rp.getMessage();
            System.out.println("msg :"+msg);
            if(msg.equalsIgnoreCase(search)){
                System.out.println("alert displayed= product compared");
                rp.clkproductcopare();
                if(driver.getTitle().equalsIgnoreCase("Product Comparison")){
                    System.out.println("on product comp page");
                    Assert.assertTrue(true);
                }else{
                    System.out.println("not on product comp page");
                    Assert.fail();
                }
            }else{
                System.out.println("alert not displayed= product not compared");
                Assert.fail();
            }

        }else{
            System.out.println("no products found");
            Assert.fail();
        }
    }
}
