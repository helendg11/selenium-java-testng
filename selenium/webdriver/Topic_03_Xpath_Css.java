package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_Css {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser()
    {
        driver = new ChromeDriver();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_Register_Empty_Data(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void TC_02_Register_Invalid_Email(){
        driver.findElement(By.id("txtFirstname")).sendKeys("");
        driver.findElement(By.id("txtFirstname")).sendKeys("Automation Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@213.com@");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@213.com@");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_03_Register_Incorrect_Confirm_Email(){
        driver.findElement(By.id("txtFirstname")).sendKeys("");
        driver.findElement(By.id("txtFirstname")).sendKeys("Automation Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_04_Register_Password_Less_Than_6_Characters(){
        driver.findElement(By.id("txtFirstname")).sendKeys("");
        driver.findElement(By.id("txtFirstname")).sendKeys("Automation Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_Register_Incorrect_Confirm_Password(){
        driver.findElement(By.id("txtFirstname")).sendKeys("");
        driver.findElement(By.id("txtFirstname")).sendKeys("Automation Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123765");
        driver.findElement(By.id("txtPhone")).sendKeys("0123456789");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_05_Register_Invalid_Phone_Number(){
        driver.findElement(By.id("txtFirstname")).sendKeys("");
        driver.findElement(By.id("txtFirstname")).sendKeys("Automation Test");
        driver.findElement(By.id("txtEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0977766");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
    }

    @AfterClass
    public void clean()
    {
        driver.quit();
    }
}
