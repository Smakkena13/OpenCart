package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='content']")
    WebElement contentbox;
    @FindBy(xpath = "(//div[@class='row'])[5]//h4")
    List<WebElement> txtProducts;
    @FindBy(xpath = "//div[@class='image']//a")
    WebElement imageclk;


    public void setContentbox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", contentbox);
    }
    public void clkImage(){
        imageclk.click();
    }
    public void totalProductstext() {
        for (WebElement e : txtProducts) {
            System.out.print(e.getText()+" ");
        }
    }

    public int productsCount(){
        return txtProducts.size();
    }


}
