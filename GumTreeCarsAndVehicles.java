package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

import java.time.Duration;

public class GumTreeCarsAndVehicles {

    public WebDriver ldriver;
    WaitHelper waitHelper;

    public GumTreeCarsAndVehicles(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
        waitHelper=new WaitHelper(ldriver);
    }

    By CarsAndVehiclesGrid= By.xpath("//a[@href='/cars-vans-motorbikes/cars']/span");
    By VansLink=By.xpath("//ul[@data-q='category-column-panel']//li[2]//a[contains(text(),'Motorbikes & Scooters')]");

    //Actions Methods

    public void mouseHoverOverCarsAndVehicles()
    {
        Actions actions=new Actions(ldriver);
        actions.moveToElement(ldriver.findElement(CarsAndVehiclesGrid))
                .moveToElement(ldriver.findElement(VansLink))
                .click().build().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Try catch");

    }

    public void userClicksOnVansLink()
    {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(VansLink));
        element.click();

    }
}
