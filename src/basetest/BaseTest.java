package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    public void openBrowser() {
        // Declare the browser
        driver = new ChromeDriver();
        //Launch the BaseUrl
        driver.get(baseUrl);
        //Maximise the Window
        driver.manage().window().maximize();
        // Timeout to load the page implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void closeBrowser() {
        driver.quit();
    }


}
