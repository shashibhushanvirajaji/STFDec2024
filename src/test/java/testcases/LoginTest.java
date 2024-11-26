package testcases;

import base.BaseTest;
import objectsrepo.Homepage;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "testdata")
    public void LoginTest(String username, String password) throws InterruptedException {


        webDriver.findElement(By.xpath(locators.getProperty("link_signin"))).click();
        webDriver.findElement(By.xpath(locators.getProperty("text_login"))).sendKeys(username);
        webDriver.findElement(By.xpath(locators.getProperty("button_next"))).click();
        webDriver.findElement(By.xpath(locators.getProperty("text_password"))).sendKeys(password);
        webDriver.findElement(By.xpath(locators.getProperty("button_signin"))).click();

    }

    @DataProvider(name="testdata")
    public Object[][] loginCredentials(){
        return new Object[][]{
                {"shashi.srcon@gmail.com","Sbhushan@123"},

        };
    }
}
