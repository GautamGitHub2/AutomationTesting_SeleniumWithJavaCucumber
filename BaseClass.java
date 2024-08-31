package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.util.Properties;
import java.util.logging.Logger;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCust;
    public GumTreeSearchCars searchCars;
    public GumTreeCarsAndVehicles carsAndVehicles;
    public static Logger logger;
    public Properties configProp;

    //Created for generating random string for Unique email
    public static String randomString()
    {
        String generatedString1= RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }

}
