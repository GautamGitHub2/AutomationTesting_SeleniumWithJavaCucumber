package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

import java.time.Duration;

public class GumTreeSearchCars {

    public WebDriver ldriver;
    WaitHelper waitHelper;

    public GumTreeSearchCars(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
        waitHelper=new WaitHelper(ldriver);
    }

   /* @FindBy(how= How.XPATH,using = "//input[@id='search-bar-input']")
    @CacheLookup
    WebElement txtSearchBox;*/

    @FindBy(how = How.XPATH,using = "//button[@type='submit']")
    @CacheLookup
    WebElement btnSubmit;

    //Actions Methods

    public void setSearchCars(String cars) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-bar-input']")));
        element.click();
        element.sendKeys(cars);
    }
    public void setButtonSubmit() {
        //waitHelper.WaitForElement(txtSearchBox,30);
        btnSubmit.click();
    }
}
