package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser()
    {
        driver = new ChromeDriver();
        driver.get("https://www.edureka.co/");
    }

    @Test
    public void TC_01_Relative_Locator(){
        driver.findElement(By.id(""));
    }

    @Test
    public void TC_02_Login()
    {}

    @AfterClass
    public void clean()
    {
        driver.quit();
    }
}
