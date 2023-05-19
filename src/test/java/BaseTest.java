import org.imdb.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp (){
        driver = WebDriverHolder.initDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
    }
    @AfterMethod
    public void driverQuit(){
        driver.quit();
    }
}
