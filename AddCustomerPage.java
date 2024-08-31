package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }
    /*
    xPath Collections

    lnkCustomers_menu=//a[@href='#' and @class='nav-link active']
    OR
    //nav[@class='mt-2']//ul//li[4]//a[@href="#"]

    lnkCustomer_menuItem://ul[@class='nav nav-treeview']//a[@class='nav-link active']

    btnAddNew: //a[@class='btn btn-primary']
    txtEmail: //input[@id='Email']
    txtPassword: //input[@id='Password']
    txtFirstName: //input[@id='FirstName']
    txtLastName: //input[@id='LastName']
    rdoMale: //input[@id='Gender_Male']
    rdoFemale: //input[@id='Gender_Female']
    dob://input[@id='DateOfBirth']
    txtcmpnyName: //input[@id='Company']
    chboxIsTaxExempt: //input[@id='IsTaxExempt']

    skip this: txtCustomerRole: //div//span//ul[@class='select2-selection__rendered']/li[2]

    sltManagerOfVender://select[@id='VendorId']
    sltVender1://select[@id='VendorId']/option[2]

    ckbxActive://input[@id='Active']

    txtAreaAdminComment: //textarea[@id='AdminComment']

    btnSave: //button[@name='save']
     */

    By lnkCustomers_menu=By.xpath("//a[@href='#' and @class='nav-link active']");
    By lnkCustomer_menuItem=By.xpath("//ul[@class='nav nav-treeview']//a[@class='nav-link active']");

    By btnAddNew=By.xpath("//a[@class='btn btn-primary']");

    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");

    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLastName=By.xpath("//input[@id='LastName']");

    By rdoMale=By.xpath("//input[@id='Gender_Male']");
    By rdoFemale=By.xpath("//input[@id='Gender_Female']");

    By dob=By.xpath("//input[@id='DateOfBirth']");
    By txtcmpnyName=By.xpath("//input[@id='Company']");
    By chboxIsTaxExempt=By.xpath("//input[@id='IsTaxExempt']");
    By ckbxActive=By.xpath("//input[@id='Active']");

    By txtAreaAdminComment=By.xpath("//textarea[@id='AdminComment']");
    By btnSave=By.xpath("//button[@name='save']");

    public String getPageTitle()
    {
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu()
    {
        ldriver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomerMenuItem()
    {
        ldriver.findElement(lnkCustomer_menuItem).click();
    }

    public void clickOnAddNew()
    {
        ldriver.findElement(btnAddNew).click();
    }

    public void setEmail(String email)
    {
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password)
    {
        ldriver.findElement(txtPassword).sendKeys(password);
    }

   public void setGender(String gender)
   {
       if(gender.equals("Male"))
       {
           ldriver.findElement(rdoMale).click();
       } else if (gender.equals("Female"))
       {
           ldriver.findElement(rdoFemale).click();

       }else {
           ldriver.findElement(rdoMale).click();
       }
   }

   public void setFirstname(String fn)
   {
       ldriver.findElement(txtFirstName).sendKeys(fn);
   }
   public void setLastName(String ln)
   {
       ldriver.findElement(txtLastName).sendKeys(ln);
   }

   public void setDob(String dateOfBirth)
   {
       ldriver.findElement(dob).sendKeys(dateOfBirth);
   }

   public void setTxtcmpnyName(String cmpyName)
   {
       ldriver.findElement(txtcmpnyName).sendKeys(cmpyName);
   }

   public void clickOnChboxIsTaxExempt()
   {
       ldriver.findElement(chboxIsTaxExempt).click();
   }
   public void clickOnCkbxActive()
   {
       ldriver.findElement(ckbxActive).click();
   }

   public void setTxtAreaAdminComment(String txtAreaAdminCommentString)
   {
       ldriver.findElement(txtAreaAdminComment).sendKeys(txtAreaAdminCommentString);
   }

   public void clickOnBtnSave()
   {
       ldriver.findElement(btnSave).click();
   }




}
