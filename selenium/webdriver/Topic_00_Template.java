package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser()
    {
        driver = new ChromeDriver();
        driver.get("https://www.edureka.co/");
    }

    @Test
    public void TC_01_Register()
    {}

    @Test
    public void TC_02_Login()
    {}

    @AfterClass
    public void clean()
    {
        driver.quit();
    }
}
