package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class OrangeHRMsteps extends BaseClass {

    WebDriver driver;

    @Given("I launch FireFox browser")
    public void I_launch_FireFox_browser()
    {
        System.setProperty("webdriver.gecko.driver","C://Drivers//geckodriver-v0.35.0-win64//geckodriver.exe");
        driver=new FirefoxDriver();

    }

    @When("I open orange hrm homepage")
            public void I_open_orange_hrm_homepage()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Then("I verify that the logo present on page")
            public void I_verify_that_the_logo_present_on_page() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='orangehrm-login-branding']"))).isDisplayed();

        boolean status=driver.findElement((By.xpath("//div[@class='orangehrm-login-branding']"))).isDisplayed();
        Thread.sleep(3000);
        Assert.assertTrue(status);

    }
    @And("I close browser")
            public void I_close_browser()
    {
        driver.quit();

    }

    // Login To Orange HRM page and verify dashboard title and User dropdown icon (About)

    @Then("I login to the OrangeHRM page with Username and Password")
    public void i_login_to_the_orange_hrm_page_with_username_as_and_password_as() throws InterruptedException {

        Thread.sleep(3000);

       WebElement txt_UN= driver.findElement(By.name("username"));
       txt_UN.sendKeys("Admin");

       WebElement txt_PWD=driver.findElement(By.name("password"));
       txt_PWD.sendKeys("admin123");

       Thread.sleep(3000);
    }

    @Then("I click on Login button")
    public void i_click_on_login_button() throws InterruptedException {

        Thread.sleep(3000);
        WebElement btn_Login= driver.findElement(By.xpath("//button[@type='submit']"));
        btn_Login.click();
    }

    @Then("I verify Dashboard Title {string} at dashboard page of OrangeHRM")
    public void i_verify_dashboard_title_at_dashboard_page_of_orange_hrm(String title) {

        if(Objects.requireNonNull(driver.getPageSource()).contains("OrangeHRM"))
        {
            driver.close();
            Assert.fail();
        }else {
            Assert.assertEquals(title,driver.getTitle());
        }

    }
    @Then("I click on User Dropdown arrow")
    public void i_click_on_user_dropdown_arrow() throws InterruptedException {

        Thread.sleep(6000);
        WebElement User_Dropdown_Arrow_icon= driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
        User_Dropdown_Arrow_icon.click();

    }
    @Then("I click on About")
    public void i_click_on_about() throws InterruptedException {
        Thread.sleep(6000);
            WebElement Dropdown_Value_About = driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//li[1]"));
            Dropdown_Value_About.click();
    }

    @Then("I close About Window")
    public void i_close_about_window() throws InterruptedException {

        Thread.sleep(3000);
        WebElement btn_About_Close=driver.findElement(By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']"));
        btn_About_Close.click();
        Thread.sleep(3000);

    }
    @Then("I click on Support")
    public void i_click_on_support() throws InterruptedException {

            Thread.sleep(3000);
            WebElement Dropdown_Value_Support= driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//li[2]"));
            Dropdown_Value_Support.click();
            Thread.sleep(3000);

    }
    @Then("I click on Change Password")
    public void i_click_on_change_password() throws InterruptedException {

        Thread.sleep(3000);
        WebElement Dropdown_Value_ChangePassword= driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//li[3]"));
        Dropdown_Value_ChangePassword.click();
        Thread.sleep(3000);

    }
    @Then("I click on Logout")
    public void i_click_on_logout() throws InterruptedException {

        Thread.sleep(6000);
        WebElement Dropdown_Value_Logout= driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//li[4]"));
        Dropdown_Value_Logout.click();
        Thread.sleep(6000);

    }

    // *************** User Management *******************

    @Then("I click on Left Navigation Button")
    public void i_click_on_left_navigation_button() throws InterruptedException {

        Thread.sleep(6000);
        WebElement btn_LeftNavigation= driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-left']"));
        btn_LeftNavigation.click();
        Thread.sleep(6000);
    }
    @Then("I click on Right Navigation Button")
    public void i_click_on_right_navigation_button() throws InterruptedException {
        Thread.sleep(6000);
        WebElement btn_RightNavigation= driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-right']"));
        btn_RightNavigation.click();
        Thread.sleep(6000);
    }
    @Then("I click on Admin Menu Item")
    public void i_click_on_admin_menu_item() throws InterruptedException {
        Thread.sleep(6000);
        WebElement txt_Admin= driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//li[1]"));
        txt_Admin.click();
        Thread.sleep(6000);
    }
    @Then("I verify Admin Dashboard Title {string}")
    public void i_verify_admin_dashboard_title(String title) throws InterruptedException {
        Thread.sleep(3000);

        if (driver.getPageSource().contains("User Management"))
        {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title,driver.getTitle());
        }


    }
    //*************** Left Navigation Panel **************
    @Then("I click on Left Navigation Panel All Menu Items One By One")
    public void i_click_on_left_navigation_panel_all_menu_items_one_by_one() throws InterruptedException {
        Thread.sleep(3000);
        for (int i=1;i<=12;i++)
        {
            WebElement left_Navigation_Panel_Menu_Items= driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//li["+i+"]"));
            left_Navigation_Panel_Menu_Items.click();
            Thread.sleep(3000);

            if (i==10)
            {
                Thread.sleep(3000);
                WebElement txt_password= driver.findElement(By.name("password"));
                txt_password.sendKeys("admin123");

                WebElement btn_submit= driver.findElement(By.xpath("//button[@type='submit']"));
                btn_submit.click();
                Thread.sleep(3000);
            }
        }

    }
    //****************** Testing at Admin Page *************

    @Then("I click on Search Button")
    public void i_click_on_search_button() throws InterruptedException {
        Thread.sleep(6000);
        WebElement btn_Search= driver.findElement(By.xpath("//button[@type='submit']"));
        btn_Search.click();
        Thread.sleep(6000);

    }
    @Then("I click on Reset Button")
    public void i_click_on_reset_button() throws InterruptedException {
        Thread.sleep(6000);
        WebElement btn_Reset= driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']"));
        btn_Reset.click();
        Thread.sleep(6000);

    }
    @Then("I click on 1st Row Checkbox")
    public void i_click_on_1st_row_checkbox() throws InterruptedException {
        Thread.sleep(6000);
        WebElement top_Row_Checkbox= driver.findElement(By.xpath("//i[@class='oxd-icon bi-dash oxd-checkbox-input-icon']"));
        top_Row_Checkbox.click();
        Thread.sleep(6000);

    }
    @Then("I click on Delete Selected Button to Delete the selected row or user")
    public void i_click_on_delete_selected_button_to_delete_the_selected_row_or_user() throws InterruptedException {
        Thread.sleep(6000);
        WebElement btn_DeleteSelected= driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']"));
        btn_DeleteSelected.click();
        Thread.sleep(6000);

    }
    @Then("I click on Cancel button at the pop up window")
    public void i_click_on_cancel_button_at_the_pop_up_window() throws InterruptedException {
        Thread.sleep(3000);
        WebElement btn_pop_up_window_Cancel= driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']//button[1]"));
        btn_pop_up_window_Cancel.click();
        Thread.sleep(3000);
    }

    //************** Top Bar Menu ************

    @Then("I Navigate to Topbar Menu and Clicking Top Bar Menu One By One")
    public void i_navigate_to_topbar_menu_and_clicking_top_bar_menu_one_by_one() throws InterruptedException {
        Thread.sleep(6000);
        for (int i=1;i<=7;i++)
        {
            WebElement top_bar_menu= driver.findElement(By.xpath("//nav[@class='oxd-topbar-body-nav']//li["+i+"]"));
            top_bar_menu.click();
            Thread.sleep(6000);
        }
    }

    //************* OrangeHRM Login Test Data Driven *************

    @When("I enter Email as {string} and Password as {string}")
    public void i_enter_email_as_and_password_as(String username, String password) throws InterruptedException {

        Thread.sleep(6000);
        orangeHRMLoginPage.setUsername(username);
        orangeHRMLoginPage.setPassword(password);
        Thread.sleep(6000);

    }
}
