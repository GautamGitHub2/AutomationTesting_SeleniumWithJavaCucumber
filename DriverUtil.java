package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverUtil {
    public static WebDriver getBrowserInstance(String browserName)
    {


        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
            return new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver");
            return new FirefoxDriver();
        }
        else if (browserName.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver","src/test/resources/drivers/IEDriverServer");
            return new InternetExplorerDriver();
        }
        else if (browserName.equals("safari"))
        {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        }
        else
        {
            return null;
        }
    }
}
