package YoutubeS;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomeYoutubeTest {

    WebDriver driver;

    @FindBy(xpath=".//*[@id='masthead-search-term']")
    WebElement search;

    @FindBy(xpath=".//*[starts-with(@id,'item-section-')]/li[1]/div/div/div[1]/a/div/span/img")
    WebElement choose;

    @FindBy (xpath=".//*[@id='autoplay-checkbox-label']/span[1]")
    WebElement checked;
    @FindBy (xpath=".//*[@id='autoplay-checkbox']")
    WebElement checkbox;

    @FindBy (className= "ytp-time-current")
    WebElement currentTime;

    @FindBy (className= "ytp-time-duration")
    WebElement durationTime;

    @FindBy (className = "ytp-endscreen-content")
    WebElement endScreen;
    
    
    public HomeYoutubeTest (WebDriver driver){

        this.driver = driver;
        System.out.println("Homepage object has been created");

        // When the object is created, all of the variables will be set up

        PageFactory.initElements(driver, this);
    }
}
