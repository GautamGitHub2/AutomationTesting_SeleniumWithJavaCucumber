package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_AdminUserManagementPage {
    public WebDriver ldriver;

    public OrangeHRM_AdminUserManagementPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    WebElement btn_LeftNavigation= ldriver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-left']"));
    WebElement btn_RightNavigation= ldriver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-right']"));
    WebElement txt_Admin= ldriver.findElement(By.xpath("//ul[@class='oxd-main-menu']//li[1]"));

    public void clickOnLeftNavigationButton()
    {
        btn_LeftNavigation.click();
    }

    public void clickOnRightNavigationButton()
    {
        btn_RightNavigation.click();
    }

    public void clickOnAdmin()
    {
        txt_Admin.click();
    }


}
