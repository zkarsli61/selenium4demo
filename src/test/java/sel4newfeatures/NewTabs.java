package sel4newfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class NewTabs {

    @Test
    public void newTabsTest() throws IOException, InterruptedException {
        //creating selenium driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //opening google on teh first tab
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        String googleHandle=driver.getWindowHandle();

        //NEW WITH SELENIUM 4- opening a new TAB and going to linkedin
//        WebDriver tab2 = driver.switchTo().newWindow(WindowType.TAB);
//        tab2.get("https://www.linkedin.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        System.out.println(driver.getTitle());
        String linkedinHandle=driver.getWindowHandle();

        //NEW WITH SELENIUM 4- opening a new TAB and going to amazon
//        WebDriver tab3 = driver.switchTo().newWindow(WindowType.TAB);
//        tab2.get("https://www.amazon.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        String amazonHandle=driver.getWindowHandle();

        //switching between the tabs
        Thread.sleep(2000);
        driver.switchTo().window(linkedinHandle);
        System.out.println("LINKEDIN : "+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));

        Thread.sleep(2000);
        driver.switchTo().window(googleHandle);
        System.out.println("GOOGLE : "+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));

        Thread.sleep(2000);
        driver.switchTo().window(amazonHandle);
        System.out.println("AMAZON : "+driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

    }
}
