package YoutubeS;

import org.junit.Assert;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import static java.util.concurrent.TimeUnit.SECONDS;

public class YoutubeTest {

    WebDriver driver = new FirefoxDriver();


    @Test(priority = 1)
    public void openBrowser() {

        driver.get("https://www.youtube.com");
        Assert.assertTrue("title should be Youtube",
                driver.getTitle().contentEquals("YouTube"));
    }

    @Test(priority = 2)
    public void searchVideo() {

        HomeYoutubeTest homeYoutubeTest = new HomeYoutubeTest(driver);

        homeYoutubeTest.search.sendKeys("10 seconds video", Keys.ENTER);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Assert.assertTrue("title should be 10 seconds video",
                driver.getTitle().contentEquals("10 seconds video - YouTube"));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

        /*
        Dynamic xpath:

        .//*[@id='item-section-228376']/li[1]/div/div/div[1]/a/div/span/img (dynamic xpath)
        Removing the dynamic element and adding starts with:
        .//*[starts-with(@id,'item-section-')]

        Adding the rest of the xpath to locate the element
        /li[1]/div/div/div[1]/a/div/span/img

        Final xpath
        .//*[starts-with(@id,'item-section-')]/li[1]/div/div/div[1]/a/div/span/img
        */

    @Test(priority = 3)
    public void clickVideo() {

        HomeYoutubeTest homeYoutubeTest = new HomeYoutubeTest(driver);

        homeYoutubeTest.choose.click();

        //List<WebElement> list = driver.findElements(By.xpath(".//*[starts-with(@id,'item-section-')]/li"));
        //System.out.println(list.size());
        //list.get(0).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Test(priority = 4)
    public void checkBox() {

        HomeYoutubeTest homeYoutubeTest = new HomeYoutubeTest(driver);

        if (homeYoutubeTest.checked.isDisplayed())
            homeYoutubeTest.checkbox.click();
    }


    @Test(priority = 5)
    public void checkTime() {


        final HomeYoutubeTest homeYoutubeTest = new HomeYoutubeTest(driver);


        WebElement current = homeYoutubeTest.currentTime;
        final String duration = homeYoutubeTest.durationTime.getText();

        FluentWait<WebElement> wait = new FluentWait<WebElement>(current)
        .withTimeout(9999, SECONDS)
        .pollingEvery(1, SECONDS)

        .ignoring(NoSuchElementException.class);



        com.google.common.base.Function<WebElement, Boolean> f = new com.google.common.base.Function<WebElement, Boolean>() {
            public Boolean apply(WebElement current) {



                if (!current.getText().equals(duration)) {

                    return false;
                }
                String curren = homeYoutubeTest.currentTime.getText();

                System.out.println("Current: " + curren);
                System.out.println("Duration:" + duration);
                driver.close();
                driver.quit();
                return true;
            }
        };
        wait.until(f);
    }


}

