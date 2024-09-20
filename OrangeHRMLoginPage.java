package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {

    public WebDriver driver;

    public OrangeHRMLoginPage(WebDriver driver)
    {
        this.driver=driver;
        //PageFactory.initElements(rdriver,this);
    }

    @FindBy(name = "username")
    @CacheLookup
    WebElement txtUsername;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    public void setUsername(String UserName)
    {
        txtUsername.clear();
        txtUsername.sendKeys(UserName);
    }

    public void setPassword(String Password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(Password);
    }
}
