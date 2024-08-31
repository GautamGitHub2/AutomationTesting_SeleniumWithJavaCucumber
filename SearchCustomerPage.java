package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver ldriver;
    WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
        waitHelper=new WaitHelper(ldriver);
    }

    @FindBy(how = How.ID,using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID,using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID,using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID,using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpdobMonth;

    @FindBy(how = How.ID,using = "SearchDayOfBirth")
    @CacheLookup
    WebElement drpdobDay;

    @FindBy(how = How.ID,using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.XPATH,using = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement txtCustomerRoles;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Administrators')]")
    @CacheLookup
    WebElement lstitemAdministrators;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Registered')]")
    @CacheLookup
    WebElement lstitemRegistered;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Guests')]")
    @CacheLookup
    WebElement lstitemGuests;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement lstitemVendors;

    @FindBy(how = How.ID,using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH,using = "//table[@role='grid']")
    @CacheLookup
    WebElement tblSearchResults;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']")
    WebElement table;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH,using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    //Action Methods

    public void setEmail(String email)
    {
        waitHelper.WaitForElement(txtEmail,30);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setTxtFirstName(String fn)
    {
        waitHelper.WaitForElement(txtFirstName,30);
        txtFirstName.clear();
        txtFirstName.sendKeys(fn);
    }

    public void setTxtLastName(String ln)
    {
        waitHelper.WaitForElement(txtLastName,30);
        txtLastName.clear();
        txtLastName.sendKeys(ln);
    }

    public void clickSearch()
    {
        btnSearch.click();
        waitHelper.WaitForElement(btnSearch,30);
    }
    public int getNoOfRows()
    {
        return (tableRows.size());
    }
    public int getNoOfColumns()
    {
        return (tableColumns.size());
    }

    public boolean searchCustomerByEmail(String email)
    {
        boolean flag=false; // It means email id not found
        for (int i=1;i<=getNoOfRows();i++)
        {
            String emailId=table.findElement(By.xpath("//table[@id='customer-grid']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailId);
            if(emailId.equals(email))
            {
                flag=true; // this means same email id is found
            }

        }
        return flag;
    }

    public boolean searchCustomerByName(String Name)
    {
        boolean flag=false;
        for (int i=1;i<=getNoOfRows();i++)
        {
            String name=table.findElement(By.xpath("//table[@id='customer-grid']/tbody/tr["+i+"]/td[2]")).getText();
            String names[]=name.split(" ");
            if(names[0].equals("Gautam") && names[1].equals("Kumar"))
            {
                flag=true;
            }
        }
        return flag;
    }




}
