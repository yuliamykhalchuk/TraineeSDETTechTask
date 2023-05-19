import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImdbTests extends BaseTest{

    @Test
    public void movieSearchByTitle() {
        Assert.assertEquals("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows", driver.getTitle());
        driver.findElement(By.id("suggestion-search")).sendKeys("Back to the future");
        WebElement searchItem = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='react-autowhatever-navSuggestionSearch--item-0']/a")));
        searchItem.click();
        WebElement movieDescription = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='plot-xl']")));
        Assert.assertEquals("Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the eccentric scientist Doc Brown.", movieDescription.getText());
    }
}
