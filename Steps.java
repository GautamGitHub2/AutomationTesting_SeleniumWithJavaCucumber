package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utilities.DriverUtil;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class Steps extends BaseClass {

/*
    @Before
    public void setup() throws IOException {

        //YouTube Video Link (Reading Properties): https://www.youtube.com/watch?v=5Diuf0J4UzE&list=PLUDwpEzHYYLtHHyYv48HmWAbxsS-2iDNT&index=3
        //This is basically for Windows OS

        logger=Logger.getLogger("SeleniumWithJavaCucumberProject"); //Added logger
        PropertyConfigurator.configure("Log4j.properties"); //added logger

        //Reading properties
        configProp=new Properties();
        FileInputStream configPropfile=new FileInputStream("config.properties");
        configProp.load(configPropfile);

        //Below piece of code is for Safari Browser Only
        driver = DriverUtil.getBrowserInstance("safari");

        String br=configProp.getProperty("browser");

        if (br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
            driver=new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
            driver=new FirefoxDriver();
        } else if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
            driver=new InternetExplorerDriver();
        } else if (br.equals("msedge")) {
            System.setProperty("webdriver.msedge.driver",configProp.getProperty("msedgepath"));
            driver=new EdgeDriver();
        }

        logger.info("******* Launching Browser *******");
    }*/

    @Given("User Launch Safari browser")
    public void user_launch_safari_browser() throws IOException {

        logger=Logger.getLogger("SeleniumWithJavaCucumberProject"); //Added logger
        PropertyConfigurator.configure("Log4j.properties"); //added logger

        logger.info("******* Launching Browser *******");

        //Reading properties
        configProp=new Properties();
        FileInputStream configPropfile=new FileInputStream("config.properties");
        configProp.load(configPropfile);

        //Below piece of code is for Safari Browser Only
        driver = DriverUtil.getBrowserInstance("safari");

        lp=new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("******* Opening URL *******");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        logger.info("******* Providing login details UN & PWD *******");
        lp.setUserName(email);
        lp.setPassword(password);

    }

    @When("Click on Login")
    public void click_on_login() throws InterruptedException {
        logger.info("******* Started Login Process *******");
        lp.clickLogin();
        Thread.sleep(3000);
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        if(driver.getPageSource().contains("Login was unsuccessful."))
        {
            driver.close();
            logger.info("******* Login Passed *******");
            Assert.assertTrue(false);
        }else {
            logger.info("******* Login Failed *******");
            Assert.assertEquals(title,driver.getTitle());
        }
        Thread.sleep(3000);
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        logger.info("******* Click on logout link *******");
        Thread.sleep(3000);
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser() {
        logger.info("******* Closing Browser *******");
        driver.close();
    }

    // Add Customer feature step definations.........................

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCust=new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
    }

    @When("User click on customer Menu")
    public void user_click_on_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomersMenu();
    }

    @When("click on customer Menu Item")
    public void click_on_customer_menu_item() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomerMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        addCust.clickOnAddNew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());

    }
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        logger.info("******* Adding New Customer Info *******");
        logger.info("******* Providing customer details *******");
        String email=randomString()+"@gmail.com";
        addCust.setEmail(email);
        addCust.setPassword("test123");

        Thread.sleep(3000);

        addCust.setFirstname("Gautam");
        addCust.setLastName("Kumar");
        addCust.setDob("2/11/1992");//D/MM/YYYY
        addCust.setGender("Male");
        addCust.setTxtcmpnyName("Accenture");
        addCust.setTxtAreaAdminComment("This is for testing...");
        addCust.clickOnChboxIsTaxExempt();
        addCust.clickOnCkbxActive();

    }
    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        logger.info("Saving Customer Data *******");
        addCust.clickOnBtnSave();
        Thread.sleep(2000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
    }

    //Steps for searching a customer using email id
    @When("Enter customer Email")
    public void enter_customer_email() {
        logger.info("******* Searching Customer By Using Email Id *******");
        searchCust=new SearchCustomerPage(driver);
        searchCust.setEmail("gautam1102@gmail.com");
    }
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickSearch();
        Thread.sleep(3000);

    }
    @Then("User should found Email in the Search Table")
    public void user_should_found_email_in_the_search_table() {
        boolean status=searchCust.searchCustomerByEmail("gautam1102@gmail.com");
        Assert.assertEquals(true,status);
    }

    // Search Customer By Name

    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        logger.info("******* Searching Customer By Name *******");
        searchCust=new SearchCustomerPage(driver);
        searchCust.setTxtFirstName("Gautam");
    }
    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        searchCust.setTxtLastName("Kumar");
    }

    @Then("User should found Name in the Search Table")
    public void user_should_found_name_in_the_search_table() {
        boolean status1=searchCust.searchCustomerByName("Gautam Kumar");
        Assert.assertEquals(true,status1);

    }

    //GumTree

    @Given("User Enters Cars at the search box Gumtree")
    public void user_enters_cars_at_the_search_box_gumtree() {
        searchCars=new GumTreeSearchCars(driver);
        searchCars.setSearchCars("BMW");
    }

    @When("User click on ENTER button")
    public void user_click_on_enter_button() {
        searchCars.setButtonSubmit();
    }

    @Given("User Mouse hover at the Cars & Vehicles Grid")
    public void user_mouse_hover_at_the_cars_vehicles_grid() throws InterruptedException {
        carsAndVehicles=new GumTreeCarsAndVehicles(driver);
        carsAndVehicles.mouseHoverOverCarsAndVehicles();
        Thread.sleep(3000);

        System.out.println("user_mouse_hover_at_the_cars_vehicles_grid --> This method works...");
     }

    @When("User click on Vans link")
    public void user_click_on_vans_link() throws InterruptedException {

        carsAndVehicles.userClicksOnVansLink();

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='css-19squc8' and contains(text(),'38,242 ads Used Motorbikes and Scooters for Sale')]")).getText().contains("Used Motorbikes and Scooters for Sale"));

        System.out.println("is this working?");
    }

}
