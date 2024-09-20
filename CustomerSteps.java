package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CustomerLoginPage;

public class CustomerSteps {

    public WebDriver driver;
    public CustomerLoginPage clp;

    @Given("User Launch Firefox browser")
    public void user_launch_firefox_browser() {

        System.setProperty("webdriver.gecko.driver","C://Drivers//geckodriver-v0.35.0-win64//geckodriver.exe");
        clp=new CustomerLoginPage(driver);

    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);

    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        clp.setUserName(email);
        clp.setPassword(password);
    }
    @When("Click on Login")
    public void click_on_login() {
        clp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {

        if (driver.getPageSource().contains("Login was unsuccessful."))
        {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title,driver.getTitle());
        }

    }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        clp.clickLogout();
        Thread.sleep(3000);

    }
    @Then("close browser")
    public void close_browser() {
        driver.close();

    }

    //////////////// This is for Add New Customer /////////////////////
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {

    }
    @When("User click on customer Menu")
    public void user_click_on_customer_menu() {

    }
    @When("click on customer menu item")
    public void click_on_customer_menu_item() {

    }
    @When("click on add new button")
    public void click_on_add_new_button() {

    }
    @Then("User can view add new customer page")
    public void user_can_view_add_new_customer_page() {

    }
    @When("user enter customer info")
    public void user_enter_customer_info() {

    }
    @When("click on save button")
    public void click_on_save_button() {

    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {

    }
    @Then("User can close browser")
    public void user_can_close_browser() {

    }

}
