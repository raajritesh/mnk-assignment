import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Listeners(utils.TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    //Launching the browser
    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //Maximizing the browser
        driver.manage().window().maximize();
        //Opening application
        driver.get("https://www.saucedemo.com/");
    }

    //Closing the browser
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    } } 