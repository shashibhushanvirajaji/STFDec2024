package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {

    public WebDriver webDriver = null;
    public static Properties prop;
    public static Properties locators;
    public static FileReader fileReader;
    public static FileReader locatorsReader;
   @BeforeMethod
   public void setUp() throws IOException {


        locatorsReader = new FileReader("./src/test/resources/configfiles/locators.properties");
         prop = new Properties();
        locators = new Properties();
        locators.load(locatorsReader);

        if(webDriver == null) {
            fileReader = new FileReader("./src/test/resources/configfiles/config.properties");
            prop.load(fileReader);
            if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                webDriver.get(prop.getProperty("testurl"));
            }
        }



        }


    @AfterMethod
    public void tearDown(){
   webDriver.close();

    }
}
