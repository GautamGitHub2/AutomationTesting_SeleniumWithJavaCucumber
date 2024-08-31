package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverUtil;

public class OrangeHRMSteps {

    WebDriver driver;

    @Given("I launch safari browser")
    public void i_launch_safari_browser() {

        driver= DriverUtil.getBrowserInstance("safari");

    }

    @When("I open orange hrm homepage")
    public void i_open_orange_hrm_homepage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Then("I verify that the logo present on homepage")
    public void i_verify_that_the_logo_present_on_homepage() {

       boolean status= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(true,status);
    }

    @And("close browser")
    public void close_browser()
    {
        driver.quit();
    }

}
