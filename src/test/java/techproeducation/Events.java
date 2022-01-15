package techproeducation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Events {
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com/events");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='meeting-card-content']/h3/a"));
        String mainPage = driver.getWindowHandle();

        List<String> links = elements.stream().map(x -> x.getAttribute("href")).collect(Collectors.toList());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ytp-caption-window-container']")));

        for (String link : links) {
            driver.get(link);
            driver.switchTo().frame(0);
            try {
                if (driver.findElement(By.xpath("//div[@class='ytp-title-text']")).getText().isEmpty())
                    System.out.println(link);
            } catch (Exception e) {
                System.out.println(link);
            }
        }
    }
}
